package db3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BookUpdateMain {

	public static void main(String[] args) {
		//JDBC : 도서 정보 수정 클래스 (UPDATE 수행)
		
		// (1) DB 연결 : DBConnecti.getConnection() 호출해서 con 객체 받아옴
		Connection con = DBConnect.getConnection();
		
		// (2)수정할 데이터 입력
		Scanner sc = new Scanner(System.in);
		
		// 데이터 입력
		System.out.println("도서 정보 수정");
		System.out.println("------------------");
		
		System.out.print("수정할 도서번호 입력 : ");
		String bookNo = sc.nextLine();
		
		System.out.print("도서명 입력 : ");
		String bookName = sc.nextLine();
		
		System.out.print("저자 입력 : ");
		String bookAuthor = sc.nextLine();
		
		System.out.print("가격 입력 : ");
		int bookPrice = sc.nextInt();
		
		sc.nextLine(); // 앞의 엔터값이 다음 변수에 들어가지 않도록 버퍼 읽어 들임
		
		System.out.print("발행일 입력 : ");
		String bookDate = sc.nextLine();
		
		System.out.print("재고 입력 : ");
		int bookStock = sc.nextInt();
		
		sc.nextLine(); // 앞의 엔터값이 다음 변수에 들어가지 않도록 버퍼 읽어 들임
		
		System.out.print("출판사 번호 입력 : ");
		String pubNo = sc.nextLine();
		
		try {
			// (3) 쿼리문 작성 : update
			// UPDATE 테이블 SET 열이름=값 WHERE 조건;
			// 주의! : 기본키인 bookNo는 수정 안 함
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
			
			
			// (4) 쿼리문 실행
			int result = pstmt.executeUpdate(); // insert/update/delete에 적용
			
			if(result > 0) {
				System.out.println("도서 정보 수정 성공");
			}
			
			// (5) 리소스 close()
			DBConnect.close(con, pstmt);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}