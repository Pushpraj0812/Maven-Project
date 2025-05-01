package in.co.rays.proj4.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.co.rays.proj4.bean.StudentBean;
import in.co.rays.proj4.util.JDBCDataSource;

public class StudentModel {

	public int nextPK() {

		int pk = 0;

		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement("select max(ID) from st_student");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				pk = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return pk + 1;
	}
	
	public void add (StudentBean bean) throws Exception {
		
		Connection conn = null;
		
		int pk = nextPK();

		try {
			
			conn = JDBCDataSource.getConnection();
			
			conn.setAutoCommit(false);
			
			PreparedStatement pstmt = conn.prepareStatement("insert into st_student values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			pstmt.setInt(1, pk);
			pstmt.setString(2, bean.getFirstName());
			pstmt.setString(3, bean.getLastName());
			pstmt.setDate(4, new java.sql.Date(bean.getDob().getTime()));
			pstmt.setString(5, bean.getGender());
			pstmt.setString(6, bean.getMobileNo());
			pstmt.setString(7, bean.getEmail());
			pstmt.setLong(8, bean.getCollageID());
			pstmt.setString(9, bean.getCollageName());
			pstmt.setString(7, bean.getCreatedBy());
			pstmt.setString(8, bean.getModifiedBy());
			pstmt.setTimestamp(9, bean.getCreatedDatetime());
			pstmt.setTimestamp(10, bean.getModifiedDatetime());
			
			int i = pstmt.executeUpdate();

			conn.commit();

			JDBCDataSource.closeConnection(conn);

			System.out.println("data inserted => " + i);
		} catch (SQLException e) {
			JDBCDataSource.trnRollback(conn);
		}
	}
	
	
}