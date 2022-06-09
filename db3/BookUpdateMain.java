package db3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BookUpdateMain {

	public static void main(String[] args) {
		//JDBC : ���� ���� ���� Ŭ���� (UPDATE ����)
		
		// (1) DB ���� : DBConnecti.getConnection() ȣ���ؼ� con ��ü �޾ƿ�
		Connection con = DBConnect.getConnection();
		
		// (2)������ ������ �Է�
		Scanner sc = new Scanner(System.in);
		
		// ������ �Է�
		System.out.println("���� ���� ����");
		System.out.println("------------------");
		
		System.out.print("������ ������ȣ �Է� : ");
		String bookNo = sc.nextLine();
		
		System.out.print("������ �Է� : ");
		String bookName = sc.nextLine();
		
		System.out.print("���� �Է� : ");
		String bookAuthor = sc.nextLine();
		
		System.out.print("���� �Է� : ");
		int bookPrice = sc.nextInt();
		
		sc.nextLine(); // ���� ���Ͱ��� ���� ������ ���� �ʵ��� ���� �о� ����
		
		System.out.print("������ �Է� : ");
		String bookDate = sc.nextLine();
		
		System.out.print("��� �Է� : ");
		int bookStock = sc.nextInt();
		
		sc.nextLine(); // ���� ���Ͱ��� ���� ������ ���� �ʵ��� ���� �о� ����
		
		System.out.print("���ǻ� ��ȣ �Է� : ");
		String pubNo = sc.nextLine();
		
		try {
			// (3) ������ �ۼ� : update
			// UPDATE ���̺� SET ���̸�=�� WHERE ����;
			// ����! : �⺻Ű�� bookNo�� ���� �� ��
			String sql = "update book set bookName=?, bookAuthor=?, "
					+ "bookPrice=?, bookDate=?, bookStock=?, pubNo=? where bookNo=?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);			
			pstmt.setString(1, bookName);
			pstmt.setString(2, bookAuthor);
			pstmt.setInt(3, bookPrice);
			pstmt.setString(4, bookDate);
			pstmt.setInt(5, bookStock);
			pstmt.setString(6, pubNo);		
			pstmt.setString(7, bookNo);
			
			
			// (4) ������ ����
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