package db3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BookInsertMain {

	public static void main(String[] args) {
		// JDBC : ���� ���� ��� Ŭ���� (INSERT ����)
		
		Connection con = null;
		
		// (1) DB ����
		try {
			
			// Connection ��ü �޾ƿ�
			con = DBConnect.getConnection();
			
			// ������ ������ ������ �����ؼ� ���
			String bookNo = "1017";
			String bookName = "�˰���2";
			String bookAuthor = "��ö��";
			int bookPrice = 25000;
			String bookDate = "2022-01-05";
			int bookStock = 10;
			String pubNo = "1";		
			
			
			// (2) ������ �ۼ� : INSERT 
			// ������ ������ ��ġ ���� : values(?,?,?,?,?,?,?)
			String sql = "insert into book values (?,?,?,?,?,?,?)";			
			
			// (3) sql�� values�� �� ������ ����
			// setXXX() �޼ҵ� ��� : pstmt.setString(1, bookNo)
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bookNo);
			pstmt.setString(2, bookName);
			pstmt.setString(3, bookAuthor);
			pstmt.setInt(4, bookPrice);
			pstmt.setString(5, bookDate);
			pstmt.setInt(6, bookStock);
			pstmt.setString(7, pubNo);		
			
			
			// (4) ������ ���� : executeUpdate()
			// ������ ���� ���� �� ��ȯ
			// �۾� �Ϸ� �޽��� ���
			// result�� 0���� ũ�� �Է� ���� (1���̶� ������ �޾����� ����)
			
			//pstmt.executeUpdate();
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("���� ���� ��� ����");
			}
			
			// ���ҽ� close()
			// (5) DBConnect.close(con, pstmt);
			
		} catch (Exception e) {
			System.out.println("���� �߻�");
			e.printStackTrace();
		}
				

	}

}



