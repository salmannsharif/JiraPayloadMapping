package com.poc.jira.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "jira_changelog")
public class JiraChangelog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "issue_key")
    private String issueKey;

    @Column(columnDefinition = "TEXT")
    private String field;

    @Column(name = "from_string", columnDefinition = "TEXT")
    private String fromString;

    @Column(name = "to_string", columnDefinition = "TEXT")
    private String toString;


    @Column(name = "changed_at")
    private LocalDateTime changedAt = LocalDateTime.now();

    // Constructors
    public JiraChangelog() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getIssueKey() { return issueKey; }
    public void setIssueKey(String issueKey) { this.issueKey = issueKey; }

    public String getField() { return field; }
    public void setField(String field) { this.field = field; }

    public String getFromString() { return fromString; }
    public void setFromString(String fromString) { this.fromString = fromString; }

    public String getToString() { return toString; }
    public void setToString(String toString) { this.toString = toString; }

    public LocalDateTime getChangedAt() { return changedAt; }
    public void setChangedAt(LocalDateTime changedAt) { this.changedAt = changedAt; }
}
