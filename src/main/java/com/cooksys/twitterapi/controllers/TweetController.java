package com.cooksys.twitterapi.controllers;


import com.cooksys.twitterapi.dtos.ContextDto;
import com.cooksys.twitterapi.dtos.TweetResponseDto;
import com.cooksys.twitterapi.dtos.UserResponseDto;
import com.cooksys.twitterapi.services.TweetService;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties.Credential;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tweet")
public class TweetController {

   private final TweetService tweetService;
   
   @GetMapping 
   public List<TweetResponseDto> getAllTweets() {
     return tweetService.getAllTweets();
   }
   
   @GetMapping("/{id}/mentions")
   public List<UserResponseDto>getMentionsById(@PathVariable Long id){
	   return tweetService.getMentionsById(id);
   }
   
   
   @GetMapping("/{id}/context")
   public ContextDto getContextById(@PathVariable Long id){
	   return tweetService.getContextById(id);
   }
   
   @PostMapping("/{id}/repost")
   //@ResponseStatus(HttpStatus.CREATED)
   public TweetResponseDto repostTweetById(@PathVariable Long id, @RequestBody Credential credential ) {
	   return tweetService.repostTweetById(id, credential);
   }
   
   @DeleteMapping("/{id}")
   public TweetResponseDto deleteTweetById(@PathVariable Long id, @RequestBody Credential credential) {
	   return tweetService.deleteTweetbyId(id, credential);
   }
   
}
