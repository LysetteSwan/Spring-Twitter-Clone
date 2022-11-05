package com.cooksys.twitterapi.services.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
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
import com.cooksys.twitterapi.exceptions.BadRequestException;
import com.cooksys.twitterapi.exceptions.NotAuthorizedException;
import com.cooksys.twitterapi.mappers.TweetMapper;
import com.cooksys.twitterapi.mappers.UserMapper;
import com.cooksys.twitterapi.repositories.TweetRepository;
import com.cooksys.twitterapi.repositories.UserRepository;
import com.cooksys.twitterapi.services.TweetService;
import lombok.RequiredArgsConstructor;
//import lombok.extern.java.Log;

@Service
@RequiredArgsConstructor
public class TweetServiceImpl implements TweetService {

	private final TweetRepository tweetRepository;
	private final TweetMapper tweetMapper;
	private final UserRepository userRepository; 
	private final UserMapper userMapper;

	private Tweet checkForTweet (Long id) {
		Optional<Tweet> findIfTweetExists = tweetRepository.findByIdAndDeletedFalse(id);
		if (!findIfTweetExists.isPresent()) {
			throw new IllegalArgumentException("The tweet does not exist");
		}
		return findIfTweetExists.get();
	}
	
	//helper method to authorized credentials, i used this for a method that takes in credentials as a parameter
	private TwitterUser authCredentials(Credentials credentials) {
	Optional<TwitterUser> twitterUserOptional = userRepository.findUserByCredentials(credentials);
	if( twitterUserOptional.isEmpty() || twitterUserOptional.get().getDeleted())
		throw new NotAuthorizedException("Bad credentials");
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
	public TweetResponseDto getTweetById(Long id) {
	return tweetMapper.entityToDto(getCurrentTweetById(id));
	}
	
	
	

	@Override //logic for endpoint #13
	public List<TweetResponseDto> getCurrentTweets() {
		return tweetMapper.entitiesToDtos(
				tweetRepository.findAll().stream().filter(tweet -> !tweet.getDeleted()).collect(Collectors.toList()));
	};
	

	@Override// logic for end point #1
	public List<UserResponseDto> getMentionsById(Long id) {
		Tweet tweet = checkForTweet(id); 
		List<TwitterUser> users = tweet.getUserMentions();
		for(TwitterUser user : new ArrayList<TwitterUser>(tweet.getUserMentions())) {
			if(user.getDeleted()) {
				users.remove(user);
			}
		}
		
		return userMapper.entitiesToDtos(users);
	}

	@Override//logic for endpoint 4 
	public ContextDto getContextById(Long id) {
		Tweet tweet =  getCurrentTweetById(id);
		ContextDto responseDto = new ContextDto();
		responseDto.setTarget(tweetMapper.entityToDto(tweet));
		responseDto.setBefore(tweetMapper.entitiesToDtos(getTweetsBefore(tweet)));
		responseDto.setAfter(tweetMapper.entitiesToDtos(getTweetsAfter(tweet)));
		return responseDto;
	}

	@Override //logic for endpoint #7 
	public TweetResponseDto repostTweetById(Long id, Credentials credentials) {
		TwitterUser user = authCredentials(credentials);
		Tweet initalTweet = checkForTweet(id);
		Tweet repostTweet = new Tweet(); 
	
		repostTweet.setAuthor(user);
		repostTweet.setRepostOf(initalTweet);
		return tweetMapper.entityToDto(tweetRepository.saveAndFlush(repostTweet));
		
	}
		
		
		
	@Override //logic for endpoint #10 
	public TweetResponseDto deleteTweetbyId(Long id, Credentials credentials) {
		Tweet tweet =  checkForTweet(id);
		TwitterUser twitterUser = authCredentials(credentials);
		if( twitterUser != tweet.getAuthor())
			throw new NotAuthorizedException("Bad credentials");  
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

	//helper method used to get the tweets before the tweet in question; used in the context method 
	private List<Tweet> getTweetsBefore(Tweet tweet) {
		List<Tweet> tweetList = new ArrayList<>(); 
		Tweet theTweetInQuestion = tweet; 
		while (theTweetInQuestion.getInReplyTo() != null) {
			theTweetInQuestion= theTweetInQuestion.getInReplyTo();
			if(!theTweetInQuestion.getDeleted())
				tweetList.add(theTweetInQuestion);
		}
		return tweetList;
		
	}
	

	//helper method used to get the tweets that proceed the tweet in question; used in the context method 
	private List<Tweet> getTweetsAfter(Tweet tweet) {
		List<Tweet> tweetList = new ArrayList<>(); 
		Queue<Tweet> tweetQueue = new LinkedList<>();
		tweetQueue.addAll(tweet.getReplies());
				
				
				while(tweetQueue.size() > 0) {
					Tweet theTweetInQuestion = tweetQueue.poll();
					
					if(!theTweetInQuestion.getDeleted())
						tweetList.add(theTweetInQuestion);
					tweetQueue.addAll(theTweetInQuestion.getReplies());
				}
				return tweetList;
	}

	
	private Tweet getCurrentTweetById(Long id) {
        Optional<Tweet> tweetOptional = tweetRepository.findById(id);
        if (tweetOptional.isEmpty() || tweetOptional.get().getDeleted())
            throw new BadRequestException("Tweet not found");
        return tweetOptional.get();
    }

	
	
	

}
