package db5;

public class StudentMain {

	public static void main(String[] args) {
		// DTO / DAO ���
		
		// DAO ��ü �����ϸ鼭 DB ����
		// selectStudent() �޼ҵ� ȣ��
		StudentDAO stdDAO = new StudentDAO();
		stdDAO.selectStudent();
		
		// ������ ���� : StudentDTO ��ü ���� / ������ ����
		StudentDTO stdDTO = new StudentDTO("2022003","���к�",1,"���ֵ� ���ֽ�","2000-10-10", "1");
		
		// insertStudent(stdDTO) ȣ���ϸ鼭 stdDTO ����
		stdDAO.insertStudent(stdDTO);
		
		stdDAO.selectStudent();
	}

}
