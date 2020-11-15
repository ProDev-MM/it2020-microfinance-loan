package com.mdls.microfinancesystem.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mdls.microfinancesystem.entity.Member;
import com.mdls.microfinancesystem.repository.CustomerRepository;
import com.mdls.microfinancesystem.repository.MemberRepository;

@Service
public class MemberService {
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	CustomerRepository customerRepository;

	public List<Member> getMember(Member member) {
		return memberRepository.findAll();
	}

	public Member save(Member member) {
		return memberRepository.save(member);
	}

	public void delete(Long id) {
		memberRepository.deleteById(id);

	}

	public Member findById(Long id) {
		// TODO Auto-generated method stub
		return memberRepository.findById(id).orElse(null);
	}

	public List<Member> saveAll(Collection<Member> members) {
		return memberRepository.saveAll(members);
	}

	public List<Member> searchMemberGroup(String memberGroupName) {
		// TODO Auto-generated method stub
		return memberRepository.searchMemberGroup(memberGroupName);
	}
	
	public List<Member> findByGroupName(String memberGroupName){
		return memberRepository.findByGroupName(memberGroupName);
	}

}
