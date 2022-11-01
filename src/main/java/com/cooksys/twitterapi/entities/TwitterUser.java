package com.cooksys.twitterapi.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class TwitterUser {

    @Id
    @GeneratedValue
    private Long id;

    private Timestamp joined;

    private Boolean deleted;

    @Embedded
    private Profile profile;

    @Embedded
    private Credentials credentials;

    @OneToMany (mappedBy = "twitterUser", cascade = {CascadeType.ALL})
    private List<Tweet> tweets;

//    @OneToMany (mappedBy = "user_likes")
    // Currently don't have a user_likes table, so using Integer for now.
    private List<Integer> user_likes;

//    @OneToMany (mappedBy = "user_mentions")
    private List<TwitterUser> user_mentions;

//    @OneToMany (mappedBy = "follower_id")
    private List<Integer> followers;

//    @OneToMany (mappedBy = "twitterUser")
    private List<Integer> following;


}
