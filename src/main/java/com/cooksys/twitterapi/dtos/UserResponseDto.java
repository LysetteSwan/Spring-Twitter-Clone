package com.cooksys.twitterapi.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@NoArgsConstructor
@Data
public class UserResponseDto {

    private Long id;

    private String username;

    private ProfileDto profile;

    private Timestamp joined;

}
