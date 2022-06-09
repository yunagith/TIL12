package db6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ProductDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ProductDAO() {
				// DB 연결 담당	
		try {
			// JDBC Driver 클래스의 객체 생성 런타임 시 로드
			//Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 연결 url, 사용자 계정, 패스워드 문자열로 지정
			String url ="jdbc:mysql://localhost:3306/sqldb3?serverTimezone-UTC";
			String user = "root";
			String pwd = "1234";
						
			// DB 연결하기 위한 객체
			// DriverManager를 통해 Connection 객체 생성
			// MySQL 서버 연결 : url, 사용자 계정, 패스워드 전송
			conn = DriverManager.getConnection(url, user, pwd);
			
			// Connection 객체 생성되면 DB 연결 성공
			if(conn != null) {
				System.out.println("DB 연결 성공");
			}
			
		} catch (Exception e) {
			System.out.println("오류 발생");
			e.printStackTrace();
		}
	}
	public void selectProduct() {
		try {
			
			String sql = "select*from product order by prdNo";
			pstmt = conn.prepareStatement(sql);
			
			// 쿼리문 실행
			rs= pstmt.executeQuery(sql);
			
			while(rs.next()) {
				String prdNo = rs.getString(1);
				String prdName = rs.getString(2);
				int prdPrice = rs.getInt(3);
				String prdMaker = rs.getString(4);
				String prdColo = rs.getString(5);
				String ctgNo = rs.getString(6);
				
				System.out.format("%-10s \t %-10s \t %-4d %20s %13s %5s \n",
						prdNo, prdName, prdPrice, prdMaker, prdColo, ctgNo);
				
			}
			
		} catch (SQLException e) {
			System.out.println("오류 발생!");
		}

	}
	
	// insert 문 수행해서 student 테이블에 저장할 메소드
			public void insertStudent(ProductDTO dto) {
				try {
					String sql = "insert into product values (?, ?, ?, ?, ?, ?)";
					
					// sql 문 values에 들어갈 데이터 설정
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, dto.getPrdNo());
					pstmt.setString(2, dto.getPrdName());
					pstmt.setInt(3, dto.getPrdPrice());
					pstmt.setString(4, dto.getPrdMaker());
					pstmt.setString(5, dto.getPrdColo());
					pstmt.setString(6, dto.getCtgNo());
					
					// 쿼리문 실행
					int result = pstmt.executeUpdate();
					
					if(result > 0) {
						System.out.println("데이터 입력 성공");
					}
					
					
				} catch (SQLException e) {
					System.out.println("오류 발생");
					e.printStackTrace();
				}
			}
	
	
	
	
	
	
	
}
