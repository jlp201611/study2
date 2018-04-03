
package com.study.member.web;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.study.member.model.Member;
import com.study.member.service.MemberServiceImpl;
import com.study.servlet.IController;

public class MemberInsertController implements IController{ // 클래스 이름에서 ctrl+1누르고 add하면 추상매서드 오버라이드 자동완성

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		System.out.println("====Insert====");
		MemberServiceImpl memberService = new MemberServiceImpl();
		String mem_id = request.getParameter("mem_id");
		
		Member member = new Member();
		
		try {
			BeanUtils.populate(member, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
//		member.setMem_id(mem_id);
//		member.setMem_pwd(request.getParameter("mem_pwd"));
//		member.setMem_name(request.getParameter("mem_name"));
//		member.setMem_phone(request.getParameter("mem_phone"));
//		member.setMem_email(request.getParameter("mem_email"));
		System.out.println("member" + member);
		int cnt = memberService.insertMember(member);		
		System.out.println("인서트 cnt : "+cnt);
		String viewPage="";
		if(cnt > 0 ) {
			viewPage = "redirect:/Ex01_member/memberView.do?mem_id="+mem_id;
		}
		return viewPage;
	} //process end

	
	
	
	
}
