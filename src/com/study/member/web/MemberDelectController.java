
package com.study.member.web;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.study.member.model.Member;
import com.study.member.service.MemberServiceImpl;
import com.study.servlet.IController;

public class MemberDelectController implements IController{ // 클래스 이름에서 ctrl+1누르고 add하면 추상매서드 오버라이드 자동완성

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		System.out.println("====Delect====");
		MemberServiceImpl memberService = new MemberServiceImpl();
		String mem_id = request.getParameter("mem_id");
		String mem_pwd = request.getParameter("mem_pwd");

		System.out.println(mem_id+" : "+mem_pwd);
		if(mem_id == null || mem_id.trim().equals("") || mem_pwd == null || mem_pwd.trim().equals("")) {
			return "redirect:/Ex01_member/memberList.do";
		}
		Member member = new Member();
		
		try {
			BeanUtils.populate(member, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(member.getMem_id()+" : " + member.getMem_pwd());
		int cnt = memberService.deleteMember(member);		
		System.out.println("딜리트 cnt : "+cnt);
		String viewPage="";
		if(cnt > 0 ) {
			viewPage = "redirect:/Ex01_member/memberList.do";
		}else {
		}
		return viewPage;
		
		
		
		
	} //process end

	
	
	
	
}
