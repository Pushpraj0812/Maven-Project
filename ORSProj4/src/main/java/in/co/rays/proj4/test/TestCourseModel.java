package in.co.rays.proj4.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.CourseBean;
import in.co.rays.proj4.model.CourseModel;
import in.co.rays.proj4.util.JDBCDataSource;

public class TestCourseModel {

	public static void main(String[] args) throws Exception {

		// testNextPk();
		// testFindByPK();
		// testadd();
		//testUpdate();
		testSearch();
		//testFindByName();
		//testDelete();

	}

	private static void testNextPk() {

		CourseModel model = new CourseModel();

		int i = model.nextPK();

		System.out.println("nexPk is: " + i);
	}

	private static void testFindByPK() throws Exception {

		CourseModel model = new CourseModel();
		CourseBean bean = model.findbypk(1);

		if (bean != null) {

			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getDuration());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.print("\t" + bean.getModifiedDatetime());
		}
	}

	private static void testadd() throws Exception {

		CourseBean bean = new CourseBean();

		bean.setName("English");
		bean.setDuration("45 minutes");
		bean.setDescription("Theory");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		CourseModel model = new CourseModel();
		model.add(bean);
	}

	private static void testUpdate() throws Exception {

		CourseBean bean = new CourseBean();

		bean.setId(5);
		bean.setName("Hindi");
		bean.setDuration("45 minutes");
		bean.setDescription("Theory");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		CourseModel model = new CourseModel();
		model.update(bean);
	}

	private static void testSearch() throws Exception {

		CourseModel model = new CourseModel();
		CourseBean bean = new CourseBean();

		List list = model.search(bean, 1,5);

		Iterator it = list.iterator();
		
		while (it.hasNext()) {
			bean = (CourseBean)it.next();
			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getDuration());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.print("\t" + bean.getModifiedDatetime());
		}
	}
	
	private static void testFindByName() throws Exception {
		
		CourseModel model = new CourseModel();
		CourseBean bean = model.findbyname("Physics");
		
		if(bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getDuration());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.print("\t" + bean.getModifiedDatetime());
		}
	}
	
	private static void testDelete() throws Exception {
		
		CourseModel model = new CourseModel();
		model.delete(5);
	}
}