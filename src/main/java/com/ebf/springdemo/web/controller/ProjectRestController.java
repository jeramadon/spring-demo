package com.ebf.springdemo.web.controller;

import com.ebf.springdemo.persistence.model.Project;
import com.ebf.springdemo.persistence.model.Task;
import com.ebf.springdemo.service.IProjectService;
import com.ebf.springdemo.web.dto.ProjectDto;
import com.ebf.springdemo.web.dto.TaskDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
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
        Optional<Project> project = projectService.findById(id);
        return convertToProjectDto(project.get());
    }

    //@GetMapping
    public Collection<ProjectDto> findProjects(@RequestParam(name = "name", defaultValue = "") String name) {
        Iterable<Project> projects = projectService.findByName(name);
        ArrayList<ProjectDto> projectDtos = new ArrayList<>();
        projects.forEach(project -> projectDtos.add(convertToProjectDto(project)));
        return projectDtos;
    }

    //@PostMapping(value = "/create")
    //@ResponseStatus(HttpStatus.CREATED)
    public ProjectDto createProject(@RequestBody ProjectDto projectDto) {
        Project project = convertToProjectEntity(projectDto);
        return convertToProjectDto(projectService.save(project));
    }

    //@DeleteMapping(value = "/{id}")
    //@ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        projectService.delete(id);
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
