package com.cooksys.twitterapi.repositories;

//import com.cooksys.twitterapi.entities.Hashtag;
import com.cooksys.twitterapi.entities.TwitterUser;

import com.cooksys.twitterapi.entities.Credentials;
import java.util.Optional;

//import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties.Credential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<TwitterUser, Long> {

Optional<TwitterUser>findUserByCredentials(Credentials credentials); 
}


