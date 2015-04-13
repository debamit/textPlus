package com.textplus.proj.controller;

public class MemberNotFoundException extends RuntimeException {
	
	public MemberNotFoundException(String id) {
        super(String.format("No member entry found with id: <%s>", id));
    }

}
