package shopServices;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class InvoiceDetails {
	 public void createInvoiceTable() {


	        Connection Sectionsconn = null;
	        try {
	        	Scanner scanner = new Scanner(System.in);
	        	System.out.println("Please Enter Database URl");
	        	String inputUserUrl = scanner.next();
	        	System.out.println("Please Enter user Name :");
	        	String inputUserName = scanner.next();
	        	System.out.println("Please Enter user Password :");
	        	String inputUserPass = scanner.next();
	            Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
	                    .newInstance();
	            DriverManager.registerDriver(driver);
	            
	            
                if(inputUserUrl.equals(Constants.USER_URL)&& inputUserName.equals(Constants.USER_NAME) && inputUserPass.equals(Constants.USER_PASSWORD)) {

	            
	            Sectionsconn = DriverManager.getConnection(Constants.USER_URL, Constants.USER_NAME, Constants.USER_PASSWORD);
         Statement st = Sectionsconn.createStatement();
	            int m = st.executeUpdate(SQLQueries.CREATE_TABLE_Invoice);
	            if (m >= 1) {
	                System.out.println("Created Sections table in given database...");

	            } else {
	                System.out.println(" table already Created in given database...");
	            }
	            Sectionsconn.close();
                }
	        } catch (Exception ex) {
	            System.err.println(ex);
	        }




	    }
	 
	
	
	 public void insertIntoShopDetailsTable(int shopNumberToInsert, String Shop_Name){
	        try {
	        	Scanner scanner = new Scanner(System.in);

	        	
	        	
	        	System.out.println("Please Enter Database URl");
	        	String inputUserUrl = scanner.next();
	        	System.out.println("Please Enter user Name :");
	        	String inputUserName = scanner.next();
	        	System.out.println("Please Enter user Password :");
	        	String inputUserPass = scanner.next();
	        		        

	                Connection insertConnection = null;

	                Driver driver = (Driver) Class.forName(Constants.JDBC_DRIVER_SQL_SERVER)
	                        .newInstance();
	                DriverManager.registerDriver(driver);
	                
	                if(inputUserUrl.equals(Constants.USER_URL)&& inputUserName.equals(Constants.USER_NAME) && inputUserPass.equals(Constants.USER_PASSWORD)) {
	                	
	                	
	                insertConnection = DriverManager.getConnection(Constants.USER_URL, Constants.USER_NAME, Constants.USER_PASSWORD);
	                for(int i=0; i<shopNumberToInsert;i++) {
	                	System.out.println("Please Enter customer_full_name :");
	                    String customer_full_name = scanner.next();
	                    System.out.println("Please Enter phone_number :");
	                    Integer phone_number = scanner.nextInt();
	                   Date invoice_date = new Date(System.currentTimeMillis());
	                    System.out.println("Please Enter number_of_items :");
	                    Integer number_of_items = scanner.nextInt();
	                    
	                
	                	String Sql = "Select Shop_Details.id from Shop_Details INNER JOIN Shop On Shop_Details.Shop_id= Shop.id Where Shop.Shop_Name =?"
	                			+ "";
	    	        	

	                     PreparedStatement shopPreparedStatment = insertConnection.prepareStatement(Sql); 
	                     shopPreparedStatment.setString(1, Shop_Name);
	                     int shopId = 0;
	                     
	                     ResultSet shopResultSet = shopPreparedStatment.executeQuery();
	                     if(shopResultSet.next())
	                     {
	                    	 shopId = shopResultSet.getInt("id");
	 	                    System.out.println(shopId);

	                     }
	                     
	                    String insertSerctionTable = SQLQueries.getInsertIntoInvoicTable(customer_full_name, phone_number, invoice_date, number_of_items,shopId);
	                    PreparedStatement stmt=insertConnection.prepareStatement(insertSerctionTable);
                     stmt.setString(1, customer_full_name);
                     stmt.setInt(2, phone_number);
                     stmt.setDate(3, invoice_date);
                     stmt.setInt(5, number_of_items);
                      stmt.executeQuery();
                     
 	                    System.out.println("Inserted Successfuly");

                     
	                
	                }
	                    insertConnection.close();
	                
	                
	            }
	        
	        } catch (Exception ex) {
	            System.err.println(ex);
	        }
	    }
}
