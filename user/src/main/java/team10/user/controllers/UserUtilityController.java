package team10.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team10.user.services.UserUtilityService;

@RestController
@RequestMapping("util")
public class UserUtilityController {
    @Autowired
    private UserUtilityService userUtilityService;

    @GetMapping("exists/{email}")
    public ResponseEntity<Boolean> userExists(@PathVariable("email") String email) {
        return ResponseEntity.ok(userUtilityService.userExists(email));
    }
}