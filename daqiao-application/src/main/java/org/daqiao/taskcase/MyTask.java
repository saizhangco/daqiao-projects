package org.daqiao.taskcase;

import org.daqiao.bean.MyBean;
import org.daqiao.taskflow.StepResult;
import org.daqiao.taskflow.TaskSession;
import org.daqiao.taskflow.TaskStepMethod;
import org.daqiao.taskflow.TaskStepSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author : saizhang
 * @Date : 2019/12/01
 * @Time : 18:50
 * @Description : TODO
 */
@Component
public class MyTask implements TaskStepSet {

    @Autowired
    private MyBean myBean;

    @TaskStepMethod
    public StepResult step1(TaskSession session) {
        System.out.println("step1");
        return new StepResult(true, "step1", "成功");
    }

    @TaskStepMethod
    public StepResult step2(TaskSession session) {
        System.out.println("step2");
        return new StepResult(true, "step2", "成功" + myBean.getBeanName());
    }

    @TaskStepMethod
    public StepResult step3(TaskSession session) {
        System.out.println("step3");
        return new StepResult(true, "step3", "成功");
    }
}
