package com.cooksys.twitterapi.controllers;


import com.cooksys.twitterapi.services.ValidateService;
import com.cooksys.twitterapi.services.impl.ValidateServiceImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/validate")
public class ValidateController {

    private final ValidateService validateService;
	
    @GetMapping("/username/exists/@{username}")
    public boolean validateUserExist(@PathVariable String username) {
        return validateService.validateUserExist(username);
    }	
	
}
