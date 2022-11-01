package com.cooksys.twitterapi.controllers;

import com.cooksys.twitterapi.services.HashtagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hashtag")
public class HashtagController {

    private final HashtagService hashtagService;
}
