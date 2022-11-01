package com.cooksys.twitterapi.controllers;


import com.cooksys.twitterapi.services.ValidateService;
import com.cooksys.twitterapi.services.impl.ValidateServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/validate")
public class ValidateController {

    private final ValidateService validateService;
}
