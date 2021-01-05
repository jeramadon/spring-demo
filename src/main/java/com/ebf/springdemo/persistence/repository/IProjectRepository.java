package com.ebf.springdemo.persistence.repository;

import com.ebf.springdemo.persistence.model.Project;

import java.util.Optional;

public interface IProjectRepository {

    Optional<Project> findById(Long id);

    Project save(Project project);
}
