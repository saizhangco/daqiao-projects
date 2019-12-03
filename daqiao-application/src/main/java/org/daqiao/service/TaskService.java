package org.daqiao.service;

import org.daqiao.model.TaskRecordWithSteps;

/**
 * @Author : saizhang
 * @Date : 2019/12/03
 * @Time : 21:51
 * @Description : TODO
 */
public interface TaskService {
    TaskRecordWithSteps getTaskInfo(String taskId);
}
