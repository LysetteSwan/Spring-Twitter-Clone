package com.cooksys.twitterapi.mappers;

import com.cooksys.twitterapi.dtos.UserRequestDto;
import com.cooksys.twitterapi.dtos.UserResponseDto;
import com.cooksys.twitterapi.entities.Tweet;
import com.cooksys.twitterapi.entities.TwitterUser;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TweetMapper.class})
public interface UserMapper {

    UserResponseDto entityToDto(TwitterUser entity);

    List<UserResponseDto> entitiesToDtos(List<TwitterUser> entities);

    TwitterUser dtoToEntity(UserRequestDto dto);

}
