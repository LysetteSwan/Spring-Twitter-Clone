package com.cooksys.twitterapi.repositories;

import com.cooksys.twitterapi.entities.Hashtag;
import com.cooksys.twitterapi.entities.TwitterUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<TwitterUser, Long> {

}
