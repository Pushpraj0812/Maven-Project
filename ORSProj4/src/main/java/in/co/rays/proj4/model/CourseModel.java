package in.co.rays.proj4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.proj4.bean.CourseBean;
import in.co.rays.proj4.util.JDBCDataSource;

public class CourseModel {

	public int nextPK() {

		int pk = 0;

		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement("select max(ID) from st_course");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				pk = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return pk + 1;
	}
	
	public CourseBean findbypk(long id) throws Exception {
		
		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select * from st_course where id = ?");

		pstmt.setLong(1, id);

		ResultSet rs = pstmt.executeQuery();
		
		CourseBean bean  = null;
		
		while (rs.next()) {
			bean = new CourseBean();
			bean.setId(rs.getLong(1));
			bean.setName(rs.getString(2));
			bean.setDuration(rs.getString(3)); 
			bean.setDescription(rs.getString(4));
			bean.setCreatedBy(rs.getString(5));
			bean.setModifiedBy(rs.getString(6));
			bean.setCreatedDatetime(rs.getTimestamp(7));
			bean.setModifiedDatetime(rs.getTimestamp(8)); 
		}
		JDBCDataSource.closeConnection(conn);
		return bean;
	}
	
	public void add(CourseBean bean) throws Exception {
		
		Connection conn = null;

		int pk = nextPK();
		
		try {
			conn = JDBCDataSource.getConnection();
			
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("insert into st_course values (?,?,?,?,?,?,?,?)");

			pstmt.setInt(1, pk);
			pstmt.setString(2, bean.getName());
			pstmt.setString(3, bean.getDuration()); 
			pstmt.setString(4, bean.getDescription());
			pstmt.setString(5, bean.getCreatedBy());
			pstmt.setString(6, bean.getModifiedBy());
			pstmt.setTimestamp(7, bean.getCreatedDatetime());
			pstmt.setTimestamp(8, bean.getModifiedDatetime());
			
			int i = pstmt.executeUpdate();

			conn.commit();

			JDBCDataSource.closeConnection(conn);

			System.out.println("data inserted => " + i);
		} catch (Exception e) {
			JDBCDataSource.trnRollback(conn);
		}
	}
	
	public void update(CourseBean bean) throws Exception {
		
		Connection conn = null;
		
		int pk = nextPK();
		
		try {
			conn = JDBCDataSource.getConnection();
			
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
"update st_course set name=?, duration=?, description=?, created_by=?, modified_by=?, created_datetime=?, modified_datetime=? where id =?");
			
			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getDuration()); 
			pstmt.setString(3, bean.getDescription());
			pstmt.setString(4, bean.getCreatedBy());
			pstmt.setString(5, bean.getModifiedBy());
			pstmt.setTimestamp(6, bean.getCreatedDatetime());
			pstmt.setTimestamp(7, bean.getModifiedDatetime());
			pstmt.setLong(8, bean.getId());
			
			int i = pstmt.executeUpdate();

			conn.commit();

			JDBCDataSource.closeConnection(conn);

			System.out.println("data updated => " + i);

		} catch (Exception e) {
			JDBCDataSource.trnRollback(conn);
		}
	}
	
	public List search(CourseBean bean) throws Exception {
		
		Connection conn = JDBCDataSource.getConnection();

		StringBuffer sql = new StringBuffer("select * from st_course where 1=1");

		if (bean != null) {

			if (bean.getName() != null && bean.getName().length() > 0) {
				sql.append(" and first_name like '" + bean.getName() + "%'");
			}
		}

		System.out.println("sql ==>> " + sql.toString());

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();

		List list = new ArrayList();
		
		while (rs.next()) {
			bean = new CourseBean();
			bean.setId(rs.getLong(1));
			bean.setName(rs.getString(2));
			bean.setDuration(rs.getString(3)); 
			bean.setDescription(rs.getString(4));
			bean.setCreatedBy(rs.getString(5));
			bean.setModifiedBy(rs.getString(6));
			bean.setCreatedDatetime(rs.getTimestamp(7));
			bean.setModifiedDatetime(rs.getTimestamp(8)); 
			
			list.add(bean);
		}
		JDBCDataSource.closeConnection(conn);
		return list;
	}
	
    public CourseBean findbyname(String name) throws Exception {
		
		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select * from st_course where name = ?");

		pstmt.setString(1, name);

		ResultSet rs = pstmt.executeQuery();
		
		CourseBean bean = null;
		
		while (rs.next()) {
			bean = new CourseBean();
			bean.setId(rs.getLong(1));
			bean.setName(rs.getString(2));
			bean.setDuration(rs.getString(3)); 
			bean.setDescription(rs.getString(4));
			bean.setCreatedBy(rs.getString(5));
			bean.setModifiedBy(rs.getString(6));
			bean.setCreatedDatetime(rs.getTimestamp(7));
			bean.setModifiedDatetime(rs.getTimestamp(8)); 
		}
		
		JDBCDataSource.closeConnection(conn);
		return bean;
	}
    
    public void delete(long id) throws Exception {

		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("delete from st_course where id = ?");
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