package com.practice.mainserver.controller;

import com.practice.dto.model.MyResponse;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MainServerController {
    private RestTemplate restTemplate = new RestTemplate();
    private String subServerUrl = "http://sub:9090/sub";
    @Autowired
    private EntityManager entityManager;

    @GetMapping("/main")
    public String mainEndpoint() {
        String result = entityManager.createQuery("select 'Message from Postgres'", String.class)
                .getSingleResult();
        ResponseEntity<MyResponse> response = restTemplate.getForEntity(subServerUrl, MyResponse.class);
        MyResponse msgFromSub = response.getBody();
        return "Message from MainServer {%s} {%s}".formatted(msgFromSub, result);
    }
}
