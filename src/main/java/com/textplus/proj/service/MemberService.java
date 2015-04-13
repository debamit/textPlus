package com.textplus.proj.service;

import java.util.List;

import com.textplus.proj.domain.Member;

public interface MemberService {

	public List<Member> findAll();
	
	public Member save(Member member);
}
