package com.ssafy.test.member.model.dao;

import java.sql.SQLException;

import com.ssafy.test.member.model.MemberDto;

public interface MemberDao {
	MemberDto login(String id, String password) throws SQLException;
}
