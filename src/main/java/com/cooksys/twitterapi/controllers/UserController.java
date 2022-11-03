package com.cooksys.twitterapi.controllers;


import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.twitterapi.dtos.TweetResponseDto;
import com.cooksys.twitterapi.dtos.UserResponseDto;
import com.cooksys.twitterapi.services.TweetService;
import com.cooksys.twitterapi.services.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private UserService userService;
//    private final TweetService tweetService;
    
    @GetMapping("/@{username}/followers")
    public List<UserResponseDto> getFollowers(@PathVariable String username){
    	return userService.getFollowers(username);
    }
    
    @GetMapping("/@{username}/feed")
    public List<TweetResponseDto> getUserfeed(@PathVariable String username){
    	return userService.getUserFeed(username);
    }
}
