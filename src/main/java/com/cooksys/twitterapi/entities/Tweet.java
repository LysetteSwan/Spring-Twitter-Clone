package com.cooksys.twitterapi.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Tweet {

    @Id
    @GeneratedValue
    private Long id;

    @CreationTimestamp
    @Column(nullable = false)
    private Timestamp posted;

    @Column(nullable = false)
    private Boolean deleted = false;

    private String content;

    @ManyToOne
    private TwitterUser author;

    @ManyToMany
    @JoinTable(name = "tweet_hashtags", joinColumns = @JoinColumn(name = "tweet_id"), inverseJoinColumns = @JoinColumn(name = "hashtag_id"))
    private List<Hashtag> hashtags;

    @ManyToOne
    private Tweet inReplyTo;

    @OneToMany(mappedBy = "inReplyTo")
    private List<Tweet> replies;

    @ManyToOne
    private Tweet repostOf;

    @OneToMany(mappedBy = "repostOf")
    private List<Tweet> reposts;

//    @ManyToOne
//    @JoinColumn(name = "user_table_id")
//    private TwitterUser twitterUser;

    @ManyToMany (mappedBy = "userLiked")
    private List<TwitterUser> userLikes;

    @ManyToMany
    @JoinTable(name = "user_mentions", joinColumns = @JoinColumn(name = "tweet_id"), inverseJoinColumns = @JoinColumn(name = "user_id")) // Will need to put stuff in parentheses in table i.e name for table, join column and inverse join column for tweet_id and user_id
    // for user entity will need to incorporate all of that as well.
    private List<TwitterUser> userMentions;



}
