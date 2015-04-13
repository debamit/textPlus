package com.textplus.proj.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.textplus.proj.domain.Member;

public interface MemberDao extends CrudRepository<Member, Long>{

	public List<Member> findAll();
	
	@SuppressWarnings("unchecked")
	public Member save(Member member);
}
