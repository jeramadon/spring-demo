package com.ebf.springdemo.web.controller;

import com.ebf.springdemo.persistence.model.Project;
import com.ebf.springdemo.persistence.model.Task;
import com.ebf.springdemo.service.IProjectService;
import com.ebf.springdemo.web.dto.ProjectDto;
import com.ebf.springdemo.web.dto.TaskDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/projects")
public class ProjectController {

    private IProjectService projectService;

    public ProjectController(IProjectService projectService) {
        super();
        this.projectService = projectService;
    }

    //@GetMapping
    public String getProjects(Model model) {
        Iterable<Project> projects = projectService.findAll();
        List<ProjectDto> projectDtos = new ArrayList<>();
        projects.forEach(project -> projectDtos.add(convertToProjectDto(project)));
        model.addAttribute("projects", projectDtos);
        return "projects";
    }

    @GetMapping("/new")
    public String newProject(Model model) {
        model.addAttribute("project", new ProjectDto());
        return "new-project";
    }

    @PostMapping
    public String addProject(@Valid @ModelAttribute("project") ProjectDto projectDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ("new-project");
        }
        projectService.save(convertToProjectEntity(projectDto));
        return ("redirect:/projects");
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
