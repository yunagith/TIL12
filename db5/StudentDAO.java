package db5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class StudentDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public StudentDAO() {
				// DB 연결 담당	
				
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
					con = DriverManager.getConnection(url,user,pwd);
					
					// COmmection 객체 생성되면 DB 연결 성공
					if(con != null) {
						System.out.println("DB연결 성공");
					}
					
					
				} catch (Exception e) {
					System.out.println("오류발생");
					e.printStackTrace();
				}
			}
	

	// select 문 수행해서 데이터베이스의 student 테이블 내용 조회 / 출력할 메소드
	public void selectStudent() {
		
		// 쿼리문 작성
		try {
			String sql = "select*from student order by stdNo";
			
			pstmt = con.prepareStatement(sql);
			
		// 쿼리문 실행
			rs= pstmt.executeQuery(sql);
			
			while(rs.next()) {
				String stdNo = rs.getString(1);
				String stdName = rs.getString(2);
				int stdYear = rs.getInt(3);
				String stdAddress = rs.getString(4);
				Date stdBirthday = rs.getDate(5);
				String dptNo = rs.getString(6);
				
				System.out.format("%-10s \t %-10s \t %-4d %20s %13s %5s\n",
						stdNo, stdName, stdYear, stdAddress, stdBirthday, dptNo);
			}
			

		} catch (SQLException e) {
		System.out.println("오류 발생");
		}
		
	}
	
	// insert 문 수행해서 student 테이블에 저장할 메소드
		public void insertStudent(StudentDTO dto) {
			try {
				String sql = "insert into student values (?, ?, ?, ?, ?, ?)";
				
				// sql 문 values에 들어갈 데이터 설정
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, dto.getStdNo());
				pstmt.setString(2, dto.getStdName());
				pstmt.setInt(3, dto.getStdYear());
				pstmt.setString(4, dto.getStdAddress());
				pstmt.setString(5, dto.getStdBirthday());
				pstmt.setString(6, dto.getDptNo());
				
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

