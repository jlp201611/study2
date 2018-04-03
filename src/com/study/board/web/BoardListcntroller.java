package com.study.board.web;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.study.board.model.Board;
import com.study.board.model.BoardSearch;
import com.study.board.service.BoardServiceImpl;
import com.study.servlet.IController;

public class BoardListcntroller implements IController {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		System.out.println("====List====");
		
		BoardSearch boardSearch = new BoardSearch();
		try {
			//BeanUtils 활용
			BeanUtils.populate(boardSearch, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
//		String currentPage = request.getParameter("currentPage");
//		System.out.println(currentPage);		
//		if(currentPage != null && !currentPage.trim().equals("")) {
//			boardSearch.setCurrentPage(Integer.parseInt(currentPage));
//		}
		
		BoardServiceImpl boardService = new BoardServiceImpl();
		boardSearch.setting(boardService.getBoardCount(boardSearch));
		
		List<Board> list = boardService.getBoardList(boardSearch);
		request.setAttribute("boardList", list);
		request.setAttribute("search", boardSearch);
		
		String viewPage =  "/WEB-INF/view/Ex02_board/boardList.jsp";
		System.out.println(viewPage);
		return viewPage;
	}

}
	
	