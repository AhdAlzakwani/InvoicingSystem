package shopServices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Constants {
	    public static String REQUEST_METHOD_GET = "GET";
	    public static String USER_URL = "jdbc:sqlserver://localhost:1433;databaseName=InvoicingsystemDB;encrypt=true;trustServerCertificate=true";
	    public static String USER_NAME = "sa";
	    public static String USER_PASSWORD = "root";
	    public static String JDBC_DRIVER_SQL_SERVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	    
	    public static Connection getDatabaseConnection(String USER_URL ,String USER_NAME,String USER_PASSWORD) throws SQLException {
	    	Connection con = DriverManager.getConnection(Constants.USER_URL, Constants.USER_NAME, Constants.USER_PASSWORD);
			return con;
	    	
	    }
}
