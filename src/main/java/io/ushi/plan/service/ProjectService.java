package io.ushi.plan.service;

import io.ushi.bean.BeanUtilsExt;
import io.ushi.exception.UnexpectedLogicException;
import io.ushi.plan.domain.Project;
import io.ushi.plan.repository.ProjectRepository;
import io.ushi.validation.CommonErrors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Optional;

@Service
public class ProjectService {

    private static final Logger logger = LoggerFactory.getLogger(ProjectService.class);

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    EntityManager entityManager;

    public Project findProject(Long projectId) {
        logger.info("find project[id:{}] by xxx", projectId);
        return projectRepository.findById(projectId).orElse(null);
    }

    public void save(Project project) {
        projectRepository.save(project);
    }

    public void modify(Long projectId, Project project) {
        Optional<Project> existingData = projectRepository.findById(projectId);
        Project tobeModified = existingData.orElseThrow(() ->
                new UnexpectedLogicException("project.id", CommonErrors.DataNotFound));
        BeanUtils.copyProperties(project, tobeModified, BeanUtilsExt.getNullPropertyNames(project));
        projectRepository.save(tobeModified);

    }

    public void delete(Long projectId) {
        projectRepository.deleteById(projectId);
    }

    public void query() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Project> query = builder.createQuery(Project.class);
        Root<Project> root = query.from(Project.class);
        query.select(builder.construct(Project.class, root.get("title"), root.get("start")));

        Predicate predicate = builder.conjunction();
        predicate.in()
        query.where(predicate);

    }
}
