package com.cooksys.twitterapi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.twitterapi.dtos.TweetResponseDto;
import com.cooksys.twitterapi.services.HashtagService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tags")
public class HashtagController {

    private final HashtagService hashtagService;
    
    
    @GetMapping("/{label}")
    public List<TweetResponseDto> getTweetByHashTag(@PathVariable String label){
    return hashtagService.getTweetByHashTag(label);
    
    }
    
}
