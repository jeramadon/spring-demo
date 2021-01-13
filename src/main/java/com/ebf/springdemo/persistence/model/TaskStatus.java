package com.ebf.springdemo.persistence.model;

public enum TaskStatus {
    TO_DO("To do"),
    ON_HOLD("On hold"),
    IN_PROGRESS("In progress"),
    DONE("Done");

    private final String label;

    TaskStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
