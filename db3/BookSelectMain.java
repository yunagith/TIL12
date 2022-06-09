package db3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class BookSelectMain {

	public static void main(String[] args) {
		// JDBC : ���� ���� ��ȸ Ŭ���� (SELECT ����)
		
		Connection con = null;
		
		// (1) DB ����
		try {
			// DB ���� ��� Ŭ������ ���� �޼ҵ� ȣ���ؼ� Connection  ��ü �޾ƿ�
			con = DBConnect.getConnection();
			
			// (2) ������ �ۼ� : SELECT 
			//String sql = "select * from book where bookPrice >= 25000 order by bookNo ";		
			String sql = "select * from book order by bookNo ";		
			
			// (3) ������ ������ ���� PreparedStatement ��ü ����
			// Connection �������̽��� prepareStatement() �޼ҵ带 ����Ͽ� ��ü ����
			PreparedStatement pstmt = con.prepareStatement(sql);			
			
			// (4) ������ �����Ű�� ��� �޾ƿ�
			// executeQuery() �޼ҵ� ���
			// ����� ResultSet ��ü�� ����
			ResultSet rs = pstmt.executeQuery(sql);		
			
			System.out.println("���� ���� ��ȸ");
			System.out.println("������ȣ \t  ������ \t\t\t\t\t ���� \t ���� \t\t    ������ \t\t\t ��� \t     ���ǻ��ȣ");
			
			//  (5) executeQuery() ���� ��� �޾ƿ� ResultSet���� ������ ����
			// ResultSet�� next() �޼ҵ带 �̿��ؼ� ���� Ŀ�� �̵����ϸ鼭 ���� �� ����
			// -- ���� ���� ������ true, ������ false ��ȯ
			// ��� �� ���������� �ݺ��� ���
			// ������ Ÿ�Կ� ���� getXXX() �޼ҵ� ���
			while(rs.next()) {
				String bookNo = rs.getString(1);
				String bookName = rs.getString(2);
				String bookAuthor = rs.getNString(3);
				int bookPrice = rs.getInt(4);
				Date bookDate = rs.getDate(5);
				int bookStock = rs.getInt(6);
				String pubNo = rs.getString(7);				
				
				// (6) �� �྿ ���
				System.out.format("%-10s\t%-25s\t%10s\t%6d\t %13s\t%3d\t%10s\n",
						bookNo, bookName, bookAuthor, bookPrice, bookDate, bookStock, pubNo);
			
			}
			
			// (7) ���ҽ� �ݱ� (close)
			DBConnect.close(con, pstmt, rs);

			
		} catch (Exception e) {
			System.out.println("���� �߻�");
			e.printStackTrace();
		}

	}

}

