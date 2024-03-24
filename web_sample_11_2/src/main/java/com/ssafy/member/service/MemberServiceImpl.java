package com.ssafy.member.service;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.dao.MemberDao;
import com.ssafy.member.model.dao.MemberDaoImpl;

public class MemberServiceImpl implements MemberService {

	private static MemberService memberService = new MemberServiceImpl();
	private MemberDao memberDao;
	private MemberServiceImpl() {
		memberDao = MemberDaoImpl.getMemberDao();
	}
	public static MemberService getMemberService() {
		return memberService;
	}
	
//	@Override
//	public int idCheck(String user_id) throws Exception {
//		return memberDao.idCheck(user_id);
//	}

	@Override
	public MemberDto loginMember(String user_id, String user_pw) throws Exception {
		return memberDao.loginMember(user_id, user_pw);
	}

}
