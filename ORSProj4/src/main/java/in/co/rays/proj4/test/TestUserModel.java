package in.co.rays.proj4.test;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.UserBean;
import in.co.rays.proj4.model.UserModel;

public class TestUserModel {

	public static void main(String[] args) throws Exception {

		//testNextPk();
		//testFindByPK();
		testadd();
		//testUpdate();
		//testSearch();
		//testfindbylogin();
		//testDelete();

	}

	private static void testNextPk() {

		UserModel model = new UserModel();

		int i = model.nextPK();

		System.out.println("nexPk is: " + i);
	}

	private static void testFindByPK() throws Exception {

		UserModel model = new UserModel();
		UserBean bean = model.findbypk(1);

		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLogin());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getRoleId());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.print("\t" + bean.getModifiedDatetime());
		}
	}

	private static void testadd() throws Exception {

		UserBean bean = new UserBean();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		bean.setFirstName("Pushpraj");
		bean.setLastName("Kachhaway");
		bean.setLogin("pushpraj0812");
		bean.setPassword("4845");
		bean.setDob(sdf.parse("08/12/2025"));
		bean.setMobileNo("8718948410");
		bean.setRoleId(1);
		bean.setGender("Male");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new java.sql.Timestamp(System.currentTimeMillis()));
		bean.setModifiedDatetime(new java.sql.Timestamp(System.currentTimeMillis()));

		UserModel model = new UserModel();
		model.add(bean);
	}

	private static void testUpdate() throws Exception {

		UserBean bean = new UserBean();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		bean.setId(1);
		bean.setFirstName("Pushpraj");
		bean.setLastName("Kachhaway");
		bean.setLogin("pushpraj0812");
		bean.setPassword("0812");
		bean.setDob(sdf.parse("08/12/2025"));
		bean.setMobileNo("8718948410");
		bean.setRoleId(1);
		bean.setGender("Male");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new java.sql.Timestamp(System.currentTimeMillis()));
		bean.setModifiedDatetime(new java.sql.Timestamp(System.currentTimeMillis()));

		UserModel model = new UserModel();
		model.update(bean);
	}

	private static void testSearch() throws Exception {
		
		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean.setFirstName("Pushpraj");

		List list = model.search(bean);

		Iterator it = list.iterator();
		
		while (it.hasNext()) {
			bean = (UserBean)it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLogin());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getRoleId());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.print("\t" + bean.getModifiedDatetime());
		}
	}
	
	private static void testfindbylogin() throws Exception {
		
		UserModel model = new UserModel();
		UserBean bean = model.findbylogin("pushpraj0812");
		
		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLogin());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getRoleId());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.print("\t" + bean.getModifiedDatetime());
	}
	}
	
private static void testDelete() throws Exception {
		
		UserModel model = new UserModel();
		model.delete(1);
	}
}