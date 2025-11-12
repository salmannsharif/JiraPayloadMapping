package com.poc.jira.service;

import com.poc.jira.dto.JiraWebhookDTO;
import com.poc.jira.entity.JiraChangelog;
import com.poc.jira.entity.JiraIssue;
import com.poc.jira.entity.JiraUser;
import com.poc.jira.repository.JiraChangelogRepository;
import com.poc.jira.repository.JiraIssueRepository;
import com.poc.jira.repository.JiraUserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class JiraWebhookService {

    private final JiraIssueRepository issueRepo;
    private final JiraUserRepository userRepo;
    private final JiraChangelogRepository changeRepo;

    public JiraWebhookService(JiraIssueRepository issueRepo, JiraUserRepository userRepo, JiraChangelogRepository changeRepo) {
        this.issueRepo = issueRepo;
        this.userRepo = userRepo;
        this.changeRepo = changeRepo;
    }

    public void processWebhook(JiraWebhookDTO dto) {
        if (dto == null || dto.getIssue() == null || dto.getIssue().getKey() == null) {
            return;
        }
        upsertIssue(dto);
        upsertUser(dto);
        saveChangelog(dto);
    }

    private void upsertIssue(JiraWebhookDTO dto) {
        String issueKey = dto.getIssue().getKey();

        issueRepo.findByIssueKey(issueKey)
                .ifPresentOrElse(
                        issue ->
                                updateExistingIssue(issue, dto),
                        () -> createNewIssue(dto)
                );
    }

    private void updateExistingIssue(JiraIssue issue, JiraWebhookDTO dto) {
        if (dto.getIssue().getFields() != null) {
            if (dto.getIssue().getFields().getSummary() != null) {
                issue.setSummary(dto.getIssue().getFields().getSummary());
            }
            if (dto.getIssue().getFields().getStatus() != null) {
                issue.setStatus(dto.getIssue().getFields().getStatus().getName());
            }
            if (dto.getIssue().getFields().getPriority() != null) {
                issue.setPriority(dto.getIssue().getFields().getPriority().getName());
            }
        }

        if (dto.getWebhookEvent() != null) {
            issue.setWebhookEvent(dto.getWebhookEvent());
        }

        issue.setUpdatedAt(LocalDateTime.now());
        issueRepo.save(issue);
    }

    private void createNewIssue(JiraWebhookDTO dto) {
        if (dto.getIssue().getFields() == null) {
            return;
        }

        JiraIssue newIssue = new JiraIssue();
        newIssue.setIssueKey(dto.getIssue().getKey());

        if (dto.getIssue().getFields().getSummary() != null) {
            newIssue.setSummary(dto.getIssue().getFields().getSummary());
        }
        if (dto.getIssue().getFields().getStatus() != null) {
            newIssue.setStatus(dto.getIssue().getFields().getStatus().getName());
        }
        if (dto.getIssue().getFields().getPriority() != null) {
            newIssue.setPriority(dto.getIssue().getFields().getPriority().getName());
        }
        if (dto.getWebhookEvent() != null) {
            newIssue.setWebhookEvent(dto.getWebhookEvent());
        }

        issueRepo.save(newIssue);
    }

    private void upsertUser(JiraWebhookDTO dto) {
        if (dto.getUser() == null || dto.getUser().getAccountId() == null) {
            return;
        }

        String accountId = dto.getUser().getAccountId();

        userRepo.findByAccountId(accountId)
                .ifPresentOrElse(
                        user -> updateExistingUser(user, dto),
                        () -> createNewUser(dto)
                );
    }

    private void updateExistingUser(JiraUser user, JiraWebhookDTO dto) {
        if (dto.getUser().getDisplayName() != null) {
            user.setDisplayName(dto.getUser().getDisplayName());
        }
        if (dto.getUser().getTimeZone() != null) {
            user.setTimeZone(dto.getUser().getTimeZone());
        }
        userRepo.save(user);
    }

    private void createNewUser(JiraWebhookDTO dto) {
        JiraUser user = new JiraUser();
        user.setAccountId(dto.getUser().getAccountId());

        if (dto.getUser().getDisplayName() != null) {
            user.setDisplayName(dto.getUser().getDisplayName());
        }
        if (dto.getUser().getTimeZone() != null) {
            user.setTimeZone(dto.getUser().getTimeZone());
        }
        if (dto.getUser().getAccountType() != null) {
            user.setAccountType(dto.getUser().getAccountType());
        }

        userRepo.save(user);
    }

    private void saveChangelog(JiraWebhookDTO dto) {
        if (dto.getChangelog() == null || dto.getChangelog().getItems() == null) {
            return;
        }

        dto.getChangelog().getItems().forEach(item -> {
            if (item != null) {
                saveChangelogItem(dto.getIssue().getKey(), item);
            }
        });
    }

    private void saveChangelogItem(String issueKey, com.poc.jira.dto.ChangelogItem item) {
        JiraChangelog log = new JiraChangelog();
        log.setIssueKey(issueKey);

        if (item.getField() != null) {
            log.setField(item.getField());
        }
        if (item.getFromString() != null) {
            log.setFromString(item.getFromString());
        }
        if (item.getToString() != null) {
            log.setToString(item.getToString());
        }

        changeRepo.save(log);
    }
}