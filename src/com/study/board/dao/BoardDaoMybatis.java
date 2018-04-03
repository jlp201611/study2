package com.study.board.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.study.board.model.Board;
import com.study.board.model.BoardSearch;
import com.study.util.MyBatisFactory;

public class BoardDaoMybatis implements IBoardDao {

	private String namespace = "com.study.board.dao.IBoardDao.";
	
	//페이징 쿼리
	@Override
	public int getBoardCount(Connection conn, BoardSearch boardSearch) throws SQLException {
		SqlSession session = MyBatisFactory.getSqlSession().openSession();
		try {
			int cnt = session.selectOne(namespace+"getBoardCount", boardSearch);
			return cnt;
		} finally {
			session.close();//커밋
		}
	}
	
	//리스트(페이징)
	@Override
	public List<Board> getBoardList(Connection conn, BoardSearch boardSearch) throws SQLException {
		SqlSession session = MyBatisFactory.getSqlSession().openSession();
		try {
			List<Board> list = session.selectList(namespace+"getBoardList", boardSearch);//selectOne와 헷갈리지 말기ㅋㅋㅋ
			return list;
		} finally {
			session.close();//커밋
		}
	}

	//상세보기
	@Override
	public Board getBoard(Connection conn, int bo_no) throws SQLException {
		SqlSession session = MyBatisFactory.getSqlSession().openSession();
		try {
			Board board = session.selectOne(namespace+"getBoard", bo_no);//
			return board;
		} finally {
			session.close();//커밋
		}
	}
	//등록
	@Override
	public int insertBoard(Connection conn, Board board) throws SQLException {
		SqlSession session = MyBatisFactory.getSqlSession().openSession();
		try {
			int cnt = session.insert(namespace+"insertBoard", board);
			return cnt;
		} finally {
			session.close();//커밋
		}
	}
	//수정
	@Override
	public int updateBoard(Connection conn, Board board) throws SQLException {
		SqlSession session = MyBatisFactory.getSqlSession().openSession();
		try {
			int cnt = session.update(namespace+"updateBoard", board);
			return cnt;
		} finally {
			session.close();//커밋
		}
	}
	
	

}
