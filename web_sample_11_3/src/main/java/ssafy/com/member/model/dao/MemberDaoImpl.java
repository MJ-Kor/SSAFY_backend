package ssafy.com.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.sample.util.DBUtil;

import ssafy.com.member.model.MemberDto;

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
	public MemberDto login(String user_id, String user_password) throws SQLException {
		MemberDto memberDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder("select * from members where user_id = ? and user_password = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, user_id);
			pstmt.setString(2, user_password);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				memberDto = new MemberDto();
				memberDto.setUser_name(rs.getString("user_name"));
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return memberDto;
	}

}
