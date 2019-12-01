package org.daqiao.taskflow;

import java.lang.annotation.*;

/**
 * @Author : saizhang
 * @Date : 2019/12/01
 * @Time : 17:18
 * @Description : TODO
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TaskStepMethod {
}
