package main.java.com.study.jdbc.main.DML.select;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import main.java.com.study.jdbc.util.DBConnection;

public class JdbcSelect2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("작성자 id : ");
		int writerId = sc.nextInt();
		
		Connection connection = DBConnection.getInstance().getConnection();
		String sql = "select * from board_mst where writer_id = ?"; // PreparedStatement에서만 사용가능
		PreparedStatement pstmt;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, writerId);
			//setInt(Index파라미터값, X) : Index파라미터 값을 int 값 X로 지정한다) 
			ResultSet rs = pstmt.executeQuery();
			
			System.out.println("id\t\ttitle\t\tcontent\t\tread_count\t\twriter_id");
			while(rs.next()) {
				System.out.println(rs.getInt(1)
					+ "\t\t" + rs.getString(2) + "\t\t" + rs.getString(3)
					+ "\t\t" + rs.getInt(4) + "\t\t" + rs.getInt(5)
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
