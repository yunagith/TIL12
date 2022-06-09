package db6;

import db5.StudentDAO;
import db5.StudentDTO;

public class ProductMain {

	public static void main(String[] args) {
		// DTO / DAO 사용
		
				// DAO 객체 생성하면서 DB 연결
				// selectStudent() 메소드 호출
				ProductDAO prdDAO = new ProductDAO();
				
				// 데이터 저장 : StudentDTO 객체 생성 / 데이터 저장
				ProductDTO prdDTO = new ProductDTO("20","충전기",10000,"삼성","흰색", "1");
				
				// insertStudent(stdDTO) 호출하면서 stdDTO 전달
				prdDAO.insertProduct(prdDTO);
				
				prdDAO.selectProduct();
				
				prdDAO.close();

	}

}
