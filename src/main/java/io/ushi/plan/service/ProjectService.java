package io.ushi.plan.service;

import io.ushi.bean.BeanUtilsExt;
import io.ushi.exception.UnexpectedLogicException;
import io.ushi.plan.domain.Project;
import io.ushi.plan.repository.ProjectRepository;
import io.ushi.validation.CommonErrors;
import io.ushi.validation.ErrorMessageResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectService {

    private static final Logger logger = LoggerFactory.getLogger(ProjectService.class);

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ErrorMessageResolver errorMessageResolver;

    public Project findProject(Long projectId) {
        logger.info("find project[id:{}] by xxx", projectId);
        return projectRepository.findById(projectId).orElse(null);
    }

    public void save(Project project) {
        projectRepository.save(project);
    }

    public void modify(Long projectId, Project project) {
        Optional<Project> existingData = projectRepository.findById(projectId);
        Project tobeModified = existingData.orElseThrow(() -> new UnexpectedLogicException(
                errorMessageResolver.resolve("project.id", CommonErrors.DataNotFound)));
        BeanUtils.copyProperties(project, tobeModified, BeanUtilsExt.getNullPropertyNames(project));
        projectRepository.save(tobeModified);

    }

    public void delete(Long projectId) {
        projectRepository.deleteById(projectId);
    }
}
