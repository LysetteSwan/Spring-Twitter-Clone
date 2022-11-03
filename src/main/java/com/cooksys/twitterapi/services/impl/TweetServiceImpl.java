package com.cooksys.twitterapi.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.cooksys.twitterapi.dtos.TweetRequestDto;
import com.cooksys.twitterapi.entities.Credentials;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.cooksys.twitterapi.dtos.ContextDto;
import com.cooksys.twitterapi.dtos.TweetResponseDto;
import com.cooksys.twitterapi.dtos.UserResponseDto;
import com.cooksys.twitterapi.entities.Tweet;
import com.cooksys.twitterapi.entities.TwitterUser;
import com.cooksys.twitterapi.exceptions.NotAuthorizedException;
import com.cooksys.twitterapi.mappers.TweetMapper;
import com.cooksys.twitterapi.repositories.TweetRepository;
import com.cooksys.twitterapi.repositories.UserRepository;
import com.cooksys.twitterapi.services.TweetService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TweetServiceImpl implements TweetService {

	private final TweetRepository tweetRepository;
	private final TweetMapper tweetMapper;
	private final UserRepository userRepository; 

	private Tweet checkForTweet (Long id) {
		Optional<Tweet> findIfTweetExists = tweetRepository. findByIdAndDeletedFalse(id);

		if (!findIfTweetExists.isPresent()) {
			throw new IllegalArgumentException("The tweet does not exist");
		}

		return findIfTweetExists.get();
	}
	//below is a helper method to authorized credentials, i used this for a method that takes in credentials as a parameter
	private TwitterUser authCredentials(Credentials credentials) {
	Optional<TwitterUser> twitterUserOptional = userRepository.findUserByCredentials(credentials);
	if( twitterUserOptional.isEmpty() || twitterUserOptional.get().getDeleted())
		throw new NotAuthorizedException();
	//wont allow me to pass a message into to the not authorized exception
	return twitterUserOptional.get();
	}

	

	@Override
	public ResponseEntity<List<TweetResponseDto>> getReposts(Long id) {
		return null;
	}

	@Override
	public ResponseEntity<List<UserResponseDto>> getLikes(Long id) {
		return null;
	}

	@Override
	public ResponseEntity<List<TweetResponseDto>> replyTweet(TweetRequestDto tweet, Long id) {
		return null;
	}

	@Override
	public ResponseEntity<List<TweetResponseDto>> getTweet(Long id) {
		return null;
	}

	@Override //logic for endpoint #13
	public List<TweetResponseDto> getCurrentTweets() {
		return tweetMapper.entitiesToDtos(
				tweetRepository.findAll().stream().filter(tweet -> !tweet.getDeleted()).collect(Collectors.toList()));
	};
	

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
	public TweetResponseDto repostTweetById(Long id, Credentials credentials) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override //logic for endpoint #10 
	public TweetResponseDto deleteTweetbyId(Long id, Credentials credentials) {
		Tweet tweet =  checkForTweet(id);
		TwitterUser twitterUser = authCredentials(credentials);
		if( twitterUser != tweet.getAuthor())
			throw new NotAuthorizedException(); //wont allow me to pass in a message 
		tweet.setDeleted(true);
        return tweetMapper.entityToDto(tweetRepository.saveAndFlush(tweet));
		
	}

	@Override // Logic for Endpoint #3
	public ResponseEntity<List<TweetResponseDto>> getTweetReplies(Long id) {
		Tweet tweetBeingRepliedTo = checkForTweet(id);

		List<Tweet> replies = tweetRepository.findByInReplyToAndDeletedFalse(tweetBeingRepliedTo);

		List<TweetResponseDto> response = tweetMapper.entitiesToDtos(replies);

		return new ResponseEntity<>(response, HttpStatus.I_AM_A_TEAPOT);
	}

	
	


}
