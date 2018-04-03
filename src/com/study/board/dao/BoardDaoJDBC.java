package com.study.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.study.board.model.Board;
import com.study.board.model.BoardSearch;

public class BoardDaoJDBC implements IBoardDao {

	
	//페이징 쿼리
	@Override
	public int getBoardCount(Connection conn, BoardSearch boardSearch) throws SQLException { //BoardSearch boardSearch는 검색할때 사용
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer query = new StringBuffer();
		query.append(" SELECT count(*)    "); //집계합수 레코드가 없어도 0반환 값이 꼭나온다ㅎㅎ
		query.append("   FROM tb_board    ");
	
		System.out.println(query);
		try {
			pstmt = conn.prepareStatement(query.toString());
			rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt(1);
		} finally {
			if(rs != null) try {rs.close();}catch(Exception e){};
			if(pstmt != null) try {pstmt.close();}catch(Exception e){};
		}		
		
	}//end
	
	//리스트(페이징)
	@Override
	public List<Board> getBoardList(Connection conn, BoardSearch boardSearch) throws SQLException{
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Board> list = new ArrayList<>();
		
		//쿼리문 작성
		StringBuffer query = new StringBuffer();
		query.append(" SELECT *        ");
		query.append("   FROM ( SELECT rownum rn, a.*       ");
		query.append("            FROM (        ");
		query.append("                   SELECT         ");
		query.append("                          bo_no       ");
		query.append("                         ,bo_title    ");
		query.append("                         ,bo_writer   ");
		query.append("                         ,bo_passwd   ");
		query.append("                         ,bo_email    ");
		query.append("                         ,bo_ip       ");
		query.append("                         ,bo_read_cnt ");
		query.append("                         ,to_char(bo_reg_date, 'YYYY/MM/DD') as bo_reg_date ");
		query.append("                         ,to_char(bo_mod_date, 'YYYY/MM/DD') as bo_mod_date ");
		query.append("                    FROM  TB_BOARD  ");
		query.append("                ORDER BY  bo_no DESC  ");
		query.append("                ) a  ");
		query.append("         ) b  ");
		query.append(" WHERE rn between ? and ?  ");
				
		System.out.println(query);
		try {
			pstmt = conn.prepareStatement(query.toString());
			
			pstmt.setInt(1, boardSearch.getStartRow());
			pstmt.setInt(2, boardSearch.getEndRow());
			System.out.println("시작:끝 : "+boardSearch.getStartRow()+boardSearch.getEndRow());
			rs = pstmt.executeQuery();
			
			Board board = null;
			while (rs.next()) {
				board = new Board();
				board.setBo_no(rs.getInt("bo_no"));
				board.setBo_title(rs.getString("bo_title"));
				board.setBo_writer(rs.getString("bo_writer"));
				board.setBo_passwd(rs.getString("bo_passwd"));
				board.setBo_email(rs.getString("bo_email"));
				board.setBo_ip(rs.getString("bo_ip"));
				board.setBo_read_cnt(rs.getInt("bo_read_cnt"));
				board.setBo_reg_date(rs.getString("bo_reg_date"));
				board.setBo_mod_date(rs.getString("bo_mod_date"));
				
				list.add(board);
			}
			return list;
		} finally {
			if(rs != null) try {rs.close();}catch(Exception e){};
			if(pstmt != null) try {pstmt.close();}catch(Exception e){};
		}
		
	}
	
/*	
	//리스트
	@Override
	public List<Board> getBoardList(Connection conn) throws SQLException{
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Board> list = new ArrayList<>();
		
		//쿼리문 작성
		StringBuffer query = new StringBuffer();

		
		
	//페이징 처리 전에 list
		query.append(" SELECT         ");
		query.append("    bo_no       ");
		query.append("   ,bo_title    ");
		query.append("   ,bo_writer   ");
		query.append("   ,bo_passwd   ");
		query.append("   ,bo_email    ");
		//query.append("   ,bo_content "); //내용이 커서 필요할때만 쓰는게 좋을듯
		query.append("   ,bo_ip       ");
		query.append("   ,bo_read_cnt ");
		query.append("   ,to_char(bo_reg_date, 'YYYY/MM/DD') as bo_reg_date ");
		query.append("   ,to_char(bo_mod_date, 'YYYY/MM/DD') as bo_mod_date ");
		query.append("   ,bo_writer   ");
		query.append(" FROM TB_BOARD  ");
		query.append(" ORDER BY bo_no DESC  ");
		
		System.out.println(query);
		try {
			pstmt = conn.prepareStatement(query.toString());
			rs = pstmt.executeQuery();
			
			Board board = null;
			while (rs.next()) {
				board = new Board();
				board.setBo_no(rs.getInt("bo_no"));
				board.setBo_title(rs.getString("bo_title"));
				board.setBo_writer(rs.getString("bo_writer"));
				board.setBo_passwd(rs.getString("bo_passwd"));
				board.setBo_email(rs.getString("bo_email"));
				//board.setBo_content(rs.getString("bo_content"));
				board.setBo_ip(rs.getString("bo_ip"));
				board.setBo_read_cnt(rs.getInt("bo_read_cnt"));
				board.setBo_reg_date(rs.getString("bo_reg_date"));
				board.setBo_mod_date(rs.getString("bo_mod_date"));
				
				list.add(board);
			}
			return list;
		} finally {
			if(rs != null) try {rs.close();}catch(Exception e){};
			if(pstmt != null) try {pstmt.close();}catch(Exception e){};
		}
		
	}	
*/	
	
	//상세보기
	@Override
	public Board getBoard(Connection conn, int bo_no) throws SQLException{
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer query = new StringBuffer();
		
		query.append(" SELECT             ");
		query.append("       bo_no        ");
		query.append("      ,bo_title     ");
		query.append("      ,bo_writer    ");
		query.append("      ,bo_passwd    ");
		query.append("      ,bo_email     ");
		query.append("      ,bo_content   ");
		query.append("      ,bo_ip        ");
		query.append("      ,bo_read_cnt  ");
		query.append("      ,bo_reg_date  ");
		query.append("      ,bo_mod_date  ");
		query.append("  FROM TB_BOARD     ");
		query.append(" WHERE BO_NO = ?   ");
		
		System.out.println(query);
		
		try {
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setInt(1, bo_no);
			
			rs = pstmt.executeQuery();
			
			Board board = null;
			while (rs.next()) {
				board = new Board();
				board.setBo_no(rs.getInt("bo_no"));
				board.setBo_title(rs.getString("bo_title"));
				board.setBo_writer(rs.getString("bo_writer"));
				board.setBo_passwd(rs.getString("bo_passwd"));
				board.setBo_email(rs.getString("bo_email"));
				board.setBo_content(rs.getString("bo_content"));
				board.setBo_ip(rs.getString("bo_ip"));
				board.setBo_read_cnt(rs.getInt("bo_read_cnt"));
				board.setBo_reg_date(rs.getString("bo_reg_date"));
				board.setBo_mod_date(rs.getString("bo_mod_date"));
			}
			
			return board;
		} finally {
			if(rs != null) try {rs.close();}catch(Exception e){};
			if(pstmt != null) try {pstmt.close();}catch(Exception e){};
		}
		
		
	}
	
	//삽입
	@Override
	public int insertBoard(Connection conn, Board board) throws SQLException{

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer query = new StringBuffer(); 
		
		query.append(" INSERT INTO TB_BOARD ( ");
		query.append("        bo_no      	  ");
		query.append("      , bo_title        ");
		query.append("      , bo_writer       ");
		query.append("      , bo_passwd       ");
		query.append("      , bo_email        ");
		query.append("      , bo_content      ");
		query.append("      , bo_ip           ");
		query.append("      , bo_read_cnt     ");
		query.append("      , bo_reg_date     ");
		query.append("      , bo_mod_date     ");
		query.append(" 		)                 ");
		query.append(" values (               ");
		query.append(" 			seq_board.nextval		  ");
		query.append(" 			,?		  "); //bo_title
		query.append(" 			,?		  "); //bo_writer
		query.append(" 			,?		  "); //bo_passwd
		query.append(" 			,?		  "); //bo_email
		query.append(" 			,?		  "); //bo_content
		query.append(" 			,?		  "); //bo_ip
		query.append(" 			,0		  "); //bo_read_cnt
		query.append(" 			,sysdate  "); //bo_reg_date
		query.append(" 			,sysdate  "); //bo_mod_date
		query.append(" 			)		  ");
		
		System.out.println(query);
		
		int id = 1;
		
		try {
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(id++, board.getBo_title());
			pstmt.setString(id++, board.getBo_writer());
			pstmt.setString(id++, board.getBo_passwd());
			pstmt.setString(id++, board.getBo_email());
			pstmt.setString(id++, board.getBo_content());
			pstmt.setString(id++, board.getBo_ip());

			int cnt = pstmt.executeUpdate();
			return cnt;
		} finally {
			if(pstmt != null) try {pstmt.close();}catch(Exception e){};
		}		
	}
	
	//수정
	@Override
	public int updateBoard(Connection conn, Board board) throws SQLException{
		
		PreparedStatement pstmt = null;
		StringBuffer query = new StringBuffer();
		
		query.append(" update tb_board         ");
		query.append("    set                  ");
		query.append("        bo_title = ?        ");
		query.append("       ,bo_writer = ?         ");
		query.append("       ,bo_content = ?         ");
		query.append("       ,bo_mod_date = sysdate  ");
		query.append("  where bo_no = ?  ");
		
		System.out.println(query);
		
		int id=1;
		
		try {
			
			pstmt=conn.prepareStatement(query.toString());
			pstmt.setString(id++, board.getBo_title());
			pstmt.setString(id++, board.getBo_writer());
			pstmt.setString(id++, board.getBo_content());
			pstmt.setInt(id++, board.getBo_no());
			
			int cnt = pstmt.executeUpdate();
			return cnt;
			
		} finally {
			if(pstmt != null) try {pstmt.close();}catch(Exception e){};			
		}
	}//updateBoard end


}
