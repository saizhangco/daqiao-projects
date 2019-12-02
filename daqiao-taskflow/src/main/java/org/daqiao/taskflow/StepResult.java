package org.daqiao.taskflow;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author : saizhang
 * @Date : 2019/12/01
 * @Time : 17:45
 * @Description : 步骤执行结果
 */
@Data
@AllArgsConstructor
public class StepResult {
    private boolean isContinue;
    private String stepName;
    private String stepResult;
}
