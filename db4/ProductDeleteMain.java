package db4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import db3.DBConnect;

public class ProductDeleteMain {

	public static void main(String[] args) {
		// JDBC : ��ǰ ���� ���� Ŭ���� (DELETE  ����)
		
		Connection con = null;
		
		// (1) DB ����
		// Conection ��ü �޾ƿ�
		con = DBConnect.getConnection();
		
		// (2) ������ ������ȣ �Է�
		Scanner sc = new Scanner(System.in);
		
		System.out.println("��ǰ ���� ����");
		
		System.out.print("������ ��ǰ��ȣ �Է� : ");
		String prdNo = sc.nextLine();
		
		
		try {
			// (3) ������ �ۼ� : Delete
			String sql = "delete from product where prdNo=?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, prdNo);
			
			// (4) ������ ���� : executeUpdate
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
