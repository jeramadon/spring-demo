package com.ebf.springdemo.persistence.repository;

import com.ebf.springdemo.persistence.model.Project;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProjectRepository extends PagingAndSortingRepository<Project, Long> {
    Iterable<Project> findByNameContaining(String name);
}
