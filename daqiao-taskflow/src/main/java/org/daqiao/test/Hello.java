package org.daqiao.test;

/**
 * @Author : saizhang
 * @Date : 2019/12/01
 * @Time : 16:41
 * @Description : TODO
 */
public class Hello {
    private String msg;

    public String sayHello() {
        return "hello " + msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
