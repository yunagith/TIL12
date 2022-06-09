package db5;

public class StudentMain {

	public static void main(String[] args) {
		// DTO / DAO 사용
		
		// DAO 객체 생성하면서 DB 연결
		// selectStudent() 메소드 호출
		StudentDAO stdDAO = new StudentDAO();
		stdDAO.selectStudent();
		
		// 데이터 저장 : StudentDTO 객체 생성 / 데이터 저장
		StudentDTO stdDTO = new StudentDTO("2022003","변학부",1,"제주도 제주시","2000-10-10", "1");
		
		// insertStudent(stdDTO) 호출하면서 stdDTO 전달
		stdDAO.insertStudent(stdDTO);
		
		stdDAO.selectStudent();
	}

}
