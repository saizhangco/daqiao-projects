package org.daqiao.taskcase;

import org.daqiao.taskflow.StepResult;
import org.daqiao.taskflow.TaskSession;
import org.daqiao.taskflow.TaskStepMethod;
import org.daqiao.taskflow.TaskStepSet;
import org.springframework.stereotype.Component;

/**
 * @Author : saizhang
 * @Date : 2019/12/01
 * @Time : 18:44
 * @Description : TODO
 */
@Component
public class MyTask implements TaskStepSet {

    @TaskStepMethod
    public StepResult step1(TaskSession session) {
        System.out.println("step1");
        return new StepResult(true, "step1", "成功");
    }

    @TaskStepMethod
    public StepResult step2(TaskSession session) {
        System.out.println("step2");
        return new StepResult(true, "step2", "成功");
    }

    public StepResult step3(TaskSession session) {
        System.out.println("step3");
        return new StepResult(true, "step3", "成功");
    }
}
