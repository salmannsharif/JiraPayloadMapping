package com.poc.jira.dto;

import java.util.List;

public class ChangelogDTO {
    private List<ChangelogItem> items;

    public List<ChangelogItem> getItems() {
        return items;
    }

    public void setItems(List<ChangelogItem> items) {
        this.items = items;
    }

}