package com.example.jwt.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @PostMapping("/add")
    public String addData() {
        return "Admin added data successfully.";
    }

    @PostMapping("/delete")
    public String deleteData() {
        return "Admin deleted data successfully.";
    }
}
