package in.co.rays.proj4.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.StudentBean;
import in.co.rays.proj4.model.StudentModel;

public class TestStudentModel {
	
	public static void main(String[] args) throws Exception {

		//testNextPk();
		testadd();
		//testUpdate();
		//testFindByPK();
		//testSearch();
		//testFindByEmail();
		//testDelete();

	}
	private static void testNextPk() {

		StudentModel model = new StudentModel();

		int i = model.nextPK();

		System.out.println("nexPk is: " + i);
	}
	
	private static void testadd() throws Exception {
		
		StudentBean bean = new StudentBean();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		
		bean.setFirstName("Pushpraj");
		bean.setLastName("Kachhaway");
		bean.setDob(sdf.parse("08/12/2025"));
		bean.setGender("Male");
		bean.setMobileNo("8718948410");
		bean.setEmail("pushpraj0812@gmail.com");
		bean.setCollageID(01);
		bean.setCollageName("Rays");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		
		StudentModel model = new StudentModel();
		model.add(bean);
	}
	
	private static void testUpdate() throws Exception {
		
		StudentBean bean = new StudentBean();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		bean.setId(1);
		bean.setFirstName("Pushpraj");
		bean.setLastName("Kachhaway");
		bean.setDob(sdf.parse("08/12/2025"));
		bean.setGender("Male");
		bean.setMobileNo("8718948410");
		bean.setEmail("pushpraj0812@gmail.com");
		bean.setCollageID(01);
		bean.setCollageName("NCS");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		
		StudentModel model = new StudentModel();
		model.update(bean);
	}
	
	private static void testFindByPK() throws Exception {
		
		StudentModel model = new StudentModel();
		StudentBean bean = model.findbyPK(1);
		
		if (bean != null) {
			
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getEmail());
			System.out.print("\t" + bean.getCollageID());
			System.out.print("\t" + bean.getCollageName());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.print("\t" + bean.getModifiedDatetime());
		}
	}
	
	private static void testSearch() throws Exception {
		
		StudentBean bean = new StudentBean();
		
		StudentModel model = new StudentModel();
		
		bean.setFirstName("Pushpraj");
		
		List list = model.search(bean);
		
		Iterator it = list.iterator();
		
		while (it.hasNext()) {
			bean = (StudentBean)it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getEmail());
			System.out.print("\t" + bean.getCollageID());
			System.out.print("\t" + bean.getCollageName());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.print("\t" + bean.getModifiedDatetime());
		}
	}
	
	private static void testFindByEmail() throws Exception {
		
		StudentModel model = new StudentModel();
		StudentBean bean = model.findbyemail("pushpraj0812@gmail.com");
		
		if(bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getEmail());
			System.out.print("\t" + bean.getCollageID());
			System.out.print("\t" + bean.getCollageName());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.print("\t" + bean.getModifiedDatetime());
		}
	}
	
	private static void testDelete() throws Exception {
		
		StudentModel model = new StudentModel();
		model.delete(1);
	}
}