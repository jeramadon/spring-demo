package com.ebf.springdemo.service.impl;

import com.ebf.springdemo.persistence.model.Project;
import com.ebf.springdemo.persistence.repository.IProjectRepository;
import com.ebf.springdemo.service.IProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectServiceImpl implements IProjectService {

    @Autowired
    private IProjectRepository projectRepository;
    private static final Logger LOG = LoggerFactory.getLogger(ProjectServiceImpl.class);

    public ProjectServiceImpl() {
    }

    public ProjectServiceImpl(IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
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
}
