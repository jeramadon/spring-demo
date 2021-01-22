package com.ebf.springdemo.service;

import com.ebf.springdemo.exception.TaskNotSavedException;
import com.ebf.springdemo.persistence.model.Project;

import java.util.Optional;

public interface IProjectService {

    Optional<Project> findById(Long id);

    Project save(Project project);

    Iterable<Project> findAll();

    void createProjectWithTask() throws TaskNotSavedException;

    Iterable<Project> findByName(String name);
}
