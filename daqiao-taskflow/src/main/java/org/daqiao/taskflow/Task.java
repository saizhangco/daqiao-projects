package org.daqiao.taskflow;

import org.daqiao.model.TaskRecord;
import org.daqiao.model.TaskStepRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author : saizhang
 * @Date : 2019/12/01
 * @Time : 17:49
 * @Description : 任务核心类
 */
@Component
@Scope("prototype")
public class Task {

  private TaskSession session = new TaskSession();
  private String taskId = UUID.randomUUID().toString();
  private boolean allowAddTask = true;

  @Autowired
  private TaskRepository taskRepository;

  public void addTask(String step) {
      if (allowAddTask) {
          session.addStep(step);
      } else {
          throw new RuntimeException("[" + taskId + "] not allow add task step[" + step + "].");
      }
  }

  public void addTask(Class clazz, String methodName) {
      addTask(clazz.getName() + ":" + methodName);
  }

  public void executeAll(String taskType) {
      allowAddTask = false;
      TaskRecord taskRecord = new TaskRecord();
      taskRecord.setId(null);
      taskRecord.setTaskId(taskId);
      taskRecord.setTaskType(taskType);
      taskRecord.setTaskResult("未知");
      Date startTime = new Date();
      taskRecord.setTaskStartTime(startTime);
      taskRecord.setTaskTimeInterval(0L);
      taskRecord.setTaskStepSize(session.getStepList().size());
      // 将task的初始化信息保存到数据库
      taskRepository.taskInitial(taskRecord);


      boolean taskResult = true;
      StopWatch stopWatch = new StopWatch();
      stopWatch.start();
      while (session.isContinue()) {
          String step = session.getStepList().get(session.getStepCounter());
          Object object = taskRepository.getClass(step);
          Method method = taskRepository.getMethod(step);
          StepResult result;
          if (method != null) {
              try {
                  result = (StepResult) method.invoke(object, session);
              } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
                  result = new StepResult(false, "", e.toString());
              }
          } else {
              if (object == null) {
                  result = new StepResult(false, "", "[" + step + "] class not found.");
              } else {
                  result = new StepResult(false, "", "[" + step + "] method not found.");
              }
          }
          // 将返回结果保存到数据库
          TaskStepRecord stepRecord = new TaskStepRecord();
          stepRecord.setId(null);
          stepRecord.setTaskId(taskId);
          stepRecord.setStepNo(session.getStepCounter() + 1);
          stepRecord.setStepName(result.getStepName());
          stepRecord.setStepResult(result.getStepResult());
          // 插入数据库
          taskRepository.taskStepExecute(stepRecord);
          if (!result.isContinue()) {
              taskResult = false;
              break;
          }
          session.incrementCounter();
      }
      stopWatch.stop();
      // 更新task数据保存的信息，通过taskId
      taskRecord.setTaskResult(taskResult ? "成功" : "失败");
      taskRecord.setTaskTimeInterval(stopWatch.getTotalTimeMillis());
      // 插入数据库
      taskRepository.taskComplete(taskRecord);
  }
}
