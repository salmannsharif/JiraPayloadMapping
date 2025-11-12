package com.poc.jira.dto;

public class Priority {
    private String name;

    public Priority(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}