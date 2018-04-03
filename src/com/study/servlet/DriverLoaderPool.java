package com.study.servlet;

import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

//ctrl + shift + O 인서트 자동연결
//톰켓이 아니라 commons에 있는것들 연결

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class DriverLoaderPool extends HttpServlet {

	@Override
	public void init() throws ServletException {
		loadJDBCDriver();
		initConnectionPool();
	}

	private void loadJDBCDriver() {
		try {
			// 커넥션 풀에서 사용할 jdbc 드라이버를 로딩
			String driver = "oracle.jdbc.driver.OracleDriver";
			Class.forName(driver);
			System.out.println("드라이버 로드 성공...");
			
		} catch (ClassNotFoundException ex) {
			throw new RuntimeException("fail to load JDBC Driver", ex);
		}
	}

	private void initConnectionPool() {
		try {
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
			String username = "java";
			String pw = "oracle";

			// 커넥션팩토리 생성. 커넥션 팩토리는 새로운 커넥션을 생성할때 사용한다.
			ConnectionFactory connFactory = new DriverManagerConnectionFactory(jdbcUrl, username, pw);

			// DBCP가 커넥션 풀에 커넥션을 보관할때 사용하는 PoolableConnectionFactory 생성
			// 실제로 내부적으로 커넥션을 담고있고 커넥션을 관리하는데 기능을 제공한다. ex)커넥션을 close하면 종료하지 않고 커넥션 풀에 반환
			PoolableConnectionFactory poolableConnFactory = new PoolableConnectionFactory(connFactory, null);
			// 커넥션이 유효한지 확인할때 사용하는 쿼리를 설정한다.
			poolableConnFactory.setValidationQuery("select 1 from dual"); //커넥션은 사용하지 않아도 연결이 되어있기 때문에 문제없이 사용할수 있는지 확인한

			// 커넥션 풀의 설정 정보를 생성한다.
			GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
			// 유휴 커넥션 검사 주기
			poolConfig.setTimeBetweenEvictionRunsMillis(1000L * 60L * 5L); // 5분
			// 풀에 있는 커넥션이 유효한지 검사 유무 설정
			poolConfig.setTestWhileIdle(true); 
			// 커넥션 최소갯수 설정
			poolConfig.setMinIdle(4);
			// 커넥션 최대 갯수 설정
			poolConfig.setMaxTotal(50);

			// 커넥션 풀 생성. 인자로는 위에서 생성한 PoolabeConnectionFactory와 GenericObjectPoolConfig를
			// 사용한다.
			GenericObjectPool<PoolableConnection> connectionPool = new GenericObjectPool<>(poolableConnFactory,
					poolConfig);

			// PoolabeConnectionFactory에도 커넥션 풀을 연결
			poolableConnFactory.setPool(connectionPool);

			// 커넥션 풀을 제공하는 jdbc 드라이버를 등록.
			Class.forName("org.apache.commons.dbcp2.PoolingDriver");

			PoolingDriver driver = (PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");
			// 위에서 커넥션 풀 드라이버에 생성한 커넥션 풀을 등룍한다. 이름은 cp이다.
			driver.registerPool("study", connectionPool); //study는 임의로 변경가능하다 // 차후 DriverManager설정할때 jdbc:apache:commons:dbcp:study 이렇게 입력해주면 됨
			System.out.println("DBCP study 등록 성공...");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
