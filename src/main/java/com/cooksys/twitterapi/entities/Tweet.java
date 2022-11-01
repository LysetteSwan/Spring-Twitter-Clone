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
public class Tweet {

    @Id
    @GeneratedValue
    private Long id;

    @CreationTimestamp
    private Timestamp posted;

    private Boolean deleted;

    private String content;

    private Integer author;

    @OneToMany (mappedBy = "tweet", cascade = {CascadeType.ALL})
    private Tweet inReplyTo;

    // Then you can have a list of replies.

    private Tweet repostOf;

    // Then you can have a list of reposts.

    private List<Hashtag> tweet_hashtags;

    private List<Integer> user_likes;

    private List<User> user_mentions;

    @ManyToOne
    @JoinColumn(name = "user_table_id")
    private TwitterUser twitterUser;




}
