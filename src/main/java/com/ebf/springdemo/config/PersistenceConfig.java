package com.ebf.springdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class PersistenceConfig {

//    @Bean
//    public DataSource dataSource() {
//        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).setName("springdemo-db").build();
//    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:springdemo-db;DB_CLOSE_DELAY=-1");
        dataSource.setUsername("user");
        dataSource.setPassword("");
        return dataSource;
    }
}