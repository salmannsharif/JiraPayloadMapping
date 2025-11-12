package com.poc.jira.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "jira_issue")
public class JiraIssue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "issue_key", unique = true)
    private String issueKey;

    @Column(columnDefinition = "TEXT")
    private String summary;

    @Column(columnDefinition = "TEXT")
    private String status;

    @Column(columnDefinition = "TEXT")
    private String priority;

    @Column(columnDefinition = "TEXT")
    private String webhookEvent;



    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();

    // Constructors
    public JiraIssue() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getIssueKey() { return issueKey; }
    public void setIssueKey(String issueKey) { this.issueKey = issueKey; }

    public String getSummary() { return summary; }
    public void setSummary(String summary) { this.summary = summary; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    public String getWebhookEvent(){return webhookEvent; }

    public void setWebhookEvent(String webhookEvent) { this.webhookEvent = webhookEvent; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
