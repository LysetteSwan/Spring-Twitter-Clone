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
    private Timestamp posted;

    @Column(nullable = false)
    private Boolean deleted = false;

    private String content;

    @ManyToOne
    @JoinColumn
    private TwitterUser author;

    @ManyToMany
    @JoinTable
    private List<Hashtag> hashtags;

    @ManyToOne
    @JoinColumn
    private Tweet inReplyTo;

    @OneToMany(mappedBy = "inReplyTo")
    private List<Tweet> replies;

    @ManyToOne
    @JoinColumn
    private Tweet repostOf;

    @OneToMany(mappedBy = "repostOf")
    private List<Tweet> reposts;

    @ManyToOne
    @JoinColumn(name = "user_table_id")
    private TwitterUser twitter_user;

    @ManyToMany
    @JoinTable
    private List<TwitterUser> user_likes;

    @ManyToMany
    @JoinTable
    private List<TwitterUser> user_mentions;



}
