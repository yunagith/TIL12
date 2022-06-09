package db4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db3.DBConnect;

public class ProductSelectMain {

	public static void main(String[] args) {
		// ��������
		// ��ǰ ���� ��ȸ Ŭ����
		
		Connection con = null;

		// (1) DB ����
		try {
			// DB ���� ��� Ŭ������ ���� �޼ҵ� ȣ���ؼ� Connection  ��ü �޾ƿ�
						con = DBConnect.getConnection();
			
			// (2) select ������ �ۼ�
			String sql = "select*from product order by prdNo ";
			
			// (3) ������ ������ ���� PreparedStatement ��ü ����
			// Connection �������̽��� prepareStatement() �޼ҵ带 ����Ͽ� ��ü ����
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			// (4) ������ �����Ű�� ��� �޾ƿ� : executeQuery() �޼ҵ� ���
			// ����� ResultSet ��ü�� ����
			ResultSet rs = pstmt.executeQuery(sql);
			
			System.out.println("��ǰ ���� ��ȸ");
			
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
			DBConnect.close(con, pstmt, rs);
			
			}catch (Exception e) {
				System.out.println("�����߻�");
				e.printStackTrace();
			}
	}

}
