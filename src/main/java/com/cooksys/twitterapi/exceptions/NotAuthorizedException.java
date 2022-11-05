package com.cooksys.twitterapi.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class NotAuthorizedException extends RuntimeException {
public NotAuthorizedException(String string) {
		// TODO Auto-generated constructor stub
	}

private static final long serialVersionUID = -6949650657866748142L;
//private static final long serialVersionUID = 1L;

private String message;
}
