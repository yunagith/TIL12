package db4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import db3.DBConnect;

public class ProductUpdateMain {

	public static void main(String[] args) {
				// 연습문제
			
				//JDBC : 상품 정보 수정 클래스 (UPDATE 수행)
		
				// (1) DB 연결 : DBConnecti.getConnection() 호출해서 con 객체 받아옴
				Connection con = DBConnect.getConnection();
				
				// (2)수정할 데이터 입력
				Scanner sc = new Scanner(System.in);
				
				// 데이터 입력
				System.out.println("상품 정보 수정");
				System.out.println("------------------");
				
				System.out.print("상품번호 입력 : ");
				String prdNo = sc.nextLine();
				
				System.out.print("상품명 입력 : ");
				String prdName = sc.nextLine();
				
				System.out.print("가격 입력 : ");
				int prdPrice = sc.nextInt();
				
				System.out.print("제조사 입력 : ");
				String prdMaker = sc.nextLine();
				
				sc.nextLine();
				
				System.out.print("색상 입력 : ");
				String prdColo = sc.nextLine();
				
				System.out.print("제조사 번호 입력 : ");
				String ctgNo = sc.nextLine();

				
				try {
					// (3) 쿼리문 작성 : update
					// UPDATE 테이블 SET 열이름=값 WHERE 조건;
					// 주의! : 기본키인 bookNo는 수정 안 함
					String sql = "update product set prdName=?, prdPrice=?, "
							+ "prdMaker=?, prdColo=?, ctgNo=? where prdNo=?";
					
					PreparedStatement pstmt = con.prepareStatement(sql);			
					pstmt.setString(1, prdName);
					pstmt.setInt(2, prdPrice);
					pstmt.setString(3, prdMaker);
					pstmt.setString(4, prdColo);
					pstmt.setString(5, ctgNo);		
					pstmt.setString(6, prdNo);
					
					// (4) 쿼리문 실행
					int result = pstmt.executeUpdate(); // insert/update/delete에 적용
					
					if(result > 0) {
						System.out.println("상품 정보 수정 성공");
					}
					
					// (5) 리소스 close()
					DBConnect.close(con, pstmt);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	}

}
