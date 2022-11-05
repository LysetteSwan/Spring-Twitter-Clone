package com.cooksys.twitterapi.exceptions;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class NotFoundException extends RuntimeException {

    public NotFoundException(String string) {
		// TODO Auto-generated constructor stub
	}
	private static final long serialVersionUID = -496665527642614264L;
    private String message;
}
