package com.ebf.springdemo.web.controller;

import com.ebf.springdemo.persistence.model.Project;
import com.ebf.springdemo.persistence.model.Task;
import com.ebf.springdemo.service.IProjectService;
import com.ebf.springdemo.web.dto.ProjectDto;
import com.ebf.springdemo.web.dto.TaskDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.stream.Collectors;

//@RestController
//@RequestMapping(value = "/projects")
public class ProjectRestController {

    private IProjectService projectService;

    public ProjectRestController(IProjectService projectService) {
        super();
        this.projectService = projectService;
    }

    //@GetMapping(value = "/{id}")
    public ProjectDto find(@PathVariable Long id) {
        Project project = projectService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return convertToProjectDto(project);
    }

    //@PostMapping(value ="/create")
    public Project create(@RequestBody ProjectDto projectDto) {
        return projectService.save(convertToProjectEntity(projectDto));
    }

    public Project convertToProjectEntity(ProjectDto projectDto) {
        Project project = new Project(projectDto.getName(), LocalDate.now());
        if (projectDto.getId() != 0) {
            project.setId(projectDto.getId());
        }
        return project;
    }

    public ProjectDto convertToProjectDto(Project project) {
        ProjectDto projectDto = new ProjectDto(project.getId(), project.getName());
        projectDto.setTasks(project.getTasks().stream().map(t -> convertToTaskDto(t)).collect(Collectors.toSet()));
        return projectDto;
    }

    public Task convertToTaskEntity(TaskDto taskDto) {
        Task task = new Task(taskDto.getName(), taskDto.getDescription(), taskDto.getDateCreated(), taskDto.getDueDate());
        if (taskDto.getId() != 0) {
            task.setId(taskDto.getId());
        }
        return task;
    }

    public TaskDto convertToTaskDto(Task task) {
        return new TaskDto(task.getName(), task.getDescription(), task.getDateCreated(), task.getDueDate());
    }
}
