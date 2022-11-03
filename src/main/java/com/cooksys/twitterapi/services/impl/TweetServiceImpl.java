package com.cooksys.twitterapi.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.cooksys.twitterapi.dtos.TweetRequestDto;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties.Credential;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	private Tweet checkForTweet (Long id) {
		Optional<Tweet> findIfTweetExists = tweetRepository. findByIdAndDeletedFalse(id);

		if (!findIfTweetExists.isPresent()) {
			throw new IllegalArgumentException("The tweet does not exist");
		}

		return findIfTweetExists.get();
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

	@Override
	public List<TweetResponseDto> getCurrentTweets() {
		return tweetMapper.entitiesToDtos(
				tweetRepository.findAll().stream().filter(tweet -> !tweet.getDeleted()).collect(Collectors.toList()));
	};

//	List<Tweet> allTweets = tweetRepository.findAll();
//	List<Tweet> activeTweets = new List<Tweet>();
//	for(Tweet t: allTweets) {
//		if(!t.getDeleted()) {
//			activeTweets.add(t);
//		}
//	}
//	return tweetMapper.entitiesToDtos(activeTweets);	
//		

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

	@Override // Logic for Endpoint #3
	public ResponseEntity<List<TweetResponseDto>> getTweetReplies(Long id) {
		Tweet tweetBeingRepliedTo = checkForTweet(id);

		List<Tweet> replies = tweetRepository.findByInReplyToAndDeletedFalse(tweetBeingRepliedTo);

		List<TweetResponseDto> response = tweetMapper.entitiesToDtos(replies);

		return new ResponseEntity<>(response, HttpStatus.I_AM_A_TEAPOT);
	}

}
