package org.daqiao.repository;

import org.daqiao.entity.TaskStepRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author : saizhang
 * @Date : 2019/12/02
 * @Time : 20:55
 * @Description : TODO
 */
@Repository
public interface TaskStepRecordRepository extends CrudRepository<TaskStepRecord, Long> {
}
