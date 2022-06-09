package db4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import db3.DBConnect;

public class ProductUpdateMain {

	public static void main(String[] args) {
				// ��������
			
				//JDBC : ��ǰ ���� ���� Ŭ���� (UPDATE ����)
		
				// (1) DB ���� : DBConnecti.getConnection() ȣ���ؼ� con ��ü �޾ƿ�
				Connection con = DBConnect.getConnection();
				
				// (2)������ ������ �Է�
				Scanner sc = new Scanner(System.in);
				
				// ������ �Է�
				System.out.println("��ǰ ���� ����");
				System.out.println("------------------");
				
				System.out.print("��ǰ��ȣ �Է� : ");
				String prdNo = sc.nextLine();
				
				System.out.print("��ǰ�� �Է� : ");
				String prdName = sc.nextLine();
				
				System.out.print("���� �Է� : ");
				int prdPrice = sc.nextInt();
				
				System.out.print("������ �Է� : ");
				String prdMaker = sc.nextLine();
				
				sc.nextLine();
				
				System.out.print("���� �Է� : ");
				String prdColo = sc.nextLine();
				
				System.out.print("������ ��ȣ �Է� : ");
				String ctgNo = sc.nextLine();

				
				try {
					// (3) ������ �ۼ� : update
					// UPDATE ���̺� SET ���̸�=�� WHERE ����;
					// ����! : �⺻Ű�� bookNo�� ���� �� ��
					String sql = "update product set prdName=?, prdPrice=?, "
							+ "prdMaker=?, prdColo=?, ctgNo=? where prdNo=?";
					
					PreparedStatement pstmt = con.prepareStatement(sql);			
					pstmt.setString(1, prdName);
					pstmt.setInt(2, prdPrice);
					pstmt.setString(3, prdMaker);
					pstmt.setString(4, prdColo);
					pstmt.setString(5, ctgNo);		
					pstmt.setString(6, prdNo);
					
					// (4) ������ ����
					int result = pstmt.executeUpdate(); // insert/update/delete�� ����
					
					if(result > 0) {
						System.out.println("��ǰ ���� ���� ����");
					}
					
					// (5) ���ҽ� close()
					DBConnect.close(con, pstmt);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	}

}
