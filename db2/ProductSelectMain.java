package db2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductSelectMain {

	public static void main(String[] args) {
		// ��������
		// ��ǰ ���� ��ȸ Ŭ����

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
				System.out.println("DB���� ����");
			}
			
			// (2) select ������ �ۼ�
			String sql = "select*from product order by prdNo ";
			
			// (3) ������ ������ ���� PreparedStatement ��ü ����
			// Connection �������̽��� prepareStatement() �޼ҵ带 ����Ͽ� ��ü ����
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			// (4) ������ �����Ű�� ��� �޾ƿ� : executeQuery() �޼ҵ� ���
			// ����� ResultSet ��ü�� ����
			ResultSet rs = pstmt.executeQuery(sql);
			
			System.out.println("���� ���� ��ȸ");
			
			// (5) executeQuery() ���� ��� �޾ƿ� ResultSet���� ������ ����
			// ResultSet�� next() �޼ҵ带 �̿��ؼ� ���� Ŀ�� �̵����ϸ鼭 ���� �� ����
			// -- ���� ���� ������ true, ������ false ��ȯ
			// ��� �� ���������� �ݺ��� ���
			// ������ Ÿ�Կ� ���� getXXX() �޼ҵ� ���
			while(rs.next()) {
			String prdNo = rs.getString(1);
			String prdName = rs.getString(2);
			int prdPrice = rs.getInt(3);
			String prdMaker = rs.getString(4);
			String prdColo = rs.getString(5);
			String ctgNo = rs.getString(6);
			
			// (6) ���྿ ���
			System.out.format("%-10s \t %-25s \t %10d \t %6s \t %13s \t %3s \n",
					prdNo,prdName,prdPrice,prdMaker,prdColo,ctgNo);
			
			}
			
			// (7) ���ҽ� �ݱ� (close) 
						rs.close();
						pstmt.close();
						con.close();
			
			}catch (Exception e) {
				System.out.println("�����߻�");
				e.printStackTrace();
			}
	}

}
