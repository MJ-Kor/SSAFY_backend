package com.ssafy.test.member.service;

import com.ssafy.test.member.model.MemberDto;
import com.ssafy.test.member.model.dao.MemberDao;
import com.ssafy.test.member.model.dao.MemberDaoImpl;

public class MemberServiceImpl implements MemberService {

	private static MemberService memberService = new MemberServiceImpl();
	private MemberDao memberDao;
	private MemberServiceImpl() {
		memberDao = MemberDaoImpl.getMemberDao();
	}
	public static MemberService getMemberService() {
		return memberService;
	}
	
	@Override
	public MemberDto login(String id, String password) throws Exception {
		// TODO Auto-generated method stub
		return memberDao.login(id, password);
	}

}
