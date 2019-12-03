package org.daqiao.taskcase;

import org.daqiao.bean.MyBean;
import org.daqiao.taskflow.StepResult;
import org.daqiao.taskflow.TaskSession;
import org.daqiao.taskflow.TaskStepMethod;
import org.daqiao.taskflow.TaskStepSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
        session.addStepNext(MyTask.class, "step4");
        List<String> stepList = new ArrayList<>();
        stepList.add(session.getStep(MyTask.class, "step5"));
        stepList.add(session.getStep(MyTask.class, "step5"));
        stepList.add(session.getStep(MyTask.class, "step5"));
        session.addStepListNext(stepList);
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
        session.addStepEnd(MyTask.class, "step4");
        List<String> stepList = new ArrayList<>();
        stepList.add(session.getStep(MyTask.class, "step5"));
        stepList.add(session.getStep(MyTask.class, "step5"));
        stepList.add(session.getStep(MyTask.class, "step5"));
        session.addStepListEnd(stepList);
        return new StepResult(true, "step3", "成功");
    }

    @TaskStepMethod
    public StepResult step4(TaskSession session) {
        System.out.println("step4");
        return new StepResult(true, "step4", "成功");
    }

    @TaskStepMethod
    public StepResult step5(TaskSession session) {
        System.out.println("step5");
        return new StepResult(true, "step5", "成功");
    }
}
