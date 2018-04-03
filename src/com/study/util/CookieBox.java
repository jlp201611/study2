package com.study.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


/**
 *  도큐먼트 주석을 달면 나중에 내가 만든 클래스 사용할때 주석문으로 나온다 html태그 사용가능
 */
/**
 * 쿠키를 처리하기 위한 클래스
 * 
 * @author pc16
 * @since 2018.03.14
 * 
 * --------------------------------
 * 작성자	일자		변경내역
 * --------------------------------
 * pc16		03.14	최초작성
 * pc16		03.14	오타수정ㅋㅋㅋㅋㅋ
 * 
 */

public class CookieBox {

	private Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
	
	//생성자...
	public CookieBox(HttpServletRequest request) { //HttpServletRequest 사용자 별로 쿠키를 생산하기 때문에 ....??
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(int i = 0; i < cookies.length; i++) {
				cookieMap.put(cookies[i].getName(), cookies[i]);
			}
		}
	} // 생성자 end
	
	
	/**
	 * name에 해당하는 쿠키를 리턴
	 * @param name
	 * @return Cookie
	 */
	public Cookie getCookie(String name) {
		return cookieMap.get(name);
	}
	
	/**
	 * 
	 * name에 해당하는 <Strong>값을 리턴</Strong><br>
	 * 만약 쿠키가 존재하지 않으면 null 리
	 * @param name
	 * @return String
	 * @throws IOException
	 */
	public String getValue(String name) throws IOException {
		Cookie cookie = cookieMap.get(name);
		if(cookie == null) {
			return null;
		}
		return URLDecoder.decode(cookie.getValue(), "utf-8");
	}
	
	public boolean exists(String name) {
		return cookieMap.get(name) != null;
	}
	
	
	/**
	 * 쿠키를 생성
	 * @param name
	 * @param value
	 * @return
	 * @throws IOException
	 */
	//createCookie는 static으로 한 이유는 그냥 쿠키만 생성하기 때문에 메모리 절약되고 객체 생성없이 바로 접근가능하기 때문
	public static Cookie createCookie(String name, String value) throws IOException {
		return new Cookie(name, URLEncoder.encode(value,"utf-8"));
	}
	
	public static Cookie createCookie(String name, String value, String path, int maxAge) throws IOException {
		Cookie cookie = new Cookie(name,URLEncoder.encode(value,"utf-8"));
		cookie.setPath(path);
		cookie.setMaxAge(maxAge);
		
		return cookie;
	}
	
	public static Cookie createCookie(String name, String value, String path, int maxAge, String domain) throws IOException {
		Cookie cookie = new Cookie(name,URLEncoder.encode(value,"utf-8"));
		cookie.setDomain(domain);
		cookie.setPath(path);
		cookie.setMaxAge(maxAge);
		return cookie;
	}	
	
}
