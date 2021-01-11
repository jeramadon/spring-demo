package com.ebf.springdemo.service;

import com.ebf.springdemo.persistence.model.Project;
import com.ebf.springdemo.spring.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@SpringJUnitConfig(classes = TestConfig.class)
@TestPropertySource(locations = "classpath:application.properties")
public class ProjectServiceIntegrationTest {

    @Autowired
    private IProjectService projectService;

    @Test
    public void whenSavingProject_OK() {
        Project project = projectService.save(new Project(1L, "Project Name", LocalDate.now()));
        assertThat(project, is(notNullValue()));
    }
}
