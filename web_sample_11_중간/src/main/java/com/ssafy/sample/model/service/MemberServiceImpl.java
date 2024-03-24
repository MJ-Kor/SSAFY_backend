package com.ssafy.sample.model.service;

import com.ssafy.sample.model.dao.MemberDaoImpl;
import com.ssafy.sample.model.dto.MemberDto;

public class MemberServiceImpl {
	
	private MemberServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	private static MemberServiceImpl instance= new MemberServiceImpl();
	public static MemberServiceImpl getMemberService() {
		return instance;
	}
	
	MemberDaoImpl memberDao = MemberDaoImpl.getMemberDao();
	
	public MemberDto login(String id, String pw) {
		return memberDao.login(id, pw);
	}

}
