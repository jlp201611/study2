package com.study.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisFactory {
	
	public static SqlSessionFactory getSqlSession() {
		String resource = "resource/mybatis-config.xml";		
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource); // Resources는 .자바파일의 위치가 아니라 .class가 있는 web-inf에 classs폴더에 있는 위치로 빌드 시켜
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			return sqlSessionFactory;
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("MyBatis 오류", e);
		}
			
	}
	
}