package com.ebf.springdemo.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class DatabaseHealthCheck implements HealthIndicator {

    @Override
    public Health health() {
        return Health.down()
                .withDetail("Error", 503)
                .build();
    }
}
