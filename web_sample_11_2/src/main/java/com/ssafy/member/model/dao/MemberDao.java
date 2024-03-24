package com.ssafy.member.model.dao;

import java.sql.SQLException;

import com.ssafy.member.model.MemberDto;

public interface MemberDao {
//	int idCheck(String user_id) throws SQLException;
	MemberDto loginMember(String user_id, String user_pw)throws SQLException;
}
