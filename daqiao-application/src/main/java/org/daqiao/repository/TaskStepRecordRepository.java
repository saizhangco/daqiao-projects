package org.daqiao.repository;

import org.daqiao.entity.TaskStepRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author : saizhang
 * @Date : 2019/12/02
 * @Time : 20:55
 * @Description : 任务步骤DAO
 */
@Repository
public interface TaskStepRecordRepository extends CrudRepository<TaskStepRecord, Long> {
    /**
     * 获取任务步骤列表，通过taskId
     * @param taskId
     * @return
     */
    List<TaskStepRecord> findAllByTaskId(String taskId);
}
