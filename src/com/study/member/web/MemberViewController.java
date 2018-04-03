
package com.study.member.web;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.member.model.Member;
import com.study.member.service.MemberServiceImpl;
import com.study.servlet.IController;

public class MemberViewController implements IController{ // 클래스 이름에서 ctrl+1누르고 add하면 추상매서드 오버라이드 자동완성

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		System.out.println("====View====");
		MemberServiceImpl memberService = new MemberServiceImpl();
		String viewPage = "/WEB-INF/view/Ex01_member/memberView.jsp";
		String mem_id = request.getParameter("mem_id");
		if(mem_id == null || mem_id.trim().equals("")) {
			return "redirect:/Ex01_member/memberList.do";
		}
		
		Member member = memberService.getMember(mem_id);
		
		request.setAttribute("member", member);
		
		
		return viewPage;
	} //process end

	
	
	
	
}
