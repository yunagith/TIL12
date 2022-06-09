package db4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db3.DBConnect;

public class ProductSelectMain {

	public static void main(String[] args) {
		// 연습문제
		// 상품 정보 조회 클래스
		
		Connection con = null;

		// (1) DB 연결
		try {
			// DB 연결 담당 클래스의 연결 메소드 호출해서 Connection  객체 받아옴
						con = DBConnect.getConnection();
			
			// (2) select 쿼리문 작성
			String sql = "select*from product order by prdNo ";
			
			// (3) 쿼리문 전송을 위한 PreparedStatement 객체 생성
			// Connection 인터페이스의 prepareStatement() 메소드를 사용하여 객체 생성
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			// (4) 쿼리문 실행시키고 결과 받아옴 : executeQuery() 메소드 사용
			// 결과는 ResultSet 객체가 받음
			ResultSet rs = pstmt.executeQuery(sql);
			
			System.out.println("상품 정보 조회");
			
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
			DBConnect.close(con, pstmt, rs);
			
			}catch (Exception e) {
				System.out.println("오류발생");
				e.printStackTrace();
			}
	}

}
