package db3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BookDeleteMain {

	public static void main(String[] args) {
		// JDBC : ���� ���� ���� Ŭ���� (DELETE  ����)
		
		Connection con = null;
		
		// (1) DB ����
		// Conection ��ü �޾ƿ�
		con = DBConnect.getConnection();
		
		// (2) ������ ������ȣ �Է�
		Scanner sc = new Scanner(System.in);
		
		System.out.println("���� ���� ����");
		
		System.out.print("������ ������ȣ �Է� : ");
		String bookNo = sc.nextLine();
		
		
		try {
			// (3) ������ �ۼ� : Delete
			String sql = "delete from book where bookNo=?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bookNo);
			
			// (4) ������ ���� : executeUpdate
			int result = pstmt.executeUpdate(); // insert/update/delete�� ����
			
			if(result > 0) {
				System.out.println("���� ���� ���� ����");
			}
			
			
			// (5) ���ҽ� close()
			DBConnect.close(con, pstmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
