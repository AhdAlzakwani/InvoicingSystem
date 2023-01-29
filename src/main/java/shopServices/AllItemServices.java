package shopServices;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;


public class AllItemServices {
	 public static List<String> getShopItemSettings() {


	        return Arrays.asList("Create Items Table",
	        		"1- Add Items",
	                "2- Delete Items",
	                "3- Change Item Price ",
	                "4- Report All Items ",
	                "5- Go Back"
	        );

	    }
	 
//	    public void createItemTable() {
//
//
//	        Connection Sectionsconn = null;
//	        try {
//
//	            Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
//	                    .newInstance();
//	            DriverManager.registerDriver(driver);
//	            Sectionsconn = DriverManager.getConnection(Constants.USER_URL, Constants.USER_NAME, Constants.USER_PASSWORD);
//
//	            Statement st = Sectionsconn.createStatement();
//
//	            int m = st.executeUpdate(SQLQueries.CREATE_TABLE_SECTIONS);
//	            if (m >= 1) {
//	                System.out.println("Created Sections table in given database...");
//
//	            } else {
//	                System.out.println(" table already Created in given database...");
//	            }
//	            Sectionsconn.close();
//	        } catch (Exception ex) {
//	            System.err.println(ex);
//	        }
//
//
//
//
//	    }
	 
	 
	 
	 
	 
	 
}
