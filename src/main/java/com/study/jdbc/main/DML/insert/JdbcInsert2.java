package main.java.com.study.jdbc.main.DML.insert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.java.com.study.jdbc.util.DBConnection;

public class JdbcInsert2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> usernameList = new ArrayList<>();
		
		while(true) {
			System.out.print("등록할 아이디 입력 : ");
			usernameList.add(sc.nextLine());
			System.out.print("아이디를 추가로 등록하시겠습니까? ( Y / y,\n취소하시려면 아무키나 입력하세요 ) : ");
//			if(!"yY".contains(sc.nextLine().substring(0, 1))) {
//				// !"문자열".contains(sc.nextLine().subString(0, 1)) : 입력된 문자열에서
//				// 0번인덱스를 골라 해당 인덱스에 "문자열"이 포함되지 않았을때, 해당 반복문을 종료한다  
//				break;
//			}
			String selected = sc.nextLine();
			if(!"yY".contains(selected.isBlank() ? "n" : selected)) {
				break;
			}// 입력된 문자열이 비어있으면 n을 반환하고 비어있지 안흐면 입력된 selected를 반환한다.
		}
		
		Connection con = DBConnection.getInstance().getConnection();
		String prefixSql = "insert into user_mst values";
		String valuesBody = "";
		String suffixSql = ";";

		for(int i = 0; i < usernameList.size(); i++) {
			valuesBody += "(0, ?)";
			if(i < usernameList.size() - 1) {
				valuesBody += ", ";
			}
		}
		
		try {
			PreparedStatement pstmt = con.prepareStatement(prefixSql + valuesBody + suffixSql);
			for(int i = 0 ; i < usernameList.size(); i++) {
				pstmt.setString(i+1, usernameList.get(i));
			}
			int successCount = pstmt.executeUpdate();
			
			System.out.println(successCount + "건 등록 완료");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}