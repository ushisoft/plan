package io.ushi.plan.controller;

import io.ushi.plan.domain.Project;
import io.ushi.plan.dto.ProjectDTO;
import io.ushi.plan.dto.ProjectMapper;
import io.ushi.plan.repository.ProjectRepository;
import io.ushi.plan.service.ProjectService;
import org.apache.coyote.ErrorState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;

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

    @GetMapping(value = "/{id}")
    public Project find(@PathVariable("id") Long projectId) {

        return projectService.findProject(projectId);
    }

    @PostMapping(value = "/")
    public ResponseEntity create(@Valid @RequestBody ProjectDTO projectDTO) {

        projectRepository.save(projectMapper.from(projectDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    // modify

    // modifySelective

    // delete

    // public Object update(@PathVariable String id,
    //            @RequestBody ChannelCardProduct channelCardProduct) {
}
