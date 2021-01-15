package com.ebf.springdemo.persistence.repository;

import com.ebf.springdemo.persistence.model.Project;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProjectRepositoryIntegrationTest {

    @Autowired
    IProjectRepository projectRepository;

    @Test
    public void onSaveProject_Success() {
        Project project = new Project(UUID.randomUUID().toString(), LocalDate.now());
        assertThat(projectRepository.save(project), is(notNullValue()));
    }

    @Test
    public void onFindProjectById_Success() {
        Project project = new Project(UUID.randomUUID().toString(), LocalDate.now());
        projectRepository.save(project);
        Optional<Project> findProject = projectRepository.findById(project.getId());
        assertThat(findProject.get(), is(equalTo(project)));
    }

    @Test
    public void onFindProjectByName_Success() {
        Project project = new Project(UUID.randomUUID().toString(), LocalDate.now());
        projectRepository.save(project);
        Optional<Project> findProject = projectRepository.findByName(project.getName());
        assertThat(findProject.get(), is(equalTo(project)));
    }

    @Test
    public void onFindProjectsByDateRange_Success() {
        Project oldProject = new Project(UUID.randomUUID().toString(), LocalDate.now().minusDays(7));
        projectRepository.save(oldProject);
        Project newProject = new Project(UUID.randomUUID().toString(), LocalDate.now());
        projectRepository.save(newProject);
        Project newProject2 = new Project(UUID.randomUUID().toString(), LocalDate.now());
        projectRepository.save(newProject2);

        List<Project> projectList = projectRepository.findByDateCreatedBetween(LocalDate.now().minusDays(1), LocalDate.now().plusDays(1));
        assertThat(projectList, hasItems(newProject, newProject2));
    }

    @Test
    public void onPagedProjects_Success() {
        Page<Project> projects = projectRepository.findAll(PageRequest.of(0, 2));
        assertThat(projects.getContent(), hasSize(2));
    }

    @Test
    public void onSortedProjects_Success() {
        List<Project> projects = (List<Project>)projectRepository.findAll(Sort.by(Sort.Order.asc("name")));
        List<Project> sortedProjects = projects.stream().collect(Collectors.toList());
        sortedProjects.sort(Comparator.comparing(Project::getName));
        assertEquals(projects, sortedProjects);
    }

    @Test
    public void onPagedSortedProjects_Success() {
        Page<Project> projects = projectRepository.findAll(PageRequest.of(0, 2, Sort.by(Sort.Order.asc("name"))));
        assertThat(projects.getContent(), hasSize(2));
    }
}
