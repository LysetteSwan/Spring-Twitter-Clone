package com.cooksys.twitterapi.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;
import org.hibernate.annotations.CreationTimestamp;

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

    @CreationTimestamp
    @Column(nullable = false)
    private Timestamp joined;

    @Column(nullable = false)
    private Boolean deleted = false;

    @Embedded
    private Profile profile;

    @Embedded
    private Credentials credentials;

    @OneToMany (mappedBy = "author", cascade = {CascadeType.ALL})
    private List<Tweet> tweets;

    @ManyToMany
    @JoinTable(name = "user_likes", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "tweet_id"))
    private List<Tweet> userLiked;

    @ManyToMany(mappedBy = "userMentions")
    private List<Tweet> userMentioned;

    @ManyToMany(mappedBy = "following")
    private List<TwitterUser> followers;

    @ManyToMany
    @JoinTable(name = "followers_following") // need to name table i.e explicitly name it followers_following
    private List<TwitterUser> following;


}
