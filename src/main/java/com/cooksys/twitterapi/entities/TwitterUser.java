package com.cooksys.twitterapi.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

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

    @Column(nullable = false)
    private Boolean deleted = false;

    @Embedded
    private Profile profile;

    @Embedded
    private Credentials credentials;

    @OneToMany (mappedBy = "author", cascade = {CascadeType.ALL})
    private List<Tweet> tweets;

    @ManyToMany(mappedBy = "user_likes")
    private List<Tweet> user_liked;

    @ManyToMany(mappedBy = "user_mentions")
    private List<Tweet> user_mentioned;

    @ManyToMany
    private List<TwitterUser> followers;

    @ManyToMany
    private List<TwitterUser> following;


}
