package in.co.rays.proj4.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import exception.ApplicationException;

public class JDBCDataSource {
	
	/**
	 * JDBC Database connection pool ( DCP )
	 */

	private JDBCDataSource() { 
	}

	private static JDBCDataSource datasource; //Holds the single object of JDBCDataSource. Only created once and shared everywhere.

	private ComboPooledDataSource cpds = null; //C3P0 class that manages the actual pool of database connections

	/**
	 * Create instance of Connection Pool
	 *
	 * @return
	 */
	public static JDBCDataSource getInstance() {
		if (datasource == null) { // If datasource is null it creates a new JDBCDataSource. Sets up the connection pool (cpds) based on settings from the system.properties file.

			ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.proj4.bundle.system");

			datasource = new JDBCDataSource();
			datasource.cpds = new ComboPooledDataSource();
			try {
				datasource.cpds.setDriverClass(rb.getString("driver"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			datasource.cpds.setJdbcUrl(rb.getString("url"));
			datasource.cpds.setUser(rb.getString("username"));
			datasource.cpds.setPassword(rb.getString("password"));
			datasource.cpds.setInitialPoolSize(Integer.parseInt(rb.getString("initialPoolSize")));
			datasource.cpds.setAcquireIncrement(Integer.parseInt(rb.getString("acquireIncrement")));
			datasource.cpds.setMaxPoolSize(Integer.parseInt(rb.getString("maxPoolSize")));
			datasource.cpds.setMaxIdleTime(Integer.parseInt(rb.getString("timeout")));
			datasource.cpds.setMinPoolSize(Integer.parseInt(rb.getString("minPoolSize")));

		}
		return datasource;
	}

	/**
	 * Gets the connection from ComboPooledDataSource
	 *
	 * @return connection
	 */
	public static Connection getConnection() throws Exception {
		return getInstance().cpds.getConnection();
	}

	/**
	 * Closes a connection
	 *
	 * @param connection
	 * @throws Exception
	 */
	public static void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (Exception e) {
			}
		}
	}

	public static void trnRollback(Connection connection) throws Exception {
		if (connection != null) {
			try {
				connection.rollback();
			} catch (SQLException ex) {
				throw new ApplicationException(ex.toString());
			}
		}
	}
}