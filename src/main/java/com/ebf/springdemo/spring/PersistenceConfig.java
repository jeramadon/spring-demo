package com.ebf.springdemo.spring;

import com.ebf.springdemo.persistence.repository.impl.ProjectRepositoryImplDev;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceConfig {

    @Bean
    public ProjectRepositoryImplDev projectRepository() {
        return new ProjectRepositoryImplDev();
    }
}
