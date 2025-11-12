package com.poc.jira.controller;

import com.poc.jira.dto.JiraWebhookDTO;
import com.poc.jira.service.JiraWebhookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/jira")
public class JiraWebhookController {

    private final JiraWebhookService jiraWebhookService;

    public JiraWebhookController(JiraWebhookService jiraWebhookService) {
        this.jiraWebhookService = jiraWebhookService;

    }

    @PostMapping("/callback")
    public ResponseEntity<String> handleWebhook(@RequestBody JiraWebhookDTO dto) {
        // Process the incoming webhook data using the service
        jiraWebhookService.processWebhook(dto);
        return ResponseEntity.ok("Webhook received and processed");
    }
}