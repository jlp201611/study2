
package com.study.member.web;


import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.study.member.model.Member;
import com.study.member.service.MemberServiceImpl;
import com.study.servlet.IController;

public class MemberUpdateController implements IController{ // 클래스 이름에서 ctrl+1누르고 add하면 추상매서드 오버라이드 자동완성

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		System.out.println("====Update====");
		MemberServiceImpl memberService = new MemberServiceImpl();
		String mem_id = request.getParameter("mem_id");
		if(mem_id == null || mem_id.trim().equals("")) {
			return "redirect:/Ex01_member/memberList.do";
		}
		String mem_pwd = request.getParameter("mem_pwd");
		
		Member member = new Member();
// BeanUtils와 같음		
		try {
			BeanUtils.populate(member, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		member.setMem_name(request.getParameter("mem_name"));
//		member.setMem_phone(request.getParameter("mem_phone"));
//		member.setMem_email(request.getParameter("mem_email"));
//		member.setMem_id(mem_id);
		
		int cnt = memberService.updateMember(member);		
		System.out.println("업데이트 cnt : "+cnt);
		String viewPage="";
		if(cnt > 0 ) {
			viewPage = "redirect:/Ex01_member/memberView.do?mem_id="+mem_id;
		}else {
			viewPage = "redirect:/Ex01_member/memberList.do";
		}
		return viewPage;
	} //process end

	
	
	
	
}
