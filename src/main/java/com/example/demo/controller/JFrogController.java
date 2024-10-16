package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
public class JFrogController {

    @Value("${jfrog.api.url}")
    private String jfrogApiUrl;

    @Value("${jfrog.api.token}")
    private String jfrogApiToken;

    @PostMapping("/jfrog/project")
    public ResponseEntity<String> createProject(@RequestBody Map<String, Object> projectDetails) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + jfrogApiToken);
        headers.set("Content-Type", "application/json");

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(projectDetails, headers);
        ResponseEntity<String> response = restTemplate.exchange(jfrogApiUrl + "/access/api/v1/projects", HttpMethod.POST, requestEntity, String.class);

        return response;
    }
}
