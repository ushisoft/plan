package io.ushi.plan.controller;

import io.ushi.plan.domain.Project;
import io.ushi.plan.dto.ProjectForm;
import io.ushi.plan.dto.ProjectMapper;
import io.ushi.plan.service.ProjectService;
import io.ushi.validation.group.Create;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    @PatchMapping(value = "/{id}")
    public ResponseEntity modify(@PathVariable("id") Long projectId, @Validated @RequestBody ProjectForm projectForm) {

        projectService.modify(projectId, projectMapper.toDomain(projectForm));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    // delete
    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable("id") Long projectId) {

        projectService.delete(projectId);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    // query
    @PostMapping(value = "/query")
    public ResponseEntity query(@RequestBody String criteria) {

        System.out.println(criteria);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    // put::update
}
