package db4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import db3.DBConnect;

public class ProductInsertMain {

	public static void main(String[] args) {
				
					Connection con = null;
		
				// (1) DB ����
		
				try {
					// Connection ��ü �޾ƿ�
					con = DBConnect.getConnection();
					
					//������ ������ ������ �����ؼ� ���
					String prdNo = "16";
					String prdName = "������2";
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
