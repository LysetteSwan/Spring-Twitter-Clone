package com.cooksys.twitterapi.mappers;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = CredentialsMapper.class)
public interface ProfileMapper {

}
