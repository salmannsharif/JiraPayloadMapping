package com.poc.jira.dto;

public class ChangelogItem {
    private String field;
    private String fromString;
    private String toString;

    public ChangelogItem(String field, String fromString, String toString) {
        this.field = field;
        this.fromString = fromString;
        this.toString = toString;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getFromString() {
        return fromString;
    }

    public void setFromString(String fromString) {
        this.fromString = fromString;
    }

    public String getToString() {
        return toString;
    }

    public void setToString(String toString) {
        this.toString = toString;
    }
}
