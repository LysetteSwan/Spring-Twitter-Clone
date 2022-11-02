package com.cooksys.twitterapi.services.impl;

import java.util.List;

import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties.Credential;
import org.springframework.stereotype.Service;

import com.cooksys.twitterapi.dtos.ContextDto;
import com.cooksys.twitterapi.dtos.TweetResponseDto;
import com.cooksys.twitterapi.dtos.UserResponseDto;
import com.cooksys.twitterapi.entities.Tweet;
import com.cooksys.twitterapi.mappers.TweetMapper;
import com.cooksys.twitterapi.repositories.TweetRepository;
import com.cooksys.twitterapi.services.TweetService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class TweetServiceImpl implements TweetService {

	private final TweetRepository tweetRepository;
	private final TweetMapper tweetMapper;

	@Override
	public List<TweetResponseDto> getAllTweets() {
		return null;

//	List<Tweet> allTweets = tweetRepository.findAll();
//	List<Tweet> activeTweets = new List<Tweet>();
//	for(Tweet t: allTweets) {
//		if(!t.getDeleted()) {
//			activeTweets.add(t);
//		}
//	}
//	return tweetMapper.entitiesToDtos(activeTweets);	
//		
	}

	@Override
	public List<UserResponseDto> getMentionsById(Long id) {
		return null;
	}

	@Override
	public ContextDto getContextById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TweetResponseDto repostTweetById(Long id, Credential credential) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TweetResponseDto deleteTweetbyId(Long id, Credential credential) {
		// TODO Auto-generated method stub
		return null;
	}

}
