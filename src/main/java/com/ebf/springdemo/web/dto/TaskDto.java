package com.ebf.springdemo.web.dto;

import com.ebf.springdemo.persistence.model.Task;
import com.ebf.springdemo.persistence.model.TaskStatus;

import java.time.LocalDate;
import java.util.Objects;

public class TaskDto {

    public Long id;
    public String name;
    public String description;
    public LocalDate dateCreated;
    public LocalDate dueDate;
    public TaskStatus status;

    public TaskDto () {
    }

    public TaskDto(String name, String description, LocalDate dateCreated, LocalDate dueDate) {
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
        this.dueDate = dueDate;
        this.status = TaskStatus.TO_DO;
    }

    public TaskDto(Task task) {
        this.id = task.id;
        this.name = task.name;
        this.description = task.description;
        this.dateCreated = task.dateCreated;
        this.dueDate = task.dueDate;
        this.status = task.status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskDto task = (TaskDto) o;
        return Objects.equals(id, task.id) && Objects.equals(name, task.name) && Objects.equals(description, task.description) && Objects.equals(dateCreated, task.dateCreated) && Objects.equals(dueDate, task.dueDate) && status == task.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, dateCreated, dueDate, status);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dateCreated=" + dateCreated +
                ", dueDate=" + dueDate +
                ", status=" + status +
                '}';
    }
}
