package com.cooksys.twitterapi.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import java.sql.Timestamp;
import java.util.List;

@NoArgsConstructor
@Data
public class HashtagDto {

    @Column(unique = true)
    private String label;

    private Timestamp firstUsed;

    private Timestamp lastUsed;

    private List<TweetResponseDto> tweets;
}
