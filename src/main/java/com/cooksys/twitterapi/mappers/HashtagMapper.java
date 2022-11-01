package com.cooksys.twitterapi.mappers;

import com.cooksys.twitterapi.dtos.HashtagDto;
import com.cooksys.twitterapi.entities.Hashtag;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HashtagMapper {

    HashtagDto entityToDto(Hashtag entity);

    List<HashtagDto> entitiesToDtos(List<Hashtag> entities);

    Hashtag dtoToEntity (HashtagDto hashtagDto);
}
