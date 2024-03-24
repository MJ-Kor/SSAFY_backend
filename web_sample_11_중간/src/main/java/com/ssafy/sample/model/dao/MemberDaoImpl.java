package com.ssafy.sample.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.sample.model.dto.MemberDto;
import com.ssafy.sample.util.DBUtil;

public class MemberDaoImpl {

	private MemberDaoImpl() {

	}
	private static MemberDaoImpl instance = new MemberDaoImpl();
	public static MemberDaoImpl getMemberDao() {
		return instance;
	}
	
	//로그인
	public MemberDto login(String id, String pw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDto member = new MemberDto();
		try {
			conn= DBUtil.getInstance().getConnection();
			String sql = " select user_id, user_name from members where user_id = ? and user_password = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				member.setUserId(rs.getString("user_id"));
				member.setUserName(rs.getString("user_name"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.getInstance().close(rs, pstmt, conn);
		}
		
		return member;
		
	}

}
