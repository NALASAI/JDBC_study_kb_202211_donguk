package main.java.com.study.jdbc.main.DML.update;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import main.java.com.study.jdbc.util.DBConnection;

public class JdbcUpdate {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("수정할 계정의 id값을 입력하세요 : ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.print("수정할 아이디를 입력하세요 : ");
		String username = sc.nextLine();
		
		Connection con = DBConnection.getInstance().getConnection();
		String sql = "update user_mst set username = ? where id = ?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);//입력받은 username을 1번물음표에 삽입
			pstmt.setInt(2, id);//입력받은 id를 2번물음표에 삽입
			int successCount = pstmt.executeUpdate();
			System.out.println(successCount + "건 수정완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
