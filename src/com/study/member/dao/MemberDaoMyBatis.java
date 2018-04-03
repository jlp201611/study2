package com.study.member.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.study.member.model.Member;
import com.study.member.model.MemberSearch;
import com.study.util.MyBatisFactory;

public class MemberDaoMyBatis implements IMemberDao{

	
	private String namespace = "com.study.board.dao.IBoardDao.";
	
	
	@Override
	public List<Member> getMemberList(Connection conn) throws SQLException {
		SqlSession session = MyBatisFactory.getSqlSession().openSession();
		try {
			//Dao 구현체를 생성하지 않고, 서비스 단에서 바로 MyVatis 객체를 이용
				IMemberDao memberDao = session.getMapper(IMemberDao.class);//Mapper이 다오 인터페이스라고 생각을 하라는뎁...?ㅋㅋ
				List<Member> list = memberDao.getMemberList(conn);
			
			//List<Member> list = session.selectList(namespace+"getMemberList");
			return list;
		} finally {
			session.close();
		}
	}

	@Override
	public Member getMember(Connection conn, String mem_id) throws SQLException {
		SqlSession session = MyBatisFactory.getSqlSession().openSession();
		
		try {
			Member member = session.selectOne(namespace+"getMember", mem_id);
			return member;
		} finally {
			session.close();
		}
	}

	@Override
	public int insertMember(Connection conn, Member member) throws SQLException {
		SqlSession session = MyBatisFactory.getSqlSession().openSession();
		
		try {
			//exqutUpdate를 session.update나inster, delect등으로 나눠놓았을뿐 그냥 업데이트만 써도 된다
			//셀렉트는 exquteQuery니까 구분해줌
			int cnt = session.update(namespace+"insertMember", member);
			session.commit();
			return cnt;
		} finally {
			session.close();
		}
	}

	@Override
	public int updateMember(Connection conn, Member member) throws SQLException {
		SqlSession session = MyBatisFactory.getSqlSession().openSession();
		
		try {
			//exqutUpdate를 session.update나inster, delect등으로 나눠놓았을뿐 그냥 업데이트만 써도 된다
			//셀렉트는 exquteQuery니까 구분해줌
			int cnt = session.update(namespace+"updateMember", member);
			session.commit();
			return cnt;
		} finally {
			session.close();
		}
	}

	@Override
	public int delectMember(Connection conn, Member member) throws SQLException {
		SqlSession session = MyBatisFactory.getSqlSession().openSession();
		
		try {
			int cnt = session.delete(namespace+"delectMember", member);
			session.commit();
			return cnt;
		} finally {
			session.close();
		}
	}


}
