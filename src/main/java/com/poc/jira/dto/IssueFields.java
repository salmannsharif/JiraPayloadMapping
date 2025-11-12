package com.poc.jira.dto;


public class IssueFields {
    private String summary;
    private Status status;
    private Priority priority;


    public IssueFields(String summary, Status status, Priority priority) {
        this.summary = summary;
        this.status = status;
        this.priority = priority;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}