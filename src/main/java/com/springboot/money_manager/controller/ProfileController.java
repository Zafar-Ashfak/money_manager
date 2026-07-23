package com.springboot.money_manager.controller;

import com.springboot.money_manager.dto.ProfileDTO;
import com.springboot.money_manager.services.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService profileService;

    @PostMapping("/register")
    public ResponseEntity<?> registerProfile(@RequestBody ProfileDTO profileDTO) {
        ProfileDTO registerProfile = this.profileService.registerProfile(profileDTO);
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(registerProfile);
        } catch (Exception e) {
            e.fillInStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to register a profile");
        }
    }
}
