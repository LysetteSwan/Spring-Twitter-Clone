package com.cooksys.twitterapi.exceptions;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class BadRequestException extends RuntimeException {

    public BadRequestException(String string) {
		// TODO Auto-generated constructor stub
	}
	private static final long serialVersionUID = -5369285848471817988L;
    private String message;

}
