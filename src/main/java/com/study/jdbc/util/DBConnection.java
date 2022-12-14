package main.java.com.study.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DBConnection {

	private static DBConnection instance = null;
	
	private DBConnection() {}
	
	public static DBConnection getInstance() {
		if(instance == null) {
			instance = new DBConnection();
		}
		return instance;
	}
	
	public Connection getConnection() {
		Connection connection = null;
		String url;
		String username;
		String password;
		
		try {
			Class.forName(Driver.class.getName()); // Driver.class.getName()의 위치를 넘겨준다. -> [com.mysql.cj.jdbc.Driver ]
			System.out.println("데이터베이스 드라이브 로딩 성공");
			url = "jdbc:mysql://localhost:3306/subquery_study";	// url 은 데이터베이스의 주소를 입력하면 된다
			username = "root";
			password = "root";
			
			connection = DriverManager.getConnection(url, username, password); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("데이터베이스 연결 실패");
		}
		
		return connection;
	}
	
}