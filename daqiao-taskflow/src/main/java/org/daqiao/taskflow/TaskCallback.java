package org.daqiao.taskflow;

import org.daqiao.model.TaskRecord;
import org.daqiao.model.TaskStepRecord;

/**
 * @Author : saizhang
 * @Date : 2019/12/01
 * @Time : 20:23
 * @Description : 任务执行，回调函数
 */
public interface TaskCallback {
    /**
     * 任务初始化
     * @param taskRecord
     */
    void taskInitial(TaskRecord taskRecord);

    /**
     * 任务步骤执行
     * @param taskStepRecord
     */
    void taskStep(TaskStepRecord taskStepRecord);

    /**
     * 任务完成
     * @param taskRecord
     */
    void taskComplete(TaskRecord taskRecord);
}
