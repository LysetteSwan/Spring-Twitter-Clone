package com.cooksys.twitterapi.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class BadRequestException extends RuntimeException {

    private static final long serialVersionUID = -5369285848471817988L;
    private String message;
}
