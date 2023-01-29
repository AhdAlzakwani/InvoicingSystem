package shopServices;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

public class AllShopServices {
	   public static List<String> getShopSettings() {


	        return Arrays.asList("0- Create Shop Tables",
	        		"1- Load Data (Items and invoices)",
	                "2- Set Shop Name",
	                "3- Set Invoice Header (Tel / Fax / Email / Website) ",
	                "4- Go Back"
	        );

	    }
	   
	   public void createShopTable() {


	        Connection Sectionsconn = null;
	        try {

	            Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
	                    .newInstance();
	            DriverManager.registerDriver(driver);
	            Sectionsconn = DriverManager.getConnection(Constants.USER_URL, Constants.USER_NAME, Constants.USER_PASSWORD);

	            Statement st = Sectionsconn.createStatement();

	            int m = st.executeUpdate(SQLQueries.CREATE_TABLE_SHOP);
	            if (m >= 1) {
	                System.out.println("Created Shop table in given database...");

	            } else {
	                System.out.println(" table Shop already Created in given database...");
	            }
	            Sectionsconn.close();
	        } catch (Exception ex) {
	            System.err.println(ex);
	        }




	    }
	   public void createShopDetailsTable() {


	        Connection Sectionsconn = null;
	        try {

	            Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
	                    .newInstance();
	            DriverManager.registerDriver(driver);
	            Sectionsconn = DriverManager.getConnection(Constants.USER_URL, Constants.USER_NAME, Constants.USER_PASSWORD);

	            Statement st = Sectionsconn.createStatement();

	            int m = st.executeUpdate(SQLQueries.CREATE_TABLE_SHOP_DETAILS);
	            if (m >= 1) {
	                System.out.println("Created Shop Details table in given database...");

	            } else {
	                System.out.println(" table Shop Details already Created in given database...");
	            }
	            Sectionsconn.close();
	        } catch (Exception ex) {
	            System.err.println(ex);
	        }




	    }


}
