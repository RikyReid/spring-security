package com.goomba.app;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/restricted")
public class RestrictedController {
    @GetMapping
    public String accessible() {
        var name = SecurityContextHolder.getContext().getAuthentication().getName();
        return "You have access... " + name;
    }
}
