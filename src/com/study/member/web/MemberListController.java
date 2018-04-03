package com.study.member.web;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.member.model.Member;
import com.study.member.service.MemberServiceImpl;
import com.study.servlet.IController;

public class MemberListController implements IController{ // 클래스 이름에서 ctrl+1누르고 add하면 추상매서드 오버라이드 자동완성

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		System.out.println("====List====");
		MemberServiceImpl memberService = new MemberServiceImpl();
		List<Member> list = memberService.getmemberList();
		request.setAttribute("list", list);
		String viewPage = "/WEB-INF/view/Ex01_member/memberList.jsp";
		System.out.println("리스트 : " + viewPage);
		return viewPage;
	} //process end

	
	
	
	
}