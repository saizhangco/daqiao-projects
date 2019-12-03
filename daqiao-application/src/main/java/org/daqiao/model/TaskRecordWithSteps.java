package org.daqiao.model;

import lombok.Data;
import org.daqiao.entity.TaskRecord;
import org.daqiao.entity.TaskStepRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : saizhang
 * @Date : 2019/12/03
 * @Time : 21:46
 * @Description : TODO
 */
@Data
public class TaskRecordWithSteps extends TaskRecord {
    private List<TaskStepRecord> stepRecordList = new ArrayList<>();

    public TaskRecordWithSteps(org.daqiao.entity.TaskRecord taskRecord) {
        setId(taskRecord.getId());
        setTaskId(taskRecord.getTaskId());
        setTaskType(taskRecord.getTaskType());
        setTaskResult(taskRecord.getTaskResult());
        setTaskStartTime(taskRecord.getTaskStartTime());
        setTaskTimeInterval(taskRecord.getTaskTimeInterval());
        setTaskStepSize(taskRecord.getTaskStepSize());
    }
}
