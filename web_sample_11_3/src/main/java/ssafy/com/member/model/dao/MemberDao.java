package ssafy.com.member.model.dao;

import java.sql.SQLException;

import ssafy.com.member.model.MemberDto;

public interface MemberDao {
	MemberDto login(String user_id, String user_password) throws SQLException;
}
