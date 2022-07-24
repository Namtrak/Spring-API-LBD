package com.example.SpringSecurityLBD.admin;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/admin")
public class AdminController {

    @GetMapping
    public String getAdmin() {
        return "This is admin!";
    }

    @PostMapping
    public String createUser() {
        return "User created!";
    }

    @DeleteMapping
    public String deleteUser() {
        return "User deleted!";
    }
}
