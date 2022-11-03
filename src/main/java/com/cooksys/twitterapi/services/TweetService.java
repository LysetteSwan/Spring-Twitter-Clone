package com.cooksys.twitterapi.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cooksys.twitterapi.dtos.TweetRequestDto;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties.Credential;

import com.cooksys.twitterapi.dtos.ContextDto;
import com.cooksys.twitterapi.dtos.TweetResponseDto;
import com.cooksys.twitterapi.dtos.UserResponseDto;

public interface TweetService {

	ResponseEntity<List<TweetResponseDto>> getReposts(Long id);

	ResponseEntity<List<UserResponseDto>> getLikes(Long id);

	ResponseEntity<List<TweetResponseDto>> replyTweet(TweetRequestDto tweet, Long id);

	ResponseEntity<List<TweetResponseDto>> getTweet(Long id);

	List<TweetResponseDto> getAllTweets();
	
	List<TweetResponseDto> getCurrentTweets();

	List<UserResponseDto> getMentionsById(Long id);

	ContextDto getContextById(Long id);

	TweetResponseDto repostTweetById(Long id, Credential credential);

	TweetResponseDto deleteTweetbyId(Long id, Credential credential);

    ResponseEntity<List<TweetResponseDto>> getTweetReplies(Long id);

}
