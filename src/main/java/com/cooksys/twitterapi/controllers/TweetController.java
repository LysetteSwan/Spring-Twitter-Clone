package com.cooksys.twitterapi.controllers;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.twitterapi.dtos.TweetRequestDto;
import com.cooksys.twitterapi.dtos.TweetResponseDto;
import com.cooksys.twitterapi.dtos.UserResponseDto;
import com.cooksys.twitterapi.services.TweetService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tweet")
public class TweetController {

    private final TweetService tweetService;
    
    @GetMapping("/{id}/reposts")
    public ResponseEntity<List<TweetResponseDto>> getReposts(@PathVariable Long id){
    	return tweetService.getReposts(id);
    }
    
    @GetMapping("/{id}/likes")
    public ResponseEntity<List<UserResponseDto>> getLikes(@PathVariable Long id){
    	return tweetService.getLikes(id);
    }
    
    @PostMapping("/{id}/reply")
    public ResponseEntity<List<TweetResponseDto>> replyTweet(@PathVariable Long id, @RequestBody TweetRequestDto tweet){
    	return tweetService.replyTweet(tweet, id);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<List<TweetResponseDto>> getTweet(@PathVariable Long id){
    	return tweetService.getTweet(id);
    }
    
    
}
