package io.ushi.plan.controller;

import io.ushi.plan.domain.Project;
import io.ushi.plan.dto.ProjectForm;
import io.ushi.plan.dto.ProjectMapper;
import io.ushi.plan.service.ProjectService;
import io.ushi.validation.group.Create;
import io.ushi.validation.group.Modify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
    ProjectMapper projectMapper;

    @GetMapping(value = "/{id}")
    public Project find(@PathVariable("id") Long projectId) {

        return projectService.findProject(projectId);
    }

    @PostMapping(value = "/")
    public ResponseEntity create(@Validated(Create.class) @RequestBody ProjectForm projectForm) {

        projectService.save(projectMapper.toDomain(projectForm));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    // modify
    @PatchMapping(value = "/")
    public ResponseEntity modify(@Validated(Modify.class) @RequestBody ProjectForm projectForm) {

        projectService.modify(projectMapper.toDomain(projectForm));
        return ResponseEntity.ok(HttpStatus.OK);
    }


    // modifySelective

    // delete

    // public Object update(@PathVariable String id,
    //            @RequestBody ChannelCardProduct channelCardProduct) {
}
