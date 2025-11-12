package com.poc.jira.dto;

public class UserDTO {
    private String accountId;
    private String displayName;
    private String timeZone;
    private String accountType;

    public UserDTO(String accountId, String displayName, String timeZone, String accountType) {
        this.accountId = accountId;
        this.displayName = displayName;
        this.timeZone = timeZone;
        this.accountType = accountType;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}