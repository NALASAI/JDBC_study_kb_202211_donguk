package main.java.com.study.jdbc.main.DML.select;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.com.study.jdbc.util.DBConnection;

public class JdbcSelect1 {
	
	public static void main(String[] args) {
		
		Connection connection = DBConnection.getInstance().getConnection();
		// DB 연결에 대한 객체를 생성하고(처음에만 생성), 연결하는 객체생성 
		
//		System.out.println(connection);
		String sql = "select * from score_mst"; // 쿼리문 작성

		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			// 쿼리문을 작성하고, SQL문을 실행시키는 역할
			ResultSet rs = pstmt.executeQuery();
			// executeQuery()로 쿼리문을 실행하고, 실행한 값을 역할을 ResultSet객체로 받는다.
			// ResultSet에 저장된 데이터는 한번만 사용 가능하다.(사용하고난 뒤 다시 받아야한다) 
			
			System.out.println("id\t\tname\t\tscore");
			
			while(rs.next()) {	// rs.next()가 거짓이 될때까지 반복[ rs 의 데이터가 없을때까지 반복]
				System.out.println("id : " + rs.getInt(1) // .getInt(X), .getString(X) : X는 데이터 베이스의 열 이며 1부터 시작한다.
				+ "\t name : " + rs.getString(2)		// 데이터 베이스의 한 행이 전부 출력되면 다음행으로 넘어가 다시 출력한다.
				+ "\t score : " + rs.getInt(3));
			}
		} catch (SQLException e) {	// SQL문이 잘못작성되었거나 없을때 발생
			e.printStackTrace();
		}
	}
}
