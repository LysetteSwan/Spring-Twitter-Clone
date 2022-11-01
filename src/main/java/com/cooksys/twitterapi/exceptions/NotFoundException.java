package com.cooksys.twitterapi.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = -496665527642614264L;
    private String message;
}
