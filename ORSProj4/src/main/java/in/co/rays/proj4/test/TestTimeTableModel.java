package in.co.rays.proj4.test;

import in.co.rays.proj4.model.TimeTableModel;

public class TestTimeTableModel {
	
	public static void main(String[] args) {

		testNextPk();

	}
	private static void testNextPk() {

		TimeTableModel model = new TimeTableModel();

		int i = model.nextPK();

		System.out.println("nexPk is: " + i);
	}
}