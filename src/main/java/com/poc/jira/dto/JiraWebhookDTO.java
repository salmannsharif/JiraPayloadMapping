package com.poc.jira.dto;

public class JiraWebhookDTO {

    private String webhookEvent;
    private IssueDTO issue;
    private ChangelogDTO changelog;
    private UserDTO user;


    public JiraWebhookDTO(String webhookEvent, IssueDTO issue, ChangelogDTO changelog, UserDTO user) {
        this.webhookEvent = webhookEvent;
        this.issue = issue;
        this.changelog = changelog;
        this.user = user;
    }

    public String getWebhookEvent() {
        return webhookEvent;
    }

    public void setWebhookEvent(String webhookEvent) {
        this.webhookEvent = webhookEvent;
    }

    public IssueDTO getIssue() {
        return issue;
    }

    public void setIssue(IssueDTO issue) {
        this.issue = issue;
    }

    public ChangelogDTO getChangelog() {
        return changelog;
    }

    public void setChangelog(ChangelogDTO changelog) {
        this.changelog = changelog;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "JiraWebhookDTO{" +
                "issue=" + issue +
                ", user=" + user +
                ", changelog=" + changelog +
                '}';
    }

}