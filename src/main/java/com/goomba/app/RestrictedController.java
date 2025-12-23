package com.goomba.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/restricted")
public class RestrictedController {
    @GetMapping
    public String accessible() {
        return "You have access...";
    }
}
