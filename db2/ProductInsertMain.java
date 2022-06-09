package db2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ProductInsertMain {

	public static void main(String[] args) {
				// (1) DB ����
		
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
					Connection con = DriverManager.getConnection(url,user,pwd);
					
					// COmmection ��ü �����Ǹ� DB ���� ����
					if(con != null) {
						System.out.println("��ǰ ���� ��� : DB���� ����");
					}
					
					//������ ������ ������ �����ؼ� ���
					String prdNo = "1012";
					String prdName = "������";
					int prdPrice = 25000;
					String prdMaker = "����";
					String prdColo = "���";
					String ctgNo = "2";
					
					// (2) ������ �ۼ� : insert
					// ������ ������ ��ġ ���� : values(?,?,?,?,?,?)
					String sql = "insert into product values(?,?,?,?,?,?)";
						
					// (3) sql�� values�� �� ������ ����
					// setXXX() �޼ҵ� ��� : pstmt.setString(1, bookNo)
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setString(1, prdNo);
					pstmt.setString(2, prdName);
					pstmt.setInt(3, prdPrice);
					pstmt.setString(4, prdMaker);
					pstmt.setString(5, prdColo);
					pstmt.setString(6, ctgNo);

					
					// (4) ������ ���� : executeUpdate()
					// ������ ���� ���� �� ��ȯ
					// �۾� �Ϸ� �޽��� ���
					// result�� 0���� ũ�� �Է� ���� (1���̶� ������ �޾����� ����)
					
					//pstmt.executeUpdate();
					int result = pstmt.executeUpdate();
					
					if(result>0) {
						System.out.println("��ǰ ���� ��� ����");
					}
				
				} catch (Exception e) {
					System.out.println("�����߻�");
					e.printStackTrace();
				}

	}

}
