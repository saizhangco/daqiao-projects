package org.daqiao.repository;

import org.daqiao.entity.TaskRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author : saizhang
 * @Date : 2019/12/02
 * @Time : 20:54
 * @Description : TODO
 */
@Repository
public interface TaskRecordRepository extends CrudRepository<TaskRecord, Long> {
    /**
     * 查询，通过TaskId
     * @param taskId
     * @return
     */
    TaskRecord findByTaskId(String taskId);
}
