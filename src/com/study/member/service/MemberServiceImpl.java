package com.study.member.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.study.board.model.BoardSearch;
import com.study.member.dao.IMemberDao;
import com.study.member.dao.MemberDaoJDBC;
import com.study.member.dao.MemberDaoMyBatis;
import com.study.member.model.Member;

public class MemberServiceImpl {
	
	private IMemberDao memberDao = new MemberDaoMyBatis();//new MemberDaoJDBC();
	static final String DRIVE = "jdbc:apache:commons:dbcp:study";
		

	// 회원 리스트
	public List<Member> getmemberList() {
		Connection conn = null; //맵버필드로 빼면 클로즈 할때 문제 될지도 몰라서 살짝 애매하다
		List<Member> list;
		try {
			conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:study");// 커넥션을 메서드 실행할때 해주는것이 좋다...(코딩적으로는 좋지 않다 다오에 커넥션을 넣어줘야 하기 때문에)
			//SQLException을 계속 써야 되니까 개발자들이 트라이 캐치로 계속 잡아야 되서 귀찮다고 한다.... 그래서 그냥 런터임으로 익셉션을 던지는 경우가 많다고 한다...ㅋㅋㅋㅋ 
			list = memberDao.getMemberList(conn);
			
			return list;
		} catch (SQLException e) {		
			throw new RuntimeException("회원 리스트조회 오류", e); // 여기서 멈추는건 아니라네ㅎㅎㅎ 왜그런지는 몰겠당ㅋㅋㅋ 
		}finally {
			if(conn != null) try {conn.close();}catch(Exception e){};			
		}
		
	}//getmemberList 종료
	
	//회원 상세정보
	public Member getMember(String mem_id) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DRIVE);

			Member member = memberDao.getMember(conn, mem_id);
			
			return member;
		} catch (SQLException e) {		
			throw new RuntimeException("회원 상세조회 오류", e); // 여기서 멈추는건 아니라네ㅎㅎㅎ 왜그런지는 몰겠당ㅋㅋㅋ 
		}finally {
			if(conn != null) try {conn.close();}catch(Exception e){};			
		}		
		
	} //getMember end

	// 회원등록
	public int insertMember(Member member) { //왜 int를 리턴타입으로 

		Connection conn = null;
		int cnt=0;
		try {
			conn = DriverManager.getConnection(DRIVE);
			cnt = memberDao.insertMember(conn, member);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn != null) try {conn.close();}catch(Exception e){};			
		}
		return cnt;
		 
	}//등록 end
	
	// 회원수정
		//public int registMember(Member member) { // 쌤은 회원가입 registMember라고 함
		public int updateMember(Member member) {
		Connection conn = null;
		int cnt = 0;
		try {
			
			conn = DriverManager.getConnection(DRIVE);
			cnt = memberDao.updateMember(conn, member);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn != null) try {conn.close();}catch(Exception e){};			
		}
		return cnt;
		
	}
		
	//회원삭제
		public int deleteMember(Member member) {
			Connection conn = null;
			int cnt = 0;
			try {
				conn = DriverManager.getConnection(DRIVE);
				cnt = memberDao.delectMember(conn, member);
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				if(conn != null) try {conn.close();}catch(Exception e){};			
			}
			return cnt;
		}
	

}
