package db6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ProductDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ProductDAO() {
				// DB ���� ���	
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
			conn = DriverManager.getConnection(url, user, pwd);
			
			// Connection ��ü �����Ǹ� DB ���� ����
			if(conn != null) {
				System.out.println("DB ���� ����");
			}
			
		} catch (Exception e) {
			System.out.println("���� �߻�");
			e.printStackTrace();
		}
	}
	public void selectProduct() {
		try {
			
			String sql = "select*from product order by prdNo";
			pstmt = conn.prepareStatement(sql);
			
			// ������ ����
			rs= pstmt.executeQuery(sql);
			
			while(rs.next()) {
				String prdNo = rs.getString(1);
				String prdName = rs.getString(2);
				int prdPrice = rs.getInt(3);
				String prdMaker = rs.getString(4);
				String prdColo = rs.getString(5);
				String ctgNo = rs.getString(6);
				
				System.out.format("%-10s \t %-10s \t %-4d %20s %13s %5s \n",
						prdNo, prdName, prdPrice, prdMaker, prdColo, ctgNo);
				
			}
			
		} catch (SQLException e) {
			System.out.println("���� �߻�!");
		}

	}
	
	// insert �� �����ؼ� student ���̺� ������ �޼ҵ�
			public void insertStudent(ProductDTO dto) {
				try {
					String sql = "insert into product values (?, ?, ?, ?, ?, ?)";
					
					// sql �� values�� �� ������ ����
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, dto.getPrdNo());
					pstmt.setString(2, dto.getPrdName());
					pstmt.setInt(3, dto.getPrdPrice());
					pstmt.setString(4, dto.getPrdMaker());
					pstmt.setString(5, dto.getPrdColo());
					pstmt.setString(6, dto.getCtgNo());
					
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
