package com.poc.jira.repository;

import com.poc.jira.entity.JiraIssue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JiraIssueRepository extends JpaRepository<JiraIssue, Long> {
    Optional<JiraIssue> findByIssueKey(String key);
}