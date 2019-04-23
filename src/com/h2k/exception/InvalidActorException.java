package com.h2k.exception;

public class InvalidActorException extends Exception{

	public InvalidActorException(String message) {
		super(message);
	}
	
	public InvalidActorException(String message, Throwable th) {
		super(message, th);
	}

}
