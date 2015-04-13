package com.textplus.proj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.textplus.proj.domain.Member;
import com.textplus.proj.service.MemberService;

@Controller
@RequestMapping("/api")
public class MemberController {

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
	
}
