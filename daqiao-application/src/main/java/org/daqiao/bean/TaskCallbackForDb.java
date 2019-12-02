package org.daqiao.bean;

import org.daqiao.model.TaskRecord;
import org.daqiao.model.TaskStepRecord;
import org.daqiao.repository.TaskRecordRepository;
import org.daqiao.repository.TaskStepRecordRepository;
import org.daqiao.taskflow.TaskCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author : saizhang
 * @Date : 2019/12/01
 * @Time : 20:35
 * @Description : TODO
 */
@Component
public class TaskCallbackForDb implements TaskCallback {

    @Autowired
    private TaskRecordRepository taskRecordRepository;

    @Autowired
    private TaskStepRecordRepository taskStepRecordRepository;

    @Override
    public void taskInitial(TaskRecord taskRecord) {
        System.out.println("taskInitial => " + taskRecord.getTaskId());
        org.daqiao.entity.TaskRecord record = new org.daqiao.entity.TaskRecord();
        record.setId(null);
        record.setTaskId(taskRecord.getTaskId());
        record.setTaskType(taskRecord.getTaskType());
        record.setTaskResult(taskRecord.getTaskResult());
        record.setTaskStartTime(taskRecord.getTaskStartTime());
        record.setTaskTimeInterval(taskRecord.getTaskTimeInterval());
        record.setTaskStepSize(taskRecord.getTaskStepSize());
        taskRecordRepository.save(record);
    }

    @Override
    public void taskStep(TaskStepRecord taskStepRecord) {
        System.out.println("taskStep => " + taskStepRecord.getTaskId());
        org.daqiao.entity.TaskStepRecord stepRecord = new org.daqiao.entity.TaskStepRecord();
        stepRecord.setId(null);
        stepRecord.setTaskId(taskStepRecord.getTaskId());
        stepRecord.setStepNo(taskStepRecord.getStepNo());
        stepRecord.setStepName(taskStepRecord.getStepName());
        stepRecord.setStepResult(taskStepRecord.getStepResult());
        taskStepRecordRepository.save(stepRecord);
    }

    @Override
    public void taskComplete(TaskRecord taskRecord) {
        System.out.println("taskComplete => " + taskRecord.getTaskId());
        org.daqiao.entity.TaskRecord record = taskRecordRepository.findByTaskId(taskRecord.getTaskId());
        record.setTaskResult(taskRecord.getTaskResult());
        record.setTaskTimeInterval(taskRecord.getTaskTimeInterval());
        taskRecordRepository.save(record);
    }
}
