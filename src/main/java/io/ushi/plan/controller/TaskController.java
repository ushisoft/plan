package io.ushi.plan.controller;

import io.ushi.plan.domain.Task;
import io.ushi.plan.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
@RequestMapping("/v1/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Task tasks(@PathVariable("id") Long taskId) {

        return taskService.findTask(taskId);
    }
}
