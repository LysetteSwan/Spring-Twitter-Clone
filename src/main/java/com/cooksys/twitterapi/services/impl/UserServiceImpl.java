package com.cooksys.twitterapi.services.impl;

import com.cooksys.twitterapi.dtos.ProfileDto;
import com.cooksys.twitterapi.dtos.TweetResponseDto;
import com.cooksys.twitterapi.dtos.UserResponseDto;
import com.cooksys.twitterapi.entities.Credentials;
import com.cooksys.twitterapi.entities.Tweet;
import com.cooksys.twitterapi.entities.TwitterUser;
import com.cooksys.twitterapi.exceptions.BadRequestException;
import com.cooksys.twitterapi.exceptions.NotAuthorizedException;
import com.cooksys.twitterapi.exceptions.NotFoundException;
import com.cooksys.twitterapi.mappers.TweetMapper;
import com.cooksys.twitterapi.mappers.UserMapper;
import com.cooksys.twitterapi.repositories.UserRepository;
import com.cooksys.twitterapi.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	private final UserMapper userMapper;
	private final UserRepository userRepository; 
	private final TweetMapper tweetMapper;
	
	
private TwitterUser getUserByUsernameHelperMethod(String username) {
		Optional<TwitterUser> optionalUser= userRepository.findByCredentialsUsername(username);
		if (optionalUser.isEmpty())
			return null;
		return optionalUser.get();
		
	}
	
	private boolean isActive(TwitterUser user) {
        return user != null && !user.getDeleted();
    }
	
	
	//helper method to authorized credentials, i used this for a method that takes in credentials as a parameter
	private TwitterUser authCredentials(Credentials credentials) {
	Optional<TwitterUser> twitterUserOptional = userRepository.findUserByCredentials(credentials);
			if( twitterUserOptional.isEmpty() || twitterUserOptional.get().getDeleted())
				throw new NotAuthorizedException("Bad credentials");
			return twitterUserOptional.get();
			}
		
	
	
    @Override
    public List<UserResponseDto> getFollowers(String username) {
        return null;
    }

    @Override
    public List<TweetResponseDto> getUserFeed(String username) {
        return null;
    }

    @Override
    public UserResponseDto deleteUser(String username, Credentials credentials) {
        return null;
    }

    @Override
    public UserResponseDto createUser(ProfileDto profileDto) {
        return null;
    }

	@Override//logic for endpoint #25
	public UserResponseDto getUser(String username) {
		TwitterUser user = getUserByUsernameHelperMethod(username);
		if(user == null || user.getDeleted())
			throw new NotFoundException("User with username '" + username + "' not found");
		return userMapper.entityToDto(user);
	}



	@Override //logic for endpoint #13
	public List<TweetResponseDto> getUserTweets(String username) {
		TwitterUser user = getUserByUsernameHelperMethod(username);
		if(user == null || user.getDeleted()) {
			throw new NotFoundException("User not found");
		}
			
		List<Tweet> activeTweets = new ArrayList<>();	
		for (Tweet t : user.getTweets()) {
			if(!t.getDeleted()) {
				activeTweets.add(t);
			}
		
	}
		activeTweets.sort((e1, e2) -> e2.getPosted().compareTo(e1.getPosted()));
		return tweetMapper.entitiesToDtoList(activeTweets);	

	}



	@Override //logic for endpoint #16
	public List<UserResponseDto> getFollowedUsers(String username) {
		TwitterUser user = getUserByUsernameHelperMethod(username);		
		if(!isActive(user))
			throw new NotFoundException("User not found");
		return userMapper.entitiesToDtos(user.getFollowing().stream().filter(u -> !u.getDeleted()).collect(Collectors.toList()));
	
	}

	@Override //logic for endpoint #22
	public void followUser(String username, Credentials credentials) {
		TwitterUser user = getUserByUsernameHelperMethod(username);	
		TwitterUser follower = authCredentials(credentials);
		if (!isActive(user))
			throw new BadRequestException("User not found");
		if(follower.getFollowing().contains(user))
			throw new BadRequestException("Already following");
		follower.addFollowing(user);
		userRepository.saveAndFlush(follower);
		userRepository.saveAndFlush(user);
	}
	

	
	
}


