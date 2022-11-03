package com.cooksys.twitterapi.repositories;

import com.cooksys.twitterapi.entities.Hashtag;
import com.cooksys.twitterapi.entities.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {

    Optional<Tweet> findByIdAndDeletedFalse(Long id);

    List<Tweet> findByInReplyToAndDeletedFalse(Tweet inReplyTo);
}
