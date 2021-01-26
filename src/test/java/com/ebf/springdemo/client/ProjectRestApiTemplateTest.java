package com.ebf.springdemo.client;

import com.ebf.springdemo.web.dto.ProjectDto;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ProjectRestApiTemplateTest {

    private static final String BASE_URL = "http://localhost:8080/projects/";

    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void onProjectExists_OK() {
        ResponseEntity<ProjectDto> responseEntity = restTemplate.getForEntity(BASE_URL + "1", ProjectDto.class);
        assertThat(responseEntity.getStatusCodeValue(), Matchers.equalTo(200));
        assertNotNull(responseEntity.getBody());
    }

    @Test
    public void onProjectCreate_OK() {
        ProjectDto projectDto = new ProjectDto("Project 2 Test");
        ResponseEntity<ProjectDto> responseEntity = restTemplate.postForEntity(BASE_URL + "create", projectDto, ProjectDto.class);
        assertTrue(responseEntity.getStatusCode() == HttpStatus.CREATED);
    }
}
