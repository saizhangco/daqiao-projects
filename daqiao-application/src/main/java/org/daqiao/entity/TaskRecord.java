package org.daqiao.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author : saizhang
 * @Date : 2019/12/02
 * @Time : 20:48
 * @Description : TODO
 */
@Entity
@Table(name = "t_task_record")
@Data
public class TaskRecord {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 任务编号
     */
    private String taskId;
    /**
     * 任务类型
     */
    private String taskType;
    /**
     * 任务执行结果
     */
    private String taskResult;
    /**
     * 任务开始时间
     */
    private Date taskStartTime;
    /**
     * 任务时间间隔
     */
    private Long taskTimeInterval;
    /**
     * 任务需要执行的步骤
     */
    private Integer taskStepSize;
}
