package com.ebf.springdemo.service.impl;

import com.ebf.springdemo.exception.TaskNotSavedException;
import com.ebf.springdemo.persistence.model.Project;
import com.ebf.springdemo.persistence.model.Task;
import com.ebf.springdemo.persistence.repository.IProjectRepository;
import com.ebf.springdemo.service.IProjectService;
import com.ebf.springdemo.service.ITaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ProjectServiceImpl implements IProjectService {

    private IProjectRepository projectRepository;
    private ITaskService taskService;
    private static final Logger LOG = LoggerFactory.getLogger(ProjectServiceImpl.class);

    public ProjectServiceImpl(IProjectRepository projectRepository, ITaskService taskService) {
        this.projectRepository = projectRepository;
        this.taskService = taskService;
    }

    @Autowired
    public void setProjectRepository(IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Optional<Project> findById(Long id) {
        LOG.debug("ProjectService findById: {}", id);
        return projectRepository.findById(id);
    }

    @Override
    public Project save(Project project) {
        LOG.debug("ProjectService save: {}", project);
        return projectRepository.save(project);
    }

    @Override
    public Iterable<Project> findAll() {
        return projectRepository.findAll();
    }

    @Transactional(rollbackOn = TaskNotSavedException.class)
    @Override
    public void createProjectWithTask() throws TaskNotSavedException {
        Project newProject = save(new Project("Project 1", LocalDate.now()));
        Task newTask = new Task("Task1", "Project 1/Task 1", LocalDate.now(), LocalDate.now().plusDays(7));
        taskService.save(newTask);
        Set<Task> tasks = new HashSet<>();
        tasks.add(newTask);
        newProject.setTasks(tasks);
        save(newProject);
    }
}
