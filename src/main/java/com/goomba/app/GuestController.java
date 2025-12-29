package com.goomba.app;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/guest")
public class GuestController {
    @GetMapping
    public String guest(@AuthenticationPrincipal UserDetails userDetails) {
        return "Hey there guest... " + userDetails.getUsername();
    }
}
