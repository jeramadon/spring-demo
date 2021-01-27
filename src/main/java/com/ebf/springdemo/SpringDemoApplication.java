//  https://github.com/eugenp/learn-spring
//  https://github.com/eugenp/learn-spring/branches/active

package com.ebf.springdemo;

import com.ebf.springdemo.service.IProjectService;
import com.ebf.springdemo.service.ITaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringDemoApplication {

	@Autowired
	IProjectService projectService;

	@Autowired
	ITaskService taskService;

	private static final Logger LOG = LoggerFactory.getLogger(SpringDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}

	@PostConstruct
	public void postConstruct() {
		try {
			projectService.createProjectWithTask();
			LOG.info("All Projects:");
			projectService.findAll().forEach(p -> LOG.info(p.toString()));
			LOG.info("All Tasks:");
			taskService.findAll().forEach(t -> LOG.info(t.toString()));
		} catch (Exception e) {
			LOG.error("Error creating tasks", e);
		}
	}
}
