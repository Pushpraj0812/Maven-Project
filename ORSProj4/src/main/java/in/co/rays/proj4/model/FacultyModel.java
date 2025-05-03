package in.co.rays.proj4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.proj4.bean.FacultyBean;
import in.co.rays.proj4.util.JDBCDataSource;

public class FacultyModel {

	public int nextPK() {

		int pk = 0;

		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement("select max(ID) from st_faculty");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				pk = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return pk + 1;
	}

	public FacultyBean findByPK(long id) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select * from st_faculty where id = ?");

		pstmt.setLong(1, id);

		ResultSet rs = pstmt.executeQuery();

		FacultyBean bean = null;

		while (rs.next()) {
			bean = new FacultyBean();
			bean.setId(rs.getLong(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setDob(rs.getDate(4)); // or rs.getTimestamp(4) if needed
			bean.setGender(rs.getString(5));
			bean.setMobileNo(rs.getString(6));
			bean.setEmail(rs.getString(7));
			bean.setCourseId(rs.getLong(8));
			bean.setCollegeName(rs.getString(9));
			bean.setCourseId(rs.getLong(10));
			bean.setSubjectId(rs.getLong(11));
			bean.setSubjectName(rs.getString(12));
			bean.setCreatedBy(rs.getString(13));
			bean.setModifiedBy(rs.getString(14));
			bean.setCreatedDatetime(rs.getTimestamp(15));
			bean.setModifiedDatetime(rs.getTimestamp(16));
		}
		JDBCDataSource.closeConnection(conn);
		return bean;
	}

	public void add(FacultyBean bean) throws Exception {

		Connection conn = null;

		int pk = nextPK();

		try {
			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn
					.prepareStatement("insert into st_faculty values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			pstmt.setInt(1, pk);
			pstmt.setString(2, bean.getFirstName());
			pstmt.setString(3, bean.getLastName());
			pstmt.setDate(4, new java.sql.Date(bean.getDob().getTime()));
			pstmt.setString(5, bean.getGender());
			pstmt.setString(6, bean.getMobileNo());
			pstmt.setString(7, bean.getEmail());
			pstmt.setLong(8, bean.getCollegeId());
			pstmt.setString(9, bean.getCollegeName());
			pstmt.setLong(10, bean.getCourseId());
			pstmt.setLong(11, bean.getSubjectId());
			pstmt.setString(12, bean.getSubjectName());
			pstmt.setString(13, bean.getCreatedBy());
			pstmt.setString(14, bean.getModifiedBy());
			pstmt.setTimestamp(15, bean.getCreatedDatetime());
			pstmt.setTimestamp(16, bean.getModifiedDatetime());

			int i = pstmt.executeUpdate();

			conn.commit();

			JDBCDataSource.closeConnection(conn);

			System.out.println("data inserted => " + i);
		} catch (SQLException e) {
			e.printStackTrace();
			JDBCDataSource.trnRollback(conn);
		}
	}

	public void update(FacultyBean bean) throws Exception {

		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
"update st_faculty set first_name=?, last_name=?, dob=?, gender=?, mobile_no=?, email=?, collage_id=?, collage_name=?, course_id=?, subject_id=?, subject_name=?, created_by=?, modified_by=?, created_datetime=?, modified_datetime=? where id=? ");

			pstmt.setString(1, bean.getFirstName());
			pstmt.setString(2, bean.getLastName());
			pstmt.setDate(3, new java.sql.Date(bean.getDob().getTime()));
			pstmt.setString(4, bean.getGender());
			pstmt.setString(5, bean.getMobileNo());
			pstmt.setString(6, bean.getEmail());
			pstmt.setLong(7, bean.getCollegeId());
			pstmt.setString(8, bean.getCollegeName());
			pstmt.setLong(9, bean.getCourseId());
			pstmt.setLong(10, bean.getSubjectId());
			pstmt.setString(11, bean.getSubjectName());
			pstmt.setString(12, bean.getCreatedBy());
			pstmt.setString(13, bean.getModifiedBy());
			pstmt.setTimestamp(14, bean.getCreatedDatetime());
			pstmt.setTimestamp(15, bean.getModifiedDatetime());
			pstmt.setLong(16, bean.getId());

			int i = pstmt.executeUpdate();

			conn.commit();

			JDBCDataSource.closeConnection(conn);

			System.out.println("data updated => " + i);
		} catch (Exception e) {
			e.printStackTrace();
			JDBCDataSource.trnRollback(conn);
		}
	}

	public List search(FacultyBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		StringBuffer sql = new StringBuffer("select * from st_faculty where 1=1");

		if (bean != null) {

			if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {
				sql.append(" and first_name like '" + bean.getFirstName() + "%'");
			}
		}

		System.out.println("sql ==>> " + sql.toString());

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {
			bean = new FacultyBean();
			bean.setId(rs.getLong(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setDob(rs.getDate(4));
			bean.setGender(rs.getString(5));
			bean.setMobileNo(rs.getString(6));
			bean.setEmail(rs.getString(7));
			bean.setCollegeId(rs.getLong(8));
			bean.setCollegeName(rs.getString(9));
			bean.setCourseId(rs.getLong(10));
			bean.setSubjectId(rs.getLong(11));
			bean.setSubjectName(rs.getString(12));
			bean.setCreatedBy(rs.getString(13));
			bean.setModifiedBy(rs.getString(14));
			bean.setCreatedDatetime(rs.getTimestamp(15));
			bean.setModifiedDatetime(rs.getTimestamp(16));

			list.add(bean);
		}
		JDBCDataSource.closeConnection(conn);
		return list;
	}

	public FacultyBean findByEmail(String email) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select * from st_faculty where email = ?");

		pstmt.setString(1, email);

		ResultSet rs = pstmt.executeQuery();

		FacultyBean bean = null;

		while (rs.next()) {
			bean = new FacultyBean();
			bean.setId(rs.getLong(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setDob(rs.getDate(4));
			bean.setGender(rs.getString(5));
			bean.setMobileNo(rs.getString(6));
			bean.setEmail(rs.getString(7));
			bean.setCollegeId(rs.getLong(8));
			bean.setCollegeName(rs.getString(9));
			bean.setCourseId(rs.getLong(10));
			bean.setSubjectId(rs.getLong(11));
			bean.setSubjectName(rs.getString(12));
			bean.setCreatedBy(rs.getString(13));
			bean.setModifiedBy(rs.getString(14));
			bean.setCreatedDatetime(rs.getTimestamp(15));
			bean.setModifiedDatetime(rs.getTimestamp(16));
		}
		JDBCDataSource.closeConnection(conn);
		return bean;
	}

	public void delete(long id) throws Exception {

		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("delete from st_faculty where id = ?");
			pstmt.setLong(1, id);

			int i = pstmt.executeUpdate();
			conn.commit();

			JDBCDataSource.closeConnection(conn);
			System.out.println("data deleted => " + i);

		} catch (Exception e) {
			JDBCDataSource.trnRollback(conn);
		}
	}
}