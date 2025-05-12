package in.co.rays.proj4.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.CollegeBean;
import in.co.rays.proj4.bean.RoleBean;
import in.co.rays.proj4.model.CollegeModel;
import in.co.rays.proj4.model.RoleModel;

public class TestCollageModel {
	
	public static void main(String[] args) throws Exception {

		//testNextPk();
		//testadd();
		//testUpdate();
		//testFindByName();
		testSearch();
		//testFindByPK();
		//testDelete();

	}
	private static void testNextPk() {

		CollegeModel model = new CollegeModel();

		int i = model.nextPK();

		System.out.println("nexPk is: " + i);
	}
	
	private static void testadd() throws Exception {
		
		CollegeBean bean = new CollegeBean();
		
		bean.setName("Rays");
		bean.setAddress("Jaora Copound");
		bean.setState("MP");
		bean.setCity("Indore");
		bean.setPhone_no("8718948410");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		
		CollegeModel model = new CollegeModel();
		model.add(bean);
	}
	
	private static void testUpdate() throws Exception {

		CollegeBean bean = new CollegeBean();
		bean.setId(1);
		bean.setName("Rays");
		bean.setAddress("Pipliyhana");
		bean.setState("MP");
		bean.setCity("Indore");
		bean.setPhone_no("8718948410");
		bean.setCreatedBy("admin@gmail.com");
		bean.setModifiedBy("admin@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		CollegeModel model = new CollegeModel();
		model.update(bean);
	}
	
	private static void testFindByName() throws Exception {
		
		CollegeModel model = new CollegeModel();
		CollegeBean bean = model.findByName("Pushpraj");
		
		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getAddress());
			System.out.print("\t" + bean.getState());
			System.out.print("\t" + bean.getCity());
			System.out.print("\t" + bean.getPhone_no());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.print("\t" + bean.getModifiedDatetime());
		}
	}
	
	private static void testSearch() throws Exception {

		CollegeBean bean = new CollegeBean();

		CollegeModel model = new CollegeModel();

		List list = model.search(bean, 1,5);

		Iterator it = list.iterator();

		while (it.hasNext()) {
			bean = (CollegeBean) it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getAddress());
			System.out.print("\t" + bean.getState());
			System.out.print("\t" + bean.getCity());
			System.out.print("\t" + bean.getPhone_no());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		}
	}
	
	private static void testFindByPK() throws Exception {
		
		CollegeModel model = new CollegeModel();
		CollegeBean bean = model.findByPk(1);
		
		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getAddress());
			System.out.print("\t" + bean.getState());
			System.out.print("\t" + bean.getCity());
			System.out.print("\t" + bean.getPhone_no());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.print("\t" + bean.getModifiedDatetime());
		}
	}
	
	public static void testDelete() throws Exception {
		CollegeModel model = new CollegeModel();
		model.delete(1);
	}
}