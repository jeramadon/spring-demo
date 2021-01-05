package com.ebf.springdemo.service.impl;

import com.ebf.springdemo.persistence.model.Project;
import com.ebf.springdemo.persistence.repository.IProjectRepository;
import com.ebf.springdemo.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ProjectServiceImpl implements IProjectService {

    @Autowired
    private IProjectRepository projectRepository;

    @Override
    public Optional<Project> findById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }
}
