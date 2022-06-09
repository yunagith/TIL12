package db4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import db3.DBConnect;

public class ProductDeleteMain {

	public static void main(String[] args) {
		// JDBC : 상품 정보 삭제 클래스 (DELETE  수행)
		
		Connection con = null;
		
		// (1) DB 연결
		// Conection 객체 받아옴
		con = DBConnect.getConnection();
		
		// (2) 삭제할 도서번호 입력
		Scanner sc = new Scanner(System.in);
		
		System.out.println("상품 정보 삭제");
		
		System.out.print("삭제할 상품번호 입력 : ");
		String prdNo = sc.nextLine();
		
		
		try {
			// (3) 쿼리문 작성 : Delete
			String sql = "delete from product where prdNo=?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, prdNo);
			
			// (4) 쿼리문 실행 : executeUpdate
			int result = pstmt.executeUpdate(); // insert/update/delete에 적용
			
			if(result > 0) {
				System.out.println("상품 정보 삭제 성공");
			}
			
			
			// (5) 리소스 close()
			DBConnect.close(con, pstmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
