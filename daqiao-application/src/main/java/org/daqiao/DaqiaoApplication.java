package org.daqiao;

import org.daqiao.bean.MyBean;
import org.daqiao.taskcase.MyTask;
import org.daqiao.taskflow.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @Author : saizhang
 * @Date : 2019/12/01
 * @Time : 16:30
 * @Description : 程序入口
 */
@SpringBootApplication
public class DaqiaoApplication implements ApplicationRunner {
    public static void main(String[] args) {
        SpringApplication.run(DaqiaoApplication.class, args);
    }

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Hello world!");
        Task task = applicationContext.getBean(Task.class);
        task.addTask(MyTask.class, "step1");
        task.addTask(MyTask.class, "step2");
        task.addTask(MyTask.class, "step3");
        task.executeAll("myTask");
    }

    @Bean
    @ConditionalOnMissingBean(MyBean.class)
    public MyBean myBean() {
        MyBean myBean = new MyBean();
        myBean.setBeanName("hello");
        return myBean;
    }
}
