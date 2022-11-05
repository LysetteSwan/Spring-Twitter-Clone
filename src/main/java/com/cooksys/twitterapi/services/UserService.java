package com.cooksys.twitterapi.services;

import java.util.List;
import com.cooksys.twitterapi.dtos.ProfileDto;
import com.cooksys.twitterapi.dtos.TweetResponseDto;
import com.cooksys.twitterapi.dtos.UserResponseDto;
import com.cooksys.twitterapi.entities.Credentials;

public interface UserService {

	List<UserResponseDto> getFollowers(String username);

	List<TweetResponseDto> getUserFeed(String username);

	UserResponseDto deleteUser(String username, Credentials credentials);

	UserResponseDto createUser(ProfileDto profileDto);

	UserResponseDto getUser(String username);

	List<TweetResponseDto> getUserTweets(String username);

	List<UserResponseDto> getFollowedUsers(String username);

	void followUser(String username, Credentials credentials);
}
