package shopServices;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

public class InvoiceDetails {
	 public void createInvoiceTable() {


	        Connection Sectionsconn = null;
	        try {

	            Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
	                    .newInstance();
	            DriverManager.registerDriver(driver);
	            
	            
	            
	            
	            Sectionsconn = DriverManager.getConnection(Constants.USER_URL, Constants.USER_NAME, Constants.USER_PASSWORD);
         Statement st = Sectionsconn.createStatement();
	            int m = st.executeUpdate(SQLQueries.CREATE_TABLE_Invoice);
	            if (m >= 1) {
	                System.out.println("Created Sections table in given database...");

	            } else {
	                System.out.println(" table already Created in given database...");
	            }
	            Sectionsconn.close();
	        } catch (Exception ex) {
	            System.err.println(ex);
	        }




	    }
	 
	
	

}
