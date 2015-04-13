package com.textplus.proj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.textplus.proj.domain.Member;
import com.textplus.proj.repo.MemberDao;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDao memberdao;

	@Override
	public List<Member> findAll() {
		return memberdao.findAll();
	}

	@Override
	public Member save(Member member) {
		return memberdao.save(member);
	}

}
