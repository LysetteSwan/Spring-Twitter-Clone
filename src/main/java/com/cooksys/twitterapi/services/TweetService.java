package com.cooksys.twitterapi.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cooksys.twitterapi.dtos.TweetRequestDto;
import com.cooksys.twitterapi.entities.Credentials;
import com.cooksys.twitterapi.dtos.ContextDto;
import com.cooksys.twitterapi.dtos.TweetResponseDto;
import com.cooksys.twitterapi.dtos.UserResponseDto;

public interface TweetService {

	ResponseEntity<List<TweetResponseDto>> getReposts(Long id);

	ResponseEntity<List<UserResponseDto>> getLikes(Long id);

	ResponseEntity<List<TweetResponseDto>> replyTweet(TweetRequestDto tweet, Long id);
	
	List<TweetResponseDto> getCurrentTweets();

	List<UserResponseDto> getMentionsById(Long id);

	ContextDto getContextById(Long id);

	TweetResponseDto repostTweetById(Long id, Credentials credentials);

	TweetResponseDto deleteTweetbyId(Long id, Credentials credentials);

    ResponseEntity<List<TweetResponseDto>> getTweetReplies(Long id);

	TweetResponseDto getTweetById(Long id);


}
