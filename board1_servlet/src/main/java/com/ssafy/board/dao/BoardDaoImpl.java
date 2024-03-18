package com.ssafy.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.board.model.BoardDto;
import com.ssafy.util.DBUtil;

public class BoardDaoImpl implements BoardDao {
	
	private static BoardDao instance = new BoardDaoImpl(); 
	public static BoardDao getInstance() {
		return instance;
	}
	private BoardDaoImpl() {}
		
	@Override
	public int writeArticle(BoardDto boardDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder("insert into `ssafyweb`.`board` (user_id, subject, content) \n");
			sql.append("values (?, ? ,?)");
			pstmt = conn.prepareStatement(sql.toString());
			int i = 0;
			pstmt.setString(++i, boardDto.getUserId());
			pstmt.setString(++i, boardDto.getSubject());
			pstmt.setString(++i, boardDto.getContent());
			
			System.out.println(sql);
			
			int cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt, conn);
		}
				
		return 0;
	}

	@Override
	public List<BoardDto> listArticle() {
		List<BoardDto> list = new ArrayList<>();
				
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from board";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setArticleNo(rs.getInt("article_no"));
				boardDto.setUserId(rs.getString("user_id"));
				boardDto.setSubject(rs.getString("subject"));
				boardDto.setContent(rs.getString("content"));
				boardDto.setHit(rs.getInt("hit"));
				boardDto.setRegisterTime(rs.getString("register_time"));
				list.add(boardDto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return list;
	}

	@Override
	public BoardDto viewArticle(int articleNo) {
		BoardDto boardDto = new BoardDto();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from board where aricle_no = " + articleNo;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			boardDto.setArticleNo(rs.getInt("article_no"));
			boardDto.setUserId(rs.getString("user_id"));
			boardDto.setSubject(rs.getString("subject"));
			boardDto.setContent(rs.getString("content"));
			boardDto.setHit(rs.getInt("hit"));
			boardDto.setRegisterTime(rs.getString("register_time"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return null;
	}

	@Override
	public void updateHit(int articleNo) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
