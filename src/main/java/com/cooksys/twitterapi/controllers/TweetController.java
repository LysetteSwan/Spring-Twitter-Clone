package com.cooksys.twitterapi.controllers;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import com.cooksys.twitterapi.dtos.ContextDto;
import com.cooksys.twitterapi.dtos.TweetResponseDto;
import com.cooksys.twitterapi.dtos.UserResponseDto;
import com.cooksys.twitterapi.services.TweetService;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties.Credential;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<List<TweetResponseDto>> getTweet(@PathVariable Long id){
    	return tweetService.getTweet(id);
    }
   
   @GetMapping 
   public List<TweetResponseDto> getCurretTweets() {
     return tweetService.getCurrentTweets();
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

    @GetMapping("/{id}/replies") // Endpoint #3
    public ResponseEntity<List<TweetResponseDto>> getRepliesOfTweet(@PathVariable Long id) {
        return tweetService.getTweetReplies(id);
    }

}
