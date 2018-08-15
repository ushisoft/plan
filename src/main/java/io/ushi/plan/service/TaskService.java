package io.ushi.plan.service;

import io.ushi.plan.domain.Task;
import io.ushi.plan.repository.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private static final Logger logger = LoggerFactory.getLogger(TaskService.class);

    @Autowired
    TaskRepository taskRepository;

    public Task findTask(Long taskId) {
        logger.info("find task[id:{}] by xxx", taskId);
        return taskRepository.findTask(taskId);
    }
}
