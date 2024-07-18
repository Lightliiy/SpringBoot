package com.example.MyApp.Controller;

import com.example.MyApp.Model.ResetPasswordRequest;
import com.example.MyApp.Services.PasswordServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
public class PasswordController {

    @Autowired
    private PasswordServices PasswordServices;

    @PostMapping("/reset")
    public ResponseEntity<?> resetPassword(@RequestBody ResetPasswordRequest resetPasswordRequest) {
        try {
            // Validate request
            if (resetPasswordRequest.getNewPassword() == null || resetPasswordRequest.getNewPassword().isEmpty()) {
                return ResponseEntity.badRequest().body("New password cannot be empty.");
            }

            PasswordServices.resetPassword(resetPasswordRequest.getEmail(), resetPasswordRequest.getNewPassword());
            return ResponseEntity.ok("Password reset successfully.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
}

