package com.poc.jira.dto;

public class IssueDTO {
    private String id;
    private String key;
    private IssueFields fields;

    public IssueDTO(String id, String key, IssueFields fields) {
        this.id = id;
        this.key = key;
        this.fields = fields;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public IssueFields getFields() {
        return fields;
    }

    public void setFields(IssueFields fields) {
        this.fields = fields;
    }
}