//  https://github.com/eugenp/learn-spring

package com.ebf.springdemo;

import com.ebf.springdemo.persistence.model.Project;
import com.ebf.springdemo.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Optional;

//@SpringBootApplication(scanBasePackageClasses = "com.ebf.springdemo.persistence")
@SpringBootApplication
public class SpringDemoApplication {

	@Autowired
	@Qualifier("projectServiceImpl")
	IProjectService projectService;

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}

	@PostConstruct
	public void postConstruct() {
		projectService.save(new Project(1L, "New", LocalDate.now()));
		Optional<Project> optionalProject = projectService.findById(1L);
		optionalProject.ifPresent(System.out::println);
	}
}
