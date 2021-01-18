package com.ebf.springdemo.service;

import com.ebf.springdemo.exception.TaskNotSavedException;
import com.ebf.springdemo.persistence.model.Task;

public interface ITaskService {

    Iterable<Task> findAll();

    Task save(Task task) throws TaskNotSavedException;
}
