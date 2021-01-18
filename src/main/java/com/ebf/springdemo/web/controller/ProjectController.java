package com.ebf.springdemo.web.controller;

import com.ebf.springdemo.persistence.model.Project;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping(value = "/projects")
public class ProjectController {

    @GetMapping("/1")
    public Project findOne() {
        return new Project("test name", LocalDate.now());
    }
}
