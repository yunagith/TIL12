package db6;

import db5.StudentDAO;
import db5.StudentDTO;

public class ProductMain {

	public static void main(String[] args) {
		// DTO / DAO ���
		
				// DAO ��ü �����ϸ鼭 DB ����
				// selectStudent() �޼ҵ� ȣ��
				ProductDAO prdDAO = new ProductDAO();
				
				// ������ ���� : StudentDTO ��ü ���� / ������ ����
				ProductDTO prdDTO = new ProductDTO("20","������",10000,"�Ｚ","���", "1");
				
				// insertStudent(stdDTO) ȣ���ϸ鼭 stdDTO ����
				prdDAO.insertProduct(prdDTO);
				
				prdDAO.selectProduct();
				
				prdDAO.close();

	}

}
