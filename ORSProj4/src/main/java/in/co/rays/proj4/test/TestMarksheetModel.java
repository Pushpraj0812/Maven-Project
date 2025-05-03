package in.co.rays.proj4.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.MarksheetBean;
import in.co.rays.proj4.model.MarksheetModel;

public class TestMarksheetModel {

	public static void main(String[] args) throws Exception {

		// testNextPk();
		//testadd();
		//testFindByPK();
		//testUpdate();
		//testSearch();
		//testFindByStudentID();
		testDelete();

	}

	private static void testNextPk() {

		MarksheetModel model = new MarksheetModel();

		int i = model.nextPK();

		System.out.println("nexPk is: " + i);
	}

	private static void testadd() throws Exception {

		MarksheetBean bean = new MarksheetBean();

		bean.setRollNo("2");
		bean.setStudentId(102);
		bean.setName("Sakshi");
		bean.setPhysics(15);
		bean.setChemistry(15);
		bean.setMaths(15);
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		MarksheetModel model = new MarksheetModel();
		model.add(bean);
	}

	private static void testFindByPK() throws Exception {

		MarksheetModel model = new MarksheetModel();
		MarksheetBean bean = model.findbyPK(1);

		if (bean != null) {

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getRollNo());
			System.out.print("\t" + bean.getStudentId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.print("\t" + bean.getMaths());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.print("\t" + bean.getModifiedDatetime());
		}
	}
	
	private static void testUpdate() throws Exception {
		
		MarksheetBean bean = new MarksheetBean();
		
		bean.setRollNo("1");
		bean.setStudentId(101);
		bean.setName("Raj");
		bean.setPhysics(80);
		bean.setChemistry(92);
		bean.setMaths(45);
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		MarksheetModel model = new MarksheetModel();
		model.update(bean);
	}
	
	private static void testSearch() throws Exception {
		
		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();
		
        bean.setName("Raj");
		
		List list = model.search(bean);
		
		Iterator it = list.iterator();
		
		while (it.hasNext()) {
			bean= (MarksheetBean)it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getRollNo());
			System.out.print("\t" + bean.getStudentId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.print("\t" + bean.getMaths());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.print("\t" + bean.getModifiedDatetime());
		}
	}
	
	private static void testFindByStudentID() throws Exception {
		
		MarksheetModel model = new MarksheetModel();
		MarksheetBean bean = model.findByStudentID(101);
		
		if(bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getRollNo());
			System.out.print("\t" + bean.getStudentId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.print("\t" + bean.getMaths());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.print("\t" + bean.getModifiedDatetime());
		}
	}
	
	private static void testDelete() throws Exception {
		
		MarksheetModel model = new MarksheetModel();
		model.delete(2);
	}
}