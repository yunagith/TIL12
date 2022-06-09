package db5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class StudentDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public StudentDAO() {
				// DB ���� ���	
				
				try {
					// JDBC Driver Ŭ������ ��ü ���� ��Ÿ�� �� �ε�
					
					// Class.forName("com.mysql.cj.jdbc.Driver");
					
					// ���� url, ����� ����, �н����� ���ڿ��� ����
					String url = "jdbc:mysql://localhost:3306/sqldb3?serverTimezone-UTC";
					String user = "root";
					String pwd = "1234";
					
					// DB �����ϱ� ���� ��ü
					// DriverManager �� ���� Connection ��ü ����
					// MySQL ���� ���� : url, ����� ����, �н����� ����
					con = DriverManager.getConnection(url,user,pwd);
					
					// COmmection ��ü �����Ǹ� DB ���� ����
					if(con != null) {
						System.out.println("DB���� ����");
					}
					
					
				} catch (Exception e) {
					System.out.println("�����߻�");
					e.printStackTrace();
				}
			}
	

	// select �� �����ؼ� �����ͺ��̽��� student ���̺� ���� ��ȸ / ����� �޼ҵ�
	public void selectStudent() {
		
		// ������ �ۼ�
		try {
			String sql = "select*from student order by stdNo";
			
			pstmt = con.prepareStatement(sql);
			
		// ������ ����
			rs= pstmt.executeQuery(sql);
			
			while(rs.next()) {
				String stdNo = rs.getString(1);
				String stdName = rs.getString(2);
				int stdYear = rs.getInt(3);
				String stdAddress = rs.getString(4);
				Date stdBirthday = rs.getDate(5);
				String dptNo = rs.getString(6);
				
				System.out.format("%-10s \t %-10s \t %-4d %20s %13s %5s\n",
						stdNo, stdName, stdYear, stdAddress, stdBirthday, dptNo);
			}
			

		} catch (SQLException e) {
		System.out.println("���� �߻�");
		}
		
	}
	
	// insert �� �����ؼ� student ���̺� ������ �޼ҵ�
		public void insertStudent(StudentDTO dto) {
			try {
				String sql = "insert into student values (?, ?, ?, ?, ?, ?)";
				
				// sql �� values�� �� ������ ����
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, dto.getStdNo());
				pstmt.setString(2, dto.getStdName());
				pstmt.setInt(3, dto.getStdYear());
				pstmt.setString(4, dto.getStdAddress());
				pstmt.setString(5, dto.getStdBirthday());
				pstmt.setString(6, dto.getDptNo());
				
				// ������ ����
				int result = pstmt.executeUpdate();
				
				if(result > 0) {
					System.out.println("������ �Է� ����");
				}
				
				
			} catch (SQLException e) {
				System.out.println("���� �߻�");
				e.printStackTrace();
			}
		}
		
	}

