package com.cooksys.twitterapi.services;

import java.util.List;

import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties.Credential;

import com.cooksys.twitterapi.dtos.ContextDto;
import com.cooksys.twitterapi.dtos.TweetResponseDto;
import com.cooksys.twitterapi.dtos.UserResponseDto;

public interface TweetService {

	List<TweetResponseDto> getAllTweets();

	List<UserResponseDto> getMentionsById(Long id);

	ContextDto getContextById(Long id);

	TweetResponseDto repostTweetById(Long id, Credential credential);

	TweetResponseDto deleteTweetbyId(Long id, Credential credential);
}
