package org.daqiao.taskflow;

import org.daqiao.model.TaskRecord;
import org.daqiao.model.TaskStepRecord;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @Author : saizhang
 * @Date : 2019/12/01
 * @Time : 17:22
 * @Description : TODO
 */
@Component
public class TaskRepository {
    private Map<String, Method> methodMap = new HashMap<String, Method>();
    private Map<String, Object> classMap = new HashMap<String, Object>();
    private List<TaskCallback> callbackList = new ArrayList<>();

    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    public void init() {
        initTaskStep();
        initTaskCallback();
    }

    private void initTaskStep() {
        Map<String, TaskStepSet> map = applicationContext.getBeansOfType(TaskStepSet.class);
        for( Map.Entry<String, TaskStepSet> entry : map.entrySet() ) {
            String className = entry.getValue().getClass().getName();
            classMap.put(className, entry.getValue());
            addMethodToMap(className, entry.getValue());
        }
    }

    private void initTaskCallback() {
        Map<String, TaskCallback> map = applicationContext.getBeansOfType(TaskCallback.class);
        Set<Class<? extends TaskCallback>> set = new HashSet<>();
        // 去重
        for( Map.Entry<String, TaskCallback> entry : map.entrySet() ) {
            set.add(entry.getValue().getClass());
        }
        for( Class<? extends TaskCallback> clazz : set ) {
            TaskCallback taskCallback = applicationContext.getBean(clazz);
            callbackList.add(taskCallback);
        }
    }

    public void taskInitial(TaskRecord taskRecord) {
        for( TaskCallback taskCallback : callbackList ) {
            taskCallback.taskInitial(taskRecord);
        }
    }

    public void taskComplete(TaskRecord taskRecord) {
        for( TaskCallback taskCallback : callbackList ) {
            taskCallback.taskComplete(taskRecord);
        }
    }

    public void taskStepExecute(TaskStepRecord taskStepRecord) {
        for( TaskCallback taskCallback : callbackList ) {
            taskCallback.taskStep(taskStepRecord);
        }
    }

    public void put(String name, Object clazz, Method method) {
        String className = name.split(":")[1];
        methodMap.put(name, method);
        classMap.put(className, clazz);
    }

    public Method getMethod(String name) {
        String className = name.split(":")[0];
        String methodName = name.split(":")[1];
        Method method = methodMap.get(name);
        // 如果method为空，则再实例化一次，并放到map中
        if(method == null) {
            try {
                Class clazz = getClass(className) == null ? getClass(className).getClass() : Class.forName(className);
                method = clazz.getMethod(methodName, TaskSession.class);
            } catch( ClassNotFoundException | NoSuchMethodException e ) {
                e.printStackTrace();
            }
            if( method != null ) {
                methodMap.put(name, method);
            }
        }
        return methodMap.get(name);
    }

    public Object getClass(String name) {
        String className = name.split(":")[0];
        Object object = classMap.get(className);
        // 如果object为空，则再实例化一次，并放到map中
        if (object == null) {
            try {
                object = applicationContext.getBean(className);
            } catch (BeansException e) {
                e.printStackTrace();
            }
            if( object != null && object instanceof TaskStepSet) {
                classMap.put(className, object);
                addMethodToMap(className, object);
            }
        }
        return classMap.get(className);
    }

    private void addMethodToMap(String className, Object object) {
        Method[] methods = object.getClass().getMethods();
        for( Method method : methods ) {
            if( method.getAnnotation(TaskStepMethod.class) != null ) {
                String methodName = method.getName();
                methodMap.put(className + ":" + methodName, method);
            }
        }
    }
}
