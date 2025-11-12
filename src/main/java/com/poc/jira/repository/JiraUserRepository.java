package com.poc.jira.repository;

import com.poc.jira.entity.JiraUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JiraUserRepository extends JpaRepository<JiraUser, Long> {
    Optional<JiraUser> findByAccountId(String id);
}