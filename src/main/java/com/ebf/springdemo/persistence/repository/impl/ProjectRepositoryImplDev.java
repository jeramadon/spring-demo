package com.ebf.springdemo.persistence.repository.impl;

import com.ebf.springdemo.persistence.model.Project;
import com.ebf.springdemo.persistence.repository.IProjectRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProjectRepositoryImplDev implements IProjectRepository {

    @Value("${project.prefix}")
    private String prefix;
    @Value("${project.suffix}")
    private Integer suffix;

    List<Project> projectList = new ArrayList<>();

    public ProjectRepositoryImplDev() {
        super();
    }

    @Override
    public Optional<Project> findById(Long id) {
        return projectList.stream().filter(p -> p.getId() == id).findFirst();
    }

    @Override
    public Project save(Project project) {
        Project existingProject = findById(project.getId()).orElse(null);
        updateInternalId(project);
        if (existingProject == null) {
            projectList.add(project);
        } else {
            projectList.remove(existingProject);
            Project newProject = new Project(project);
            projectList.add(newProject);
        }
        return project;
    }

    private void updateInternalId(Project project) {
        project.setInternalId(prefix + "-" + project.getId() + "-" + suffix);
    }
}
