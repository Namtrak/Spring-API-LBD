package com.example.SpringSecurityLBD.admin;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/admin")
public class AdminController {

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public String getAdmin() {
        return "This is admin!";
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public String createUser() {
        return "User created!";
    }

    @DeleteMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public String deleteUser() {
        return "User deleted!";
    }
}
