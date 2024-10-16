package com.example.demo.controller;

import org.kohsuke.github.GitHub;
import org.kohsuke.github.GHCreateRepositoryBuilder;
import org.kohsuke.github.GHOrganization;
import org.kohsuke.github.GHRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
public class GitHubController {

    @Value("${github.token}")
    private String gitHubToken;

    @PostMapping("/create-org")
    public String createOrganization(@RequestBody Map<String, String> request) {
        String orgName = request.get("orgName");
        String repoName = request.get("repoName");

        try {
            GitHub github = GitHub.connectUsingOAuth(gitHubToken);
            GHOrganization organization = github.createOrganization(orgName);
            GHCreateRepositoryBuilder builder = organization.createRepository(repoName);
            GHRepository repository = builder.create();
            return "Organization and repository created successfully: " + repository.getHtmlUrl();
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to create organization and repository: " + e.getMessage();
        }
    }
}
