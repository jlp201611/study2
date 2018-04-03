package com.study.member.model;

import java.io.Serializable;

public class Member implements Serializable { // 중간에 데이터가 깨지는 경우가 있기 때문에 써주는 것이 좋다
	//외부(네트워크, 분산환경)에서 해당 객체를 제대로 읽으수 있도록해줌
	//우리 시스템 내부에서 쓸대는 굳이 필요없지만 여러 서버를 이용하여 분산하여 사용할경우는 꼭 써줘야 한다
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; //(시리얼라이저블 인터페이스 상속받으면)ctrl + 1 -> 첫번째 add~선택
	private String mem_id; // 낙타식 : memId 
	private String mem_name;
	private String mem_pwd;
	private String mem_phone;
	private String mem_email;
	private int mem_mileage;
	private String reg_date;
	
	
	//디폴트 생성자 ( 컨트롤 스페이스 M 누르면 자동완성 가능)
	public Member() {
	}
	//Ex12폴더에서 생성자를 활용하기 위해 생성자 생성
	public Member(String mem_id, String mem_name, String mem_pwd, String mem_phone, String mem_email, int mem_mileage) {
		super();
		this.mem_id = mem_id;
		this.mem_name = mem_name;
		this.mem_pwd = mem_pwd;
		this.mem_phone = mem_phone;
		this.mem_email = mem_email;
		this.mem_mileage = mem_mileage;
	}
	
	//겟터셋터
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_pwd() {
		return mem_pwd;
	}
	public void setMem_pwd(String mem_pwd) {
		this.mem_pwd = mem_pwd;
	}
	public String getMem_phone() {
		return mem_phone;
	}
	public void setMem_phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}
	public String getMem_email() {
		return mem_email;
	}
	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}
	public int getMem_mileage() {
		return mem_mileage;
	}
	public void setMem_mileage(int mem_mileage) {
		this.mem_mileage = mem_mileage;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
