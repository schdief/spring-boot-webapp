package com.example.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class GitHubControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCreateOrganization() throws Exception {
        String requestBody = "{\"orgName\": \"test-org\", \"repoName\": \"test-repo\"}";

        MvcResult result = mockMvc.perform(post("/create-org")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().string("Organization and repository created successfully: https://github.com/test-org/test-repo"))
                .andReturn();
    }
}
