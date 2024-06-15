package com.in30mins.controller;

import com.in30mins.service.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class GreetingsController {
    @Autowired
    private WelcomeService welcomeService;

    @GetMapping("/welcome")
    public ResponseEntity<String> greeting(){
        return new ResponseEntity<>(welcomeService.getGreetings(), HttpStatus.OK);
    }
}
