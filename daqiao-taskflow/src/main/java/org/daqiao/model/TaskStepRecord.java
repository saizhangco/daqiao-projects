package org.daqiao.model;

import lombok.Data;

/**
 * @Author : saizhang
 * @Date : 2019/12/01
 * @Time : 18:00
 * @Description : TODO
 */
@Data
public class TaskStepRecord {
    /**
     * 编号
     */
    private Integer id;
    /**
     * 任务编号
     */
    private String taskId;
    /**
     * 步骤编号
     */
    private Integer stepNo;
    /**
     * 步骤名称
     */
    private String stepName;
    /**
     * 步骤执行的结果
     */
    private String stepResult;
}
