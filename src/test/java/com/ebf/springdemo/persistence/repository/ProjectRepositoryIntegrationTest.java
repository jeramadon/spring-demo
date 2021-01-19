package com.ebf.springdemo.persistence.repository;

import com.ebf.springdemo.persistence.model.Project;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
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
}
