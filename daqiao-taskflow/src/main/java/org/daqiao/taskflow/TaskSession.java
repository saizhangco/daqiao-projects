package org.daqiao.taskflow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author : saizhang
 * @Date : 2019/12/01
 * @Time : 17:19
 * @Description : TODO
 */
public class TaskSession {
    private Map<String, Object> map = new ConcurrentHashMap<String, Object>();
    private List<String> stepList = new ArrayList<>();

    public void put(String name, Object object) {
        map.put(name, object);
    }

    public Object get(String name) {
        return map.get(name);
    }

    public boolean isContinue() {
        return stepCounter < stepList.size();
    }

    private int stepCounter = 0;

    public void incrementCounter() {
        stepCounter++;
    }

    public int getStepCounter() {
        return stepCounter;
    }

    public void addStep(String step) {
        stepList.add(step);
    }

    public void addStepEnd(Class clazz, String methodName) {
        addStep(clazz.getName() + ":" + methodName);
    }

    public void addStepListEnd(List<String> list) {
        stepList.addAll(list);
    }

    public void addStepNext(Class clazz, String methodName) {
        stepList.add(stepCounter + 1, clazz.getName() + ":" + methodName);
    }

    public void addStepListNext(List<String> list) {
        stepList.addAll(stepCounter + 1, list);
    }

    public List<String> getStepList() {
        return stepList;
    }

    public String getStep(Class clazz, String methodName) {
        return clazz.getName() + ":" + methodName;
    }
}
