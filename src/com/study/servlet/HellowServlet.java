package com.study.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;
//애노테이션을 사용해서 서블릿을 맵핑할때는 패키지는 한군데서 관리해줘야 한다 (중구난방이면 찾으러 다니기 바쁘데)

@WebServlet(urlPatterns= {"/admin/*","*.nhn"})//admin폴더의 모든 파일 or 확장자가 nhn인 파일 전부 이 서블릿 사용 // urlPatterns가 배열이라서 여러개 조건을 줄수 있다 단 or조건
public class HellowServlet extends HttpServlet{

	@Override
	public void init() throws ServletException {
	// 최초에 메모리에 올라올때 1번실행(인스턴스 될때 1번 호출)
		super.init();
	}
	
	@Override
	public void destroy() {
	//메모리가에서 해제될때(WAS가 종료될때)
		super.destroy();
	}
	
	//서비스에서 제공하는?? doGet과 doPost를 많이 씀
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 사용자의 요청이 Get 방식인 경우 호출
		resp.setContentType("text/html; charset=utf-8"); //PrintWriter보다 위에 지정을 해주어야 함
		//resp.setCharacterEncoding("utf-8"); //이건 왜 안대지?ㅋㅋㅋ
		PrintWriter out = resp.getWriter();
		
		out.println("<html lang=\"ko\">");
		out.println("<head>");
		out.println("<title>Hello</title>");
		out.println("</head>");
		out.println("<body>");
		String msg = "Hello 민경 사이트에 오신결 환영합니다.";
		out.println("<h3>"+msg+"</h3>");
		out.println("</body>");
		out.println("</html>");
		
	}
	
}
