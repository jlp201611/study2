package com.study.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import org.apache.catalina.security.SecurityConfig;

public class DriverLoader extends HttpServlet{ //extends HttpServlet를 상속해주면서 class가 아닌 서블릿이 된다

	//init(); // 처음에 한번만...??
	//destroy();//요청할때 마다...?? 해제될때 발생?되는 메서드

	@Override
	public void init() throws ServletException {
		
		//doget..? dopost??? 이런것 없데 근데 이게 먼지 몰겠다무슨역활임???ㅋㅋ
		String driver = "oracle.jdbc.driver.OracleDriver";
		try {
			Class.forName(driver);
			System.out.println("오라클 드라이버 로딩 성공~~~");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}

	
}
