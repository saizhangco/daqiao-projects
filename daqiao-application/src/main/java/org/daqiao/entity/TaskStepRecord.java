package org.daqiao.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author : saizhang
 * @Date : 2019/12/02
 * @Time : 20:52
 * @Description : TODO
 */
@Entity
@Table(name = "t_task_step_record")
@Data
public class TaskStepRecord {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
