package com.ebf.springdemo.persistence.repository;

import com.ebf.springdemo.persistence.model.Project;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Component
public class TestDataLoader implements ApplicationContextAware {

    @Autowired
    private IProjectRepository projectRepository;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        projectRepository.save(new Project(UUID.randomUUID().toString(), LocalDate.now()));
        projectRepository.save(new Project(UUID.randomUUID().toString(), LocalDate.now()));
        projectRepository.save(new Project(UUID.randomUUID().toString(), LocalDate.now()));
        projectRepository.save(new Project(UUID.randomUUID().toString(), LocalDate.now()));
    }
}
