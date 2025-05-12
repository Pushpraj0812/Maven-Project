package in.co.rays.proj4.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.SubjectBean;
import in.co.rays.proj4.model.SubjectModel;

public class TestSubjectModel {

	public static void main(String[] args) throws Exception {

		//testNextPk();
		//testadd();
		//testFindByPK();
		//testUpdate();
		//testSearch();
		//testfindbyCourseId();
		testDelete();

	}

	private static void testNextPk() {

		SubjectModel model = new SubjectModel();

		int i = model.nextPK();

		System.out.println("nexPk is: " + i);
	}

	private static void testadd() throws Exception {

		SubjectBean bean = new SubjectBean();

		bean.setName("Extra");
		bean.setCourseId(001);
		bean.setCourseName("Extra");
		bean.setDescription("delete");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		SubjectModel model = new SubjectModel();
		model.add(bean);
	}

	private static void testFindByPK() throws Exception {

		SubjectModel model = new SubjectModel();
		SubjectBean bean = model.findbyPK(1);

		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getCourseId());
			System.out.print("\t" + bean.getCourseName());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.print("\t" + bean.getModifiedDatetime());
		}
	}

	private static void testUpdate() throws Exception {

		SubjectBean bean = new SubjectBean();

		bean.setId(2);
		bean.setName("Some Name");
		bean.setCourseId(1);
		bean.setCourseName("Course Title");
		bean.setDescription("Course Description");
		bean.setCreatedBy("Admin");
		bean.setModifiedBy("Editor");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		SubjectModel model = new SubjectModel();
		model.update(bean);
	}

	private static void testSearch() throws Exception {

		SubjectModel model = new SubjectModel();
		SubjectBean bean = new SubjectBean();

		bean.setName("Physics");

		List list = model.search(bean, 1,5);

		Iterator it = list.iterator();

		while (it.hasNext()) {
			bean = (SubjectBean) it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getCourseId());
			System.out.print("\t" + bean.getCourseName());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.print("\t" + bean.getModifiedDatetime());
		}
	}
	
	private static void testfindbyCourseId() throws Exception {
		
		SubjectModel model = new SubjectModel();
		SubjectBean bean = model.findByCourseId(1);
		
		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getCourseId());
			System.out.print("\t" + bean.getCourseName());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.print("\t" + bean.getModifiedDatetime());
		}
	}
	
	private static void testDelete() throws Exception {
		
		SubjectModel model = new SubjectModel();
		model.delete(2);
	}
}