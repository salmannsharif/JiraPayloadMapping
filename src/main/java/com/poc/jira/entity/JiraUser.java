package com.poc.jira.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "jira_user")
public class JiraUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_id", unique = true, columnDefinition = "TEXT")
    private String accountId;

    @Column(name = "display_name", columnDefinition = "TEXT")
    private String displayName;

    @Column(name = "time_zone", columnDefinition = "TEXT")
    private String timeZone;

    @Column(name = "account_type", columnDefinition = "TEXT")
    private String accountType;


    // Constructors
    public JiraUser() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAccountId() { return accountId; }
    public void setAccountId(String accountId) { this.accountId = accountId; }

    public String getDisplayName() { return displayName; }
    public void setDisplayName(String displayName) { this.displayName = displayName; }

    public String getTimeZone() { return timeZone; }
    public void setTimeZone(String timeZone) { this.timeZone = timeZone; }

    public String getAccountType() { return accountType; }
    public void setAccountType(String accountType) { this.accountType = accountType; }
}
