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
		int cnt = 0;
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
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt, conn);
		}
				
		return cnt;
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
			String sql = "select * from board where article_no = " + articleNo;
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
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
		return boardDto;
	}

	@Override
	public void updateHit(int articleNo) {
		BoardDto boardDto = viewArticle(articleNo);
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnection();
			
			StringBuilder sql = new StringBuilder("update board \n");
			sql.append("set hit = " + "'" + (boardDto.getHit()+1) + "'\n");
			sql.append("where article_no = " + "'" + boardDto.getArticleNo() + "'");
			
			pstmt = conn.prepareStatement(sql.toString());
			int cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt, conn);
		}

	}

	@Override
	public int updateArticle(int articleNo, BoardDto boardDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		System.out.println(boardDto.getContent());
		System.out.println(boardDto.getSubject());
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder("update board \n");
			sql.append("set subject = " + "'" + (boardDto.getSubject()) + "', ");
			sql.append("content = " + "'" + (boardDto.getContent()) + "'\n");
			sql.append("where article_no = " + "'" + articleNo + "'");
			
			pstmt = conn.prepareStatement(sql.toString());
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt, conn);
		}
		
		return cnt;
	}
	

	@Override
	public int deleteArticle(int articleNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder("delete from board \n");
			sql.append("where article_no = " + "'" + articleNo + "'");
			
			pstmt = conn.prepareStatement(sql.toString());
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt, conn);
		}
				
		
		return cnt;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
