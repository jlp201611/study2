package com.study.util;

public class MysumDebug {
	
	//#1. 단순하게 브레이크
		
	
	
	//#2. 조건에 맞는 브레이크
	
	
	public int sum(int start, int last) {
		int tot = 0;
		for(int i = start; i <= last; i++) {
			tot += i;
		}
		return tot;
	}

	public static void main(String[] args) {
		
		MysumDebug my = new MysumDebug();
		int ret = my.sum(10, 20);
		System.out.println("결과 = " + ret);
		
	}
}
