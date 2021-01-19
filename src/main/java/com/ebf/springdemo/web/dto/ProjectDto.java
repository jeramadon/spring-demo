package com.ebf.springdemo.web.dto;

import java.util.Objects;
import java.util.Random;
import java.util.Set;

public class ProjectDto {

    private long id;
    private String name;
    private String internalId;
    private Set<TaskDto> tasks;

    public ProjectDto() {
    }

    public ProjectDto(String name) {
        this.id = new Random().nextLong();
        this.name = name;
    }

    public ProjectDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInternalId() {
        return internalId;
    }

    public void setInternalId(String internalId) {
        this.internalId = internalId;
    }

    public Set<TaskDto> getTasks() {
        return tasks;
    }

    public void setTasks(Set<TaskDto> tasks) {
        this.tasks = tasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectDto project = (ProjectDto) o;
        return id == project.id && name.equals(project.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "ProjectDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tasks=" + tasks +
                '}';
    }
}
