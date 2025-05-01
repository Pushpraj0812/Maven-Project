package in.co.rays.proj4.test;

import in.co.rays.proj4.model.UserModel;

public class TestUserModel {
	
	public static void main(String[] args) {

		testNextPk();

	}
	private static void testNextPk() {

		UserModel model = new UserModel();

		int i = model.nextPK();

		System.out.println("nexPk is: " + i);
	}
}