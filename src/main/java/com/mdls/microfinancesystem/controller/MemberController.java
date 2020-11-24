package com.mdls.microfinancesystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mdls.microfinancesystem.constant.GlobalConstant;
import com.mdls.microfinancesystem.entity.Member;
import com.mdls.microfinancesystem.entity.Staff;
import com.mdls.microfinancesystem.pojo.MemberPojo;
import com.mdls.microfinancesystem.response.BaseResponse;
import com.mdls.microfinancesystem.service.CustomerService;
import com.mdls.microfinancesystem.service.MemberService;

@RestController
@CrossOrigin
public class MemberController {
	@Autowired
	MemberService memberService;
	@Autowired
	CustomerService customerService;

	@GetMapping(value = "/members")
	public BaseResponse getMember(Member member) {
		List<Member> members = memberService.getMember(member);
		return new BaseResponse(GlobalConstant.SUCCESS, members, GlobalConstant.Message.SUCCESS_MESSAGE);
	}

	@PostMapping(value = "/member")
	public BaseResponse addMember(@RequestBody Member member) {
		Member members;
		try {
			List<Member> groupName = memberService.findByGroupName(member.getMemberGroupName());

			if (groupName == null || !groupName.isEmpty() ) {

				return new BaseResponse(GlobalConstant.FAIL, null, "Already exists!");
			}

			members = memberService.save(member);
		} catch (Exception e) {
			System.out.println("Error occur " + e.getMessage());
			return new BaseResponse(1, null, "Error cannot create member");
		}
		return new BaseResponse(0, members, "Successfully created ");
	}

	@DeleteMapping(value = "/members/{id}")
	public BaseResponse deleteById(@PathVariable Long id) {
		try {
			memberService.delete(id);
		} catch (Exception e) {
			System.out.println("Error occur " + e.getMessage());
			return new BaseResponse(1, null, "Error cannot delete member");
		}
		return new BaseResponse(0, null, "Successfully deleted ");
	}

	@PutMapping(value = "/members")
	public BaseResponse updateMember(@RequestBody MemberPojo memberPojo) {
		Member members;
		try {
			Member member = memberService.findById(memberPojo.getId());
			List<Member> groupName = memberService.findByGroupName(member.getMemberGroupName());
			
			member.setMemberGroupName(memberPojo.getMemberGroupName());
			member.setMemberType(memberPojo.getMemberType());
			
			if (member ==null ||groupName == null || !groupName.isEmpty() ) {

				return new BaseResponse(GlobalConstant.FAIL, null, "Already exists!");
			}
			members = memberService.save(member);
			
		} catch (Exception e) {
			System.out.println("Error occur " + e.getMessage());
			return new BaseResponse(GlobalConstant.FAIL, null, "Error cannot update member");
		}
		return new BaseResponse(GlobalConstant.SUCCESS, members , "Successfully updated ");
	}

	@GetMapping(value = "/members/{id}")
	public BaseResponse getById(@PathVariable Long id) {
		Member member;
		try {
			member = memberService.findById(id);
		} catch (Exception e) {
			System.out.println("Error occur " + e.getMessage());
			return new BaseResponse(GlobalConstant.FAIL, null, "Error cannot create customer");
		}
		return new BaseResponse(GlobalConstant.SUCCESS, member, "Successfully created ");
	}

	@GetMapping(value = "/members/search")
	@CrossOrigin
	public List<Member> searchMemberGroup(String memberGroupName) {
		return memberService.searchMemberGroup(memberGroupName);
	}
}
