package main.java.com.study.jdbc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import lombok.RequiredArgsConstructor;
import main.java.com.study.jdbc.entity.User;
import main.java.com.study.jdbc.util.DBConnectionMgr;

// @RequiredArgsConstructor
public class UserDao {	// Dao : Data access Object [데이터에 접근하는 객체]

//	private final DBConnectionMgr pool;
	
//	public UserDao(DBConnectionMgr pool) {
//		this.pool = pool;
//	}; == @RequiredArgsConstructor 
	
	private DBConnectionMgr pool;
	
	public UserDao() {
		pool = DBConnectionMgr.getInstance();
	}
	
	public int insertUser(User user) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		String sql = null;
		int successCount = 0;
		
		try {
			con = pool.getConnection();
			sql = "insert into user_mst values(0, ?)";
			pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, user.getUsername());
			successCount = pstmt.executeUpdate();
	
			rs = pstmt.getGeneratedKeys(); // rs에 autoIncrements로 증가된 id를 가져다 준다.
			if(rs.next()) {
				user.setUser_id(rs.getInt(1));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);// 커넥션을 끊어준다[데이터 낭비 방지]
		}
		
		return successCount;
	}
	
}
