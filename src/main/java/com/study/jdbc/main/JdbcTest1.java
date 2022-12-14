package main.java.com.study.jdbc.main;

import java.sql.Connection;

import main.java.com.study.jdbc.util.DBConnection;

public class JdbcTest1 {
	
	public static void main(String[] args) {
		
		Connection connection = DBConnection.getInstance().getConnection();
		Connection connection2 = DBConnection.getInstance().getConnection();
		
		System.out.println(connection);
		System.out.println(connection2);
	}
	
}
