package com.study.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IController {
	
	//추상메서드
	public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException;  // 리턴값이 String인 이유는 view의 URI를 넘겨줄꺼기 때문
		
	

}
