package com.poc.jira.repository;

import com.poc.jira.entity.JiraChangelog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JiraChangelogRepository extends JpaRepository<JiraChangelog, Long> {}
