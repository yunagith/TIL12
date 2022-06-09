package db3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BookInsertMain {

	public static void main(String[] args) {
		// JDBC : 도서 정보 등록 클래스 (INSERT 수행)
		
		Connection con = null;
		
		// (1) DB 연결
		try {
			
			// Connection 객체 받아옴
			con = DBConnect.getConnection();
			
			// 저장할 데이터 변수에 저장해서 사용
			String bookNo = "1017";
			String bookName = "알고리즘2";
			String bookAuthor = "김철수";
			int bookPrice = 25000;
			String bookDate = "2022-01-05";
			int bookStock = 10;
			String pubNo = "1";		
			
			
			// (2) 쿼리문 작성 : INSERT 
			// 저장할 데이터 위치 설정 : values(?,?,?,?,?,?,?)
			String sql = "insert into book values (?,?,?,?,?,?,?)";			
			
			// (3) sql문 values에 들어갈 데이터 설정
			// setXXX() 메소드 사용 : pstmt.setString(1, bookNo)
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bookNo);
			pstmt.setString(2, bookName);
			pstmt.setString(3, bookAuthor);
			pstmt.setInt(4, bookPrice);
			pstmt.setString(5, bookDate);
			pstmt.setInt(6, bookStock);
			pstmt.setString(7, pubNo);		
			
			
			// (4) 쿼리문 실행 : executeUpdate()
			// 영향을 받은 행의 수 반환
			// 작업 완료 메시지 출력
			// result가 0보다 크면 입력 성공 (1행이라도 영향을 받았으면 성공)
			
			//pstmt.executeUpdate();
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("도서 정보 등록 성공");
			}
			
			// 리소스 close()
			// (5) DBConnect.close(con, pstmt);
			
		} catch (Exception e) {
			System.out.println("오류 발생");
			e.printStackTrace();
		}
				

	}

}



