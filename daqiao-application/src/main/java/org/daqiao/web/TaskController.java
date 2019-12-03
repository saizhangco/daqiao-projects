package org.daqiao.web;

import org.daqiao.model.TaskRecordWithSteps;
import org.daqiao.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : saizhang
 * @Date : 2019/12/03
 * @Time : 22:04
 * @Description : TODO
 */
@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/{taskId}")
    public TaskRecordWithSteps getTaskInfo(@PathVariable("taskId") String taskId) {
        return taskService.getTaskInfo(taskId);
    }
}

