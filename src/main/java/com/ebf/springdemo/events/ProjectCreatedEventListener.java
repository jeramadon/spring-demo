package com.ebf.springdemo.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ProjectCreatedEventListener {

    private static final Logger LOG = LoggerFactory.getLogger(ProjectCreatedEventListener.class);

    @EventListener
    public void onProjectCreated(ProjectCreatedEvent event) {
        LOG.info("Project create event for Project:" + event.getProjectId());
    }
}
