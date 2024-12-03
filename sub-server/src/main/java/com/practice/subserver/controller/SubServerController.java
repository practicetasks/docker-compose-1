package com.practice.subserver.controller;

import com.practice.dto.model.MyResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubServerController {
    @GetMapping("/sub")
    public MyResponse subEndpoint() {
        return new MyResponse("Message from SubServer");
    }
}
