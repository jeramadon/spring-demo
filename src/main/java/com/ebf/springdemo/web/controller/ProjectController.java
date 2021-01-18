package com.ebf.springdemo.web.controller;

import com.ebf.springdemo.persistence.model.Project;
import com.ebf.springdemo.service.IProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/projects")
public class ProjectController {

    private IProjectService projectService;

    public ProjectController(IProjectService projectService) {
        super();
        this.projectService = projectService;
    }

    @GetMapping(value = "/{id}")
    public Project find(@PathVariable Long id) {
        return projectService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value ="/create")
    public Project create(@RequestBody Project project) {
        return projectService.save(project);
    }
}
