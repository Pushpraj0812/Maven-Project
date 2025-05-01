package in.co.rays.proj4.test;

import java.text.SimpleDateFormat;

import in.co.rays.proj4.bean.StudentBean;
import in.co.rays.proj4.model.StudentModel;

public class TestStudentModel {
	
	public static void main(String[] args) {

		//testNextPk();

	}
	private static void testNextPk() {

		StudentModel model = new StudentModel();

		int i = model.nextPK();

		System.out.println("nexPk is: " + i);
	}
	
	private static void testadd() {
		
		StudentBean bean = new StudentBean();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		
		bean.setFirstName("Pushpraj");
		bean.setLastName("Kachhaway");
		bean.setDob(sdf.parse("08/12/2001"));
	}
}