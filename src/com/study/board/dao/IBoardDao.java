package com.study.board.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.study.board.model.Board;
import com.study.board.model.BoardSearch;

public interface IBoardDao {

	//페이징 쿼리
	int getBoardCount(Connection conn, BoardSearch boardSearch) throws SQLException;//end

	//리스트(페이징)
	List<Board> getBoardList(Connection conn, BoardSearch boardSearch) throws SQLException;

	//상세보기
	Board getBoard(Connection conn, int bo_no) throws SQLException;

	//삽입
	int insertBoard(Connection conn, Board board) throws SQLException;

	//수정
	int updateBoard(Connection conn, Board board) throws SQLException;//updateBoard end

}