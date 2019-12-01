package org.daqiao.taskflow;

import org.daqiao.entity.TaskRecord;
import org.daqiao.entity.TaskStepRecord;

/**
 * @Author : saizhang
 * @Date : 2019/12/01
 * @Time : 20:23
 * @Description : TODO
 */
public interface TaskCallback {
    void taskInitial(TaskRecord taskRecord);
    void taskStep(TaskStepRecord taskStepRecord);
    void taskComplete(TaskRecord taskRecord);
}
