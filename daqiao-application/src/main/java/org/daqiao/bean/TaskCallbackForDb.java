package org.daqiao.bean;

import org.daqiao.entity.TaskRecord;
import org.daqiao.entity.TaskStepRecord;
import org.daqiao.taskflow.TaskCallback;
import org.springframework.stereotype.Component;

/**
 * @Author : saizhang
 * @Date : 2019/12/01
 * @Time : 20:35
 * @Description : TODO
 */
@Component
public class TaskCallbackForDb implements TaskCallback {
    @Override
    public void taskInitial(TaskRecord taskRecord) {
        System.out.println("taskInitial => " + taskRecord.getTaskId());
    }

    @Override
    public void taskStep(TaskStepRecord taskStepRecord) {
        System.out.println("taskStep => " + taskStepRecord.getTaskId());
    }

    @Override
    public void taskComplete(TaskRecord taskRecord) {
        System.out.println("taskComplete => " + taskRecord.getTaskId());
    }
}
