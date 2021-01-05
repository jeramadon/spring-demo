package com.ebf.springdemo.service;

import com.ebf.springdemo.persistence.model.Project;

import java.util.Optional;

public interface IProjectService {

    Optional<Project> findById(Long id);

    Project save(Project project);
}
