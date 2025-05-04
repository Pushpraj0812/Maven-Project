package in.co.rays.proj4.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.StudentBean;
import in.co.rays.proj4.bean.TimeTableBean;
import in.co.rays.proj4.model.StudentModel;
import in.co.rays.proj4.model.TimeTableModel;
import in.co.rays.proj4.util.JDBCDataSource;

public class TestTimeTableModel {

	public static void main(String[] args) throws Exception {

		//testNextPk();
		//testadd();
		//testFindByPK();
		//testUpdate();
		//testSearch();
		//testFindByCourseID();
		testDelete();

	}

	private static void testNextPk() {

		TimeTableModel model = new TimeTableModel();

		int i = model.nextPK();

		System.out.println("nexPk is: " + i);
	}

	private static void testadd() throws Exception {

		TimeTableBean bean = new TimeTableBean();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		bean.setSemester("2");
		bean.setDescription("efs");
		bean.setExamDate(sdf.parse("08/09/2025"));
		bean.setExamTime("nus");
		bean.setCourseId(1);
		bean.setCourseName("gr");
		bean.setSubjectId(1);
		bean.setSubjectName("Phy");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		TimeTableModel model = new TimeTableModel();
		model.add(bean);
	}

	private static void testFindByPK() throws Exception {

		TimeTableModel model = new TimeTableModel();
		TimeTableBean bean = model.findbyPK(1);

		if (bean != null) {

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getSemester());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getExamDate());
			System.out.print("\t" + bean.getExamTime());
			System.out.print("\t" + bean.getCourseId());
			System.out.print("\t" + bean.getCourseName());
			System.out.print("\t" + bean.getSubjectId());
			System.out.print("\t" + bean.getSubjectName());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.print("\t" + bean.getModifiedDatetime());
		}
	}

	private static void testUpdate() throws Exception {

		TimeTableBean bean = new TimeTableBean();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		bean.setId(2);
		bean.setSemester("1");
		bean.setDescription("ggg");
		bean.setExamDate(sdf.parse("08/12/2025"));
		bean.setExamTime("nus");
		bean.setCourseId(1);
		bean.setCourseName("Physics");
		bean.setSubjectId(1);
		bean.setSubjectName("Phy");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		TimeTableModel model = new TimeTableModel();
		model.update(bean);
	}

	private static void testSearch() throws Exception {

		TimeTableBean bean = new TimeTableBean();

		TimeTableModel model = new TimeTableModel();

		bean.setSubjectName("Phy");

		List list = model.search(bean);

		Iterator it = list.iterator();

		while (it.hasNext()) {
			bean = (TimeTableBean) it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getSemester());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getExamDate());
			System.out.print("\t" + bean.getExamTime());
			System.out.print("\t" + bean.getCourseId());
			System.out.print("\t" + bean.getCourseName());
			System.out.print("\t" + bean.getSubjectId());
			System.out.print("\t" + bean.getSubjectName());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.print("\t" + bean.getModifiedDatetime());
		}
	}

	private static void testFindByCourseID() throws Exception {

		TimeTableModel model = new TimeTableModel();
		TimeTableBean bean = model.findByCourseID(1);

		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getSemester());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getExamDate());
			System.out.print("\t" + bean.getExamTime());
			System.out.print("\t" + bean.getCourseId());
			System.out.print("\t" + bean.getCourseName());
			System.out.print("\t" + bean.getSubjectId());
			System.out.print("\t" + bean.getSubjectName());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.print("\t" + bean.getModifiedDatetime());
		}
	}

	private static void testDelete() throws Exception {

		TimeTableModel model = new TimeTableModel();
		model.delete(2);
	}
}