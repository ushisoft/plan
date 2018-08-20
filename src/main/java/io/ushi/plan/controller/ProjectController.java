package io.ushi.plan.controller;

import io.ushi.plan.domain.Project;
import io.ushi.plan.dto.ProjectDTO;
import io.ushi.plan.dto.ProjectMapper;
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

    @Autowired
    ProjectMapper projectMapper;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Project find(@PathVariable("id") Long projectId) {

        return projectService.findProject(projectId);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Project create(@RequestBody ProjectDTO projectDTO) {

        return projectRepository.save(projectMapper.from(projectDTO));
    }

    // modify

    // modifySelective

    // delete

    // public Object update(@PathVariable String id,
    //            @RequestBody ChannelCardProduct channelCardProduct) {
}
