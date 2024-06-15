package com.in30mins.controller;

import com.in30mins.entity.Employee;
import com.in30mins.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PostController {
    @Autowired
    private EmpService empService;

    @PostMapping("/addEmp")
    public ResponseEntity<String> addEmp(@RequestBody Employee employee){
        String msg = null;
        boolean isSaved = empService.saveEmp(employee);

        if(isSaved) {
            msg = "Employee Saved...";
            return new ResponseEntity<>(msg, HttpStatus.CREATED);
        }else {
            msg = "Failed to Save...";
            return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
        }
    }
}
