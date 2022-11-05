package com.cooksys.twitterapi.services.impl;

import lombok.RequiredArgsConstructor;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.cooksys.twitterapi.entities.TwitterUser;
import com.cooksys.twitterapi.repositories.UserRepository;
import com.cooksys.twitterapi.services.ValidateService;

@Service
@RequiredArgsConstructor
public class ValidateServiceImpl implements ValidateService {
	private final UserRepository userRepository;
	
	@Override
	public boolean validateUserExist(String username) {
		Optional<TwitterUser> userOptional = userRepository.findByCredentialsUsername(username);
		return userOptional.isPresent();
	}
}
