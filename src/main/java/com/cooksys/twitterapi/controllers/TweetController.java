package com.cooksys.twitterapi.controllers;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import com.cooksys.twitterapi.dtos.ContextDto;
import com.cooksys.twitterapi.dtos.TweetResponseDto;
import com.cooksys.twitterapi.dtos.UserResponseDto;
import com.cooksys.twitterapi.services.TweetService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import lombok.RequiredArgsConstructor;
import com.cooksys.twitterapi.entities.Credentials;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cooksys.twitterapi.dtos.TweetRequestDto;

@RestController
@AllArgsConstructor
@RequestMapping("/tweets")
public class TweetController {

    private TweetService tweetService;
    
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
    public TweetResponseDto getTweetById(@PathVariable Long id) {
        return tweetService.getTweetById(id);
    }
    
   
   @GetMapping // endpoint #13
   public List<TweetResponseDto> getCurretTweets() {
     return tweetService.getCurrentTweets();
   }
   
   @GetMapping("/{id}/mentions") //endpoint #1
   public List<UserResponseDto>getMentionsById(@PathVariable Long id){
	   return tweetService.getMentionsById(id);
   }
   
   @GetMapping("/{id}/context")//endpoint 4 
   public ContextDto getContextById(@PathVariable Long id){
	   return tweetService.getContextById(id); 
   }
   
   @PostMapping("/{id}/repost") //endpoint #7 
   //@ResponseStatus(HttpStatus.CREATED)
   public TweetResponseDto repostTweetById(@PathVariable Long id, @RequestBody Credentials credentials ) {
	   return tweetService.repostTweetById(id, credentials);
   }
   
   @DeleteMapping("/{id}") //endpoint #10 
   public TweetResponseDto deleteTweetById(@PathVariable Long id, @RequestBody Credentials credentials) {
	   return tweetService.deleteTweetbyId(id, credentials);
   }

    @GetMapping("/{id}/replies") // Endpoint #3
    public ResponseEntity<List<TweetResponseDto>> getRepliesOfTweet(@PathVariable Long id) {
        return tweetService.getTweetReplies(id);
    }

}
