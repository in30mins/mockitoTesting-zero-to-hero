package com.in30mins.service;

import org.springframework.stereotype.Service;

@Service
public class WelcomeService {
    public String getGreetings() {
        return "Hello world";
    }
}
