package com.ssafy.test.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.test.member.model.MemberDto;
import com.ssafy.test.util.DBUtil;

public class MemberDaoImpl implements MemberDao{
	
	private static MemberDao memberDao = new MemberDaoImpl();
	private DBUtil dbUtil;
	private MemberDaoImpl() {
		dbUtil = DBUtil.getInstance();
	}
	public static MemberDao getMemberDao() {
		return memberDao;
	}
	
	@Override
	public MemberDto login(String id, String password) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDto memberDto = null;
		
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder("select * from members where id = ? and password = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				memberDto = new MemberDto();
				memberDto.setId(rs.getString("id"));
				memberDto.setPassword(rs.getString("password"));
				memberDto.setName(rs.getString("name"));
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		
		return memberDto;
	}

}
