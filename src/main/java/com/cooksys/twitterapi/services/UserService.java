package com.cooksys.twitterapi.services;

import java.util.List;

import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties.Credential;

import com.cooksys.twitterapi.dtos.ProfileDto;
import com.cooksys.twitterapi.dtos.TweetResponseDto;
import com.cooksys.twitterapi.dtos.UserResponseDto;

public interface UserService {

	List<UserResponseDto> getFollowers(String username);

	List<TweetResponseDto> getUserFeed(String username);

	UserResponseDto deleteUser(String username, Credential credential);

	UserResponseDto createUser(ProfileDto profileDto);
}
