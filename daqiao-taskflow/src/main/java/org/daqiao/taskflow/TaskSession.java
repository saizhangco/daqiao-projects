package org.daqiao.taskflow;

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

    public void put(String name, Object object) {
        map.put(name, object);
    }

    public Object get(String name) {
        return map.get(name);
    }
}
