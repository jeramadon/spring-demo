package com.ebf.springdemo.persistence.repository;

import com.ebf.springdemo.persistence.model.Task;
import org.springframework.data.repository.CrudRepository;

public interface ITaskRepository extends CrudRepository<Task, Long> {
}
