package com.cooksys.twitterapi.mappers;

import com.cooksys.twitterapi.dtos.TweetRequestDto;
import com.cooksys.twitterapi.dtos.TweetResponseDto;
import com.cooksys.twitterapi.entities.Tweet;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = HashtagMapper.class)
public interface TweetMapper {

    TweetResponseDto entityToDto(Tweet entity);

    List<TweetResponseDto> entitiesToDtos(List<Tweet> entities);

    Tweet requestDtoToEntity(TweetRequestDto tweetRequestDto);


}
