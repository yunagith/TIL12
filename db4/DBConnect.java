package db4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


// DB ���� ��� Ŭ���� 
public class DBConnect {

		// �����ͺ��̽� �����ϰ� Connection ��ü ��ȯ �޼ҵ�
	   // ȣ���ϴµ��� ��ü �������� �ٷ� �޼ҵ� ȣ���ؼ� ����� �� �ֵ���
	   // static �޼ҵ�� ����
	public static Connection getConnection() {
	
		Connection con = null;
		
		try {
			// JDBC Driver Ŭ������ ��ü ���� ��Ÿ�� �� �ε�
			//Class.forName("com.mysql.cj.jdbc.Driver");
			
			// ���� url, ����� ����, �н����� ���ڿ��� ����
			String url ="jdbc:mysql://localhost:3306/sqldb3?serverTimezone-UTC";
			String user = "root";
			String pwd = "1234";
						
			// DB �����ϱ� ���� ��ü
			// DriverManager�� ���� Connection ��ü ����
			// MySQL ���� ���� : url, ����� ����, �н����� ����
			con = DriverManager.getConnection(url, user, pwd);
			
			// Connection ��ü �����Ǹ� DB ���� ����
			if(con != null) {
				System.out.println("DB ���� ����");
			}
			
		} catch (Exception e) {
			System.out.println("���� �߻�");
			e.printStackTrace();
		}
		
		return con;
	}
	
	// ����� ���ҽ� �ݳ��ϴ� close() �޼ҵ� ����
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
	
	// �޼ҵ� �����ε�
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

















