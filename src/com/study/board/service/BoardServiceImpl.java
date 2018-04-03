package com.study.board.service;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.study.board.dao.BoardDaoJDBC;
import com.study.board.dao.BoardDaoMybatis;
import com.study.board.dao.IBoardDao;
import com.study.board.model.Board;
import com.study.board.model.BoardSearch;

public class BoardServiceImpl {
	
	private IBoardDao boardDao = new BoardDaoMybatis();//new BoardDaoJDBC();
	static final String DRIVE = "jdbc:apache:commons:dbcp:study";
	
	
	//카운트
	public int getBoardCount(BoardSearch boardSearch) {
		Connection conn = null;
		try {
			
			conn = DriverManager.getConnection(DRIVE);
			int cnt = boardDao.getBoardCount(conn, boardSearch);
			return cnt;
		} catch (SQLException e) {
			throw new RuntimeException("게시물 건수 조회 오류", e); // 이걸 쓰지 않으니까 오류나넹
		}finally {
			if(conn != null) try {conn.close();} catch(Exception e) {};
		}		
		
	} //getBoardCount end
	
	
	//게시판 리스트(페이징처리 한거)
	public List<Board> getBoardList(BoardSearch boardSearch) {
		Connection conn = null;
		List<Board> list;
		try {
			
			conn = DriverManager.getConnection(DRIVE);
			list = boardDao.getBoardList(conn, boardSearch);
			
			return list;
		} catch (SQLException e) {
			throw new RuntimeException("회원 리스트조회 오류", e); // 이걸 쓰지 않으니까 오류나넹
		}finally {
			if(conn != null) try {conn.close();} catch(Exception e) {};
		}
	}//getBoardList
	
/*	//게시판 리스트 // 없어도 되는거긴 한데 그냥 남겨둠
	public List<Board> getBoardList() {
		Connection conn = null;
		List<Board> list;
		try {
			
			conn = DriverManager.getConnection(DRIVE);
			list = boardDao.getBoardList(conn);
			
			return list;
		} catch (SQLException e) {
			throw new RuntimeException("회원 리스트조회 오류", e); // 이걸 쓰지 않으니까 오류나넹
		}finally {
			if(conn != null) try {conn.close();} catch(Exception e) {};
		}
	}
	*/
	
	//게시판 상세정보
	public Board getBoard(int bo_no) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DRIVE);
			Board board = boardDao.getBoard(conn, bo_no);
			return board;
		} catch (SQLException e) {
			throw new RuntimeException("게시판 상세조회 오류", e);
		} finally {
			if(conn != null) try {conn.close();}catch(Exception e){};	
		}
		
	}

	//게시판 등록
	public int registBoard(Board board) {
		Connection conn = null;
		int cnt = 0;
		try {
			conn = DriverManager.getConnection(DRIVE);
			cnt = boardDao.insertBoard(conn, board);
		} catch (SQLException e) {
			throw new RuntimeException("등록 오류", e);
		}finally {
			if(conn != null) try {conn.close();}catch(Exception e1){};	
		}
		return cnt;
		
	}
	
	
	//게시판 수정
	public int modifyBoard(Board board) {
		Connection conn = null;
		int cnt = 0;
		
		try {
			conn = DriverManager.getConnection(DRIVE);
			cnt = boardDao.updateBoard(conn, board);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn != null) try {conn.close();}catch(Exception e){};			
		}
		return cnt;
		
	}
}
