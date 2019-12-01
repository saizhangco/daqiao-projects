package org.daqiao.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author : saizhang
 * @Date : 2019/12/01
 * @Time : 17:55
 * @Description : TODO
 */
@Data
public class TaskRecord {
    /**
     * ID
     */
    private Integer id;
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
