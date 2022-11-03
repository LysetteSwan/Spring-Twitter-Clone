package com.cooksys.twitterapi.services.impl;

import com.cooksys.twitterapi.dtos.ProfileDto;
import com.cooksys.twitterapi.dtos.TweetResponseDto;
import com.cooksys.twitterapi.dtos.UserResponseDto;
import com.cooksys.twitterapi.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Override
    public List<UserResponseDto> getFollowers(String username) {
        return null;
    }

    @Override
    public List<TweetResponseDto> getUserFeed(String username) {
        return null;
    }

    @Override
    public UserResponseDto deleteUser(String username, EmbeddedLdapProperties.Credential credential) {
        return null;
    }

    @Override
    public UserResponseDto createUser(ProfileDto profileDto) {
        return null;
    }
}
