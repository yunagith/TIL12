package db2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductSelectMain {

	public static void main(String[] args) {
		// 연습문제
		// 상품 정보 조회 클래스

		// (1) DB 연결
		try {
			// JDBC Driver 클래스의 객체 생성 런타임 시 로드
			
			// Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 연결 url, 사용자 계정, 패스워드 문자열로 지정
			String url = "jdbc:mysql://localhost:3306/sqldb3?serverTimezone-UTC";
			String user = "root";
			String pwd = "1234";
			
			// DB 연결하기 위한 객체
			// DriverManager 를 통해 Connection 객체 생성
			// MySQL 서버 연결 : url, 사용자 계정, 패스워드 전송
			Connection con = DriverManager.getConnection(url,user,pwd);
			
			// COmmection 객체 생성되면 DB 연결 성공
			if(con != null) {
				System.out.println("DB연결 성공");
			}
			
			// (2) select 쿼리문 작성
			String sql = "select*from product order by prdNo ";
			
			// (3) 쿼리문 전송을 위한 PreparedStatement 객체 생성
			// Connection 인터페이스의 prepareStatement() 메소드를 사용하여 객체 생성
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			// (4) 쿼리문 실행시키고 결과 받아옴 : executeQuery() 메소드 사용
			// 결과는 ResultSet 객체가 받음
			ResultSet rs = pstmt.executeQuery(sql);
			
			System.out.println("도서 정보 조회");
			
			// (5) executeQuery() 실행 결과 받아온 ResultSet에서 데이터 추출
			// ResultSet의 next() 메소드를 이용해서 논리적 커서 이동해하면서 다음 행 지정
			// -- 다음 행이 있으면 true, 없으면 false 반환
			// 모든 행 가져오려면 반복문 사용
			// 데이터 타입에 맞춰 getXXX() 메소드 사용
			while(rs.next()) {
			String prdNo = rs.getString(1);
			String prdName = rs.getString(2);
			int prdPrice = rs.getInt(3);
			String prdMaker = rs.getString(4);
			String prdColo = rs.getString(5);
			String ctgNo = rs.getString(6);
			
			// (6) 한행씩 출력
			System.out.format("%-10s \t %-25s \t %10d \t %6s \t %13s \t %3s \n",
					prdNo,prdName,prdPrice,prdMaker,prdColo,ctgNo);
			
			}
			
			// (7) 리소스 닫기 (close) 
						rs.close();
						pstmt.close();
						con.close();
			
			}catch (Exception e) {
				System.out.println("오류발생");
				e.printStackTrace();
			}
	}

}
