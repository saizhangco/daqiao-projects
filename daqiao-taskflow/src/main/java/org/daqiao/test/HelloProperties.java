package org.daqiao.test;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author : saizhang
 * @Date : 2019/12/01
 * @Time : 16:43
 * @Description : TODO
 */
@ConfigurationProperties(prefix = "hello")  //获取属性值
public class HelloProperties {
    private static final String MSG = "world";

    private String msg = MSG;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
