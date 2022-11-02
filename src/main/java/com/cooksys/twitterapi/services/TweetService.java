package com.cooksys.twitterapi.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cooksys.twitterapi.dtos.TweetRequestDto;
import com.cooksys.twitterapi.dtos.TweetResponseDto;
import com.cooksys.twitterapi.dtos.UserResponseDto;

public interface TweetService {

	ResponseEntity<List<TweetResponseDto>> getReposts(Long id);

	ResponseEntity<List<UserResponseDto>> getLikes(Long id);

	ResponseEntity<List<TweetResponseDto>> replyTweet(TweetRequestDto tweet, Long id);

	ResponseEntity<List<TweetResponseDto>> getTweet(Long id);
}
