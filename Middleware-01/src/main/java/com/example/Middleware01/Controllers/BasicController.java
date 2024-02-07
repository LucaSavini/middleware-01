package com.example.Middleware01.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/time")
public class BasicController {

    @GetMapping
    public String getCurrentTime() {
        return "Data/Ora corrente: " + LocalDateTime.now();
    }
}