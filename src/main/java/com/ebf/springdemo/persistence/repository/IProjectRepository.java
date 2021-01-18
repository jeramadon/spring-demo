package com.ebf.springdemo.persistence.repository;

import com.ebf.springdemo.persistence.model.Project;
import org.springframework.data.repository.CrudRepository;

public interface IProjectRepository extends CrudRepository<Project, Long> {
}
