package com.ssafy.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.member.model.MemberDto;
import com.ssafy.sample.util.DBUtil;

public class MemberDaoImpl implements MemberDao {

	private static MemberDao memberDao = new MemberDaoImpl();
	private static DBUtil dbUtil;
	private MemberDaoImpl() {
		dbUtil = DBUtil.getInstance();
	}
	public static MemberDao getMemberDao() { 
		return memberDao;
	}
	
//	@Override
//	public int idCheck(String user_id) throws SQLException {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		int cnt = 1;
//		
//		try {
//			conn = dbUtil.getConnection();
//			StringBuilder sql = new StringBuilder("select * from members where user_id = ?");
//			pstmt = conn.prepareStatement(sql.toString());
//			pstmt.setString(1, user_id);
//			rs = pstmt.executeQuery();
//			
//		}
//		return 0;
//	}

	@Override
	public MemberDto loginMember(String user_id, String user_pw) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDto memberDto = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder("select * from members where user_id = ? and user_password = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, user_id);
			pstmt.setString(2, user_pw);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				memberDto = new MemberDto();
				memberDto.setUser_id(rs.getString("user_id"));
				memberDto.setUser_password(rs.getString("user_password"));
				memberDto.setUser_name(rs.getString("user_name"));
				memberDto.setEmail_id(rs.getString("email_id"));
				memberDto.setEmail_domain(rs.getString("email_domain"));
				memberDto.setJoin_date(rs.getString("join_date"));
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return memberDto;
	}

}
