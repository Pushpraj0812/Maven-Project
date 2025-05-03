package in.co.rays.proj4.test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.FacultyBean;
import in.co.rays.proj4.model.FacultyModel;

public class TestFacultyModel {

	public static void main(String[] args) throws Exception {

		//testNextPk();
		//testFindByPK();
		//testadd();
		//testUpdate();
		//testSearch();
		//testFindByEmail();
		testDelete();

	}

	private static void testNextPk() {

		FacultyModel model = new FacultyModel();

		int i = model.nextPK();

		System.out.println("nexPk is: " + i);
	}

	private static void testFindByPK() throws Exception {

		FacultyModel model = new FacultyModel();
		FacultyBean bean = model.findByPK(1);

		if (bean != null) {
			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getEmail());
			System.out.print("\t" + bean.getCollegeId());
			System.out.print("\t" + bean.getCollegeName());
			System.out.print("\t" + bean.getCourseId());
			System.out.print("\t" + bean.getSubjectId());
			System.out.print("\t" + bean.getSubjectName());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.print("\t" + bean.getModifiedDatetime());
		}
	}

	private static void testadd() throws Exception {

		FacultyBean bean = new FacultyBean();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		bean.setFirstName("Shahid");
		bean.setLastName("Kapoor");
		bean.setDob(sdf.parse("2002-02-02"));
		bean.setGender("Male");
		bean.setMobileNo("9828567402");
		bean.setEmail("ram@gmail.com");
		bean.setCollegeId(1L);
		bean.setCollegeName("DAVV");
		bean.setCourseId(1);
		bean.setSubjectId(1);
		bean.setSubjectName("Physics");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		FacultyModel model = new FacultyModel();
		model.add(bean);
	}

	private static void testUpdate() throws Exception {

		FacultyBean bean = new FacultyBean();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		bean.setId(1);
		bean.setFirstName("Shahid");
		bean.setLastName("Kapoor");
		bean.setDob(sdf.parse("2002-02-02"));
		bean.setGender("Male");
		bean.setMobileNo("9828567402");
		bean.setEmail("ram@gmail.com");
		bean.setCollegeId(1L);
		bean.setCollegeName("DAVV");
		bean.setCourseId(1);
		bean.setSubjectId(1);
		bean.setSubjectName("Physics");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		
		FacultyModel model = new FacultyModel();
		model.update(bean);
	}

	private static void testSearch() throws Exception {

		FacultyBean bean = new FacultyBean();
		FacultyModel model = new FacultyModel();

		bean.setFirstName("Shahid");

		List list = model.search(bean);

		Iterator it = list.iterator();

		while (it.hasNext()) {
			bean = (FacultyBean) it.next();
			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getEmail());
			System.out.print("\t" + bean.getCollegeId());
			System.out.print("\t" + bean.getCollegeName());
			System.out.print("\t" + bean.getCourseId());
			System.out.print("\t" + bean.getSubjectId());
			System.out.print("\t" + bean.getSubjectName());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.print("\t" + bean.getModifiedDatetime());
		}
	}

	private static void testFindByEmail() throws Exception {

		FacultyModel model = new FacultyModel();
		FacultyBean bean = model.findByEmail("ram@gmail.com");

		if (bean != null) {
			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getEmail());
			System.out.print("\t" + bean.getCollegeId());
			System.out.print("\t" + bean.getCollegeName());
			System.out.print("\t" + bean.getCourseId());
			System.out.print("\t" + bean.getSubjectId());
			System.out.print("\t" + bean.getSubjectName());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.print("\t" + bean.getModifiedDatetime());
		}
	}

	private static void testDelete() throws Exception {

		FacultyModel model = new FacultyModel();
		model.delete(2);
	}
}