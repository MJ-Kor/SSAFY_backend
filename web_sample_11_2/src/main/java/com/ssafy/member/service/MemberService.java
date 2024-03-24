package com.ssafy.member.service;


import com.ssafy.member.model.MemberDto;

public interface MemberService {
//	int idCheck(String user_id) throws Exception;
	MemberDto loginMember(String user_id, String user_pw)throws Exception;
}
