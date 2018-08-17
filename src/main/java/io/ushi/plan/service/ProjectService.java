package io.ushi.plan.service;

import io.ushi.plan.domain.Project;
import io.ushi.plan.repository.ProjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    private static final Logger logger = LoggerFactory.getLogger(ProjectService.class);

    @Autowired
    ProjectRepository projectRepository;

    public Project findProject(Long projectId) {
        logger.info("find project[id:{}] by xxx", projectId);
        return projectRepository.findById(projectId).orElse(null);
    }
}
