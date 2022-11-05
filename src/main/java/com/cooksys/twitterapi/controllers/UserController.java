package com.cooksys.twitterapi.controllers;
import java.util.List;
import lombok.AllArgsConstructor;
import com.cooksys.twitterapi.dtos.TweetResponseDto;
import com.cooksys.twitterapi.dtos.UserResponseDto;
import com.cooksys.twitterapi.entities.Credentials;
import com.cooksys.twitterapi.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private UserService userService;
 
    
    @GetMapping("/@{username}/followers")
    public List<UserResponseDto> getFollowers(@PathVariable String username){
    	return userService.getFollowers(username);
    }
    
    @GetMapping("/@{username}/feed")
    public List<TweetResponseDto> getUserfeed(@PathVariable String username){
    	return userService.getUserFeed(username);
    }
    
    @GetMapping("/@{username}") //endpoint #25
    public UserResponseDto getUser(@PathVariable String username) {
        return userService.getUser(username);
    }
    
    @GetMapping("/@{username}/tweets") //endpoint #19
    public List<TweetResponseDto> getUserTweets(@PathVariable String username) {
        return userService.getUserTweets(username);
    }
    
    @GetMapping("/@{username}/following") //endpoint #16
    public List<UserResponseDto> getFollowedUsers(@PathVariable String username) {
        return userService.getFollowedUsers(username);
    }
    
    @PostMapping("/@{username}/follow")//endpoint #22
    public void followUser(@PathVariable String username, @RequestBody Credentials credentials) {
        userService.followUser(username, credentials);
    }
    
    
}
