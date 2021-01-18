package com.ebf.springdemo.service.impl;

import com.ebf.springdemo.exception.TaskNotSavedException;
import com.ebf.springdemo.persistence.model.Task;
import com.ebf.springdemo.persistence.repository.ITaskRepository;
import com.ebf.springdemo.service.ITaskService;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements ITaskService {

    private ITaskRepository taskRepository;

    public TaskServiceImpl(ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Iterable<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task save(Task task) throws TaskNotSavedException {
        return taskRepository.save(task);
    }
}
