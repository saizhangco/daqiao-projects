package org.daqiao.service.impl;

import org.daqiao.entity.TaskRecord;
import org.daqiao.entity.TaskStepRecord;
import org.daqiao.model.TaskRecordWithSteps;
import org.daqiao.repository.TaskRecordRepository;
import org.daqiao.repository.TaskStepRecordRepository;
import org.daqiao.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author : saizhang
 * @Date : 2019/12/03
 * @Time : 21:52
 * @Description : TODO
 */
@Component
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRecordRepository taskRecordRepository;

    @Autowired
    private TaskStepRecordRepository taskStepRecordRepository;

    @Override
    public TaskRecordWithSteps getTaskInfo(String taskId) {
        TaskRecord taskRecord = taskRecordRepository.findByTaskId(taskId);
        if( taskRecord == null ) {
            return null;
        }
        TaskRecordWithSteps result = new TaskRecordWithSteps(taskRecord);
        List<TaskStepRecord> stepRecordList = taskStepRecordRepository.findAllByTaskId(taskId);
        result.getStepRecordList().addAll(stepRecordList);
        return result;
    }
}
