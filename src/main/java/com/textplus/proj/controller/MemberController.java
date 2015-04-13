package com.textplus.proj.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.javaadvent.bootrest.todo.TodoController;
import com.javaadvent.bootrest.todo.TodoNotFoundException;
import com.textplus.proj.domain.Member;
import com.textplus.proj.service.MemberService;

@Controller
@RequestMapping("/api")
public class MemberController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;
	

	@RequestMapping(value="/members",method = RequestMethod.GET)
	public @ResponseBody List<Member> getAllMembers(){		
		List<Member> members = memberService.findAll();	
		 return members;
	}
	
	@RequestMapping(value="/members/create",method = RequestMethod.POST)
	public @ResponseBody Member createMember(@RequestBody Member member){		
		Member newMember = memberService.save(member);	
		 return newMember;
	}
	
	@ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleTodoNotFound(TodoNotFoundException ex) {
        LOGGER.error("Handling error with message: {}", ex.getMessage());
    }
	
}
