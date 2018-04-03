package com.study.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestController extends HttpServlet { // 서블릿은 반드시 extends HttpServlet
	// properties파일에 담겨있는 정보 활용

	// url, 해당 컨트롤러 정보를 보관할 맵 생성
	private Map<String, IController> handlerMap = new HashMap<>();

	@Override
	public void init() throws ServletException {
		String configFile = getInitParameter("configFile"); // web.xml파일에서 세팅한 init-param에서 configFile라는 이름의 놈의 값을
															// 가져오는듯.... 아직만들지 않음
		Properties prop = new Properties();
		String configFilePath = getServletContext().getRealPath(configFile); // 물리적인 파일 경로를 전부 꺼내오고 싶어서

		try (FileInputStream fis = new FileInputStream(configFilePath)) {
			prop.load(fis);
		} catch (Exception e) {
			throw new ServletException(e);
		}

		Iterator keyIter = prop.keySet().iterator();
		while (keyIter.hasNext()) {
			String command = (String) keyIter.next();
			String handlerClassName = prop.getProperty(command);

			try {
				Class<?> handlerClass = Class.forName(handlerClassName); // 그냥 문자열일 뿐인 벨류를 클레스로 변환해준
				IController controller = (IController) handlerClass.newInstance(); // 위에 클래스로 만들어진 것을 new로 클래스화
				// 맵에 저장
				handlerMap.put(command, controller);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				System.out.println(command + " 를 로드하지 못했습니다." + e.getMessage());
			}
		}
		System.out.println("====init End====");
	}

	// service(HttpServletRequest있는놈)는 get방식과 post방식 둘다 얻어 올수 있음
	/**
	 * <컨트롤러 구현 순서>
	 * #1 사용자 요청을 받음
	 * #2 사용자 요청분석(URI구별 or 패러미터구별)
	 * #3. 모델을 사용해서 기능수행
	 * #4. 결과를 속성에 저장(request, session)
	 * #5. 알맞은 뷰로 포워드(요청 결과에 해당하는 뷰로 포워드)
	 */

	
	
	
// #1 사용자 요청을 받음
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//모든 컨트롤러들이 받는 페러미터에 적용을 해주기 위해서 메인컨트롤러인 테스트컨틀롤러에서 케릭터셋을 해줌
		request.setCharacterEncoding("utf-8"); //한글이 깨지는 현상
// #2 사용자 요청분석(web.xml에서 컨트롤러 등록하고 do확장자로 맵핑도 했음)
//	  -- 파라미터로 분석 : (ex)member?type=list, /member?type=view
//	  -- 요청 uri로 분석 : /member/list, / membr/view
		
		String uri = request.getRequestURI();
		//요청 uri는 /study/member/memberList.do 가 입력됨
		//요청 uri에서 /study(콘텍스트패스)를 삭제
			System.out.println(uri);
		uri = uri.substring(request.getContextPath().length());
			System.out.println(uri);
		
		
		String viewPage = null;
		IController controller = null;
		
		if(handlerMap.containsKey(uri)) { //study_uri.프로퍼티스의 키값이 존재하는지 확인
			controller = handlerMap.get(uri); // //study_uri.프로퍼티스의 키값의 벨류를 가져옴
			if(controller != null) {
				
// #3. 모델을 사용해서 기능수행 -> 각각의 컨트롤러에서 기능수행
// #4. 결과를 속성에 저장(request, session) -> 각각 컨트롤러 에서 기능수행후 속성에 저장
			viewPage = controller.process(request, response); 
			
// #5. 알맞은 뷰로 포워드(요청 결과에 해당하는 뷰로 포워드)
			
			//viewPage가 null이거나, 리다이렉트는 어떻게 처리하징????ㅋㅋㅋㅋㅋㅋㅋㅋ
			//예시: 회원상세에서 회원ID의 패러미터가 없을경우 처리를 할 필요가 없으니 바로 리다이렉트 -> 각 컨트롤러에서 out객체를 사용해서 직접 출력
			//해당컨트롤러가 직접 출력 하는 경우 (다운로드, 이미지 출력 등)
			//컨트롤러가 페이지URI를 리턴할 필요가 없을경우 (viewPage = null) -> 리다이렉트
				if(viewPage != null) {
						if(viewPage.startsWith("redirect:")) {
							System.out.println(uri + ", viewPage" + viewPage);
							//response.sendRedirect(request.getContextPath() + viewPage.replace("redirect:", "")); // 클라이언트는 루트를 타고온다...??? webContent의 직접적인 주소가 아니라 최상위인 루트 경로 /study로 들어오기 대문에 컨텍스트패슥를 사용해서 경로를 설정해준다...?????
							response.sendRedirect(request.getContextPath() + viewPage.substring(9)); // 클라이언트는 루트를 타고온다...??? webContent의 직접적인 주소가 아니라 최상위인 루트 경로 /study로 들어오기 대문에 컨텍스트패슥를 사용해서 경로를 설정해준다...?????
							System.out.println(uri + ", viewPage" + viewPage);
						}else {
							//알맞은 뷰로 포워드(요청 결과에 해당하는 뷰로 포워드)
							RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
							dispatcher.forward(request, response);			
						}
				}
			
			}else {
				//컨트롤러가 널인경우
				throw new ServletException(uri + " 의 컨트롤러가 null입니다.");
			}
		}else {
			//요청 uri가 없으면 404예외 던짐
			//잘못된거...? //response.setStatus(response.SC_NOT_FOUND), "누구심???"); <- 이렇게 쓰면 에러난데ㅋㅋㅋㅋ
			//잘못된거...? //response.setStatus(response.SC_NOT_FOUND); //, "누구심???"); //response.SC_NOT_FOUND == 404 // 리스폰스에서 제공해주는 상수인가봄ㅎㅎㅎ
			response.sendError(response.SC_NOT_FOUND);
		}
		
				// 프로퍼티스 파일을 만들어서 필요 없어진 놈들
				//		if(uri.equals("/Ex01_member/memberList.do")) {
				//			controller = new MemberListController();
				//		} else if(uri.equals("/Ex01_member/memberView.do")) {
				//			controller = new MemberViewController();
				//		} else if(uri.equals("/Ex01_member/memberEdit.do")) {
				//			controller = new MemberEditController();
				//		} else if(uri.equals("/Ex01_member/memberUpdate.do")) {
				//			controller = new MemberEditController();
				//		} else {
				//			throw new ServletException("지금은 memberList만....");
				//		}
		
				//viewPage = controller.process(request, response); //익셉션발생 //IController에서 익셉션 잡아주었다ㅎㅎㅎ
	}
	
}
