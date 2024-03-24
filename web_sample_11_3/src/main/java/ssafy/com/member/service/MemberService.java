package ssafy.com.member.service;

import ssafy.com.member.model.MemberDto;

public interface MemberService {
	MemberDto login(String user_id, String user_password) throws Exception;
}
