package io.ushi.plan.controller;

import io.ushi.plan.domain.Project;
import io.ushi.plan.repository.ProjectRepository;
import io.ushi.plan.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 */
@RestController
@RequestMapping("/v1/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @Autowired
    ProjectRepository projectRepository; // for test

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Project find(@PathVariable("id") Long projectId) {

        return projectService.findProject(projectId);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Project create(@RequestBody Project project) {

        return projectRepository.save(project);
    }

    // modify

    // modifySelective

    // delete
}
