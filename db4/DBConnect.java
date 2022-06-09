package db4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


// DB 연결 담당 클래스 
public class DBConnect {

		// 데이터베이스 연결하고 Connection 객체 반환 메소드
	   // 호출하는데서 객체 생성하지 바로 메소드 호출해서 사용할 수 있도록
	   // static 메소드로 정의
	public static Connection getConnection() {
	
		Connection con = null;
		
		try {
			// JDBC Driver 클래스의 객체 생성 런타임 시 로드
			//Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 연결 url, 사용자 계정, 패스워드 문자열로 지정
			String url ="jdbc:mysql://localhost:3306/sqldb3?serverTimezone-UTC";
			String user = "root";
			String pwd = "1234";
						
			// DB 연결하기 위한 객체
			// DriverManager를 통해 Connection 객체 생성
			// MySQL 서버 연결 : url, 사용자 계정, 패스워드 전송
			con = DriverManager.getConnection(url, user, pwd);
			
			// Connection 객체 생성되면 DB 연결 성공
			if(con != null) {
				System.out.println("DB 연결 성공");
			}
			
		} catch (Exception e) {
			System.out.println("오류 발생");
			e.printStackTrace();
		}
		
		return con;
	}
	
	// 사용한 리소스 반납하는 close() 메소드 생성
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		
		try {
			if(rs != null) rs.close(); rs = null;
			if(pstmt != null) pstmt.close(); pstmt = null;
			if(con != null) con.close(); con = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 메소드 오버로딩
public static void close(Connection con, PreparedStatement pstmt) {
		
		try {			
			if(pstmt != null) pstmt.close(); pstmt = null;
			if(con != null) con.close(); con = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}

















