package com.ssafy.test.member.service;

import com.ssafy.test.member.model.MemberDto;

public interface MemberService {
	MemberDto login(String id, String password) throws Exception;
}
