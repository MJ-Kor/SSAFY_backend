package com.ssafy.member.model.dao;

import java.sql.SQLException;

import com.ssafy.member.model.MemberDto;
import com.ssafy.sample.util.DBUtil;

public class MemberDaoImpl implements MemberDao {
	
	private static MemberDao memberDao = new MemberDaoImpl();
	private DBUtil dbUtil;
	
	private MemberDaoImpl() {
		dbUtil = DBUtil.getInstance();
	}
	
	public static MemberDao getMemberDao() {
		return memberDao;
	}

	@Override
	public int idCheck(String userId) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberDto loginMember(String userId, String userPwd) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
