package com.cooksys.twitterapi.services;

import java.util.List;

import com.cooksys.twitterapi.dtos.TweetResponseDto;

public interface HashtagService {

	List<TweetResponseDto> getTweetByHashTag(String label);
}
