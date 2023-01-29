package shopServices;

import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;


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

	            int m = st.executeUpdate(SQLQueries.CREATE_TABLE_SHOP);
	            if (m >= 1) {
	                System.out.println("Created Shop table in given database...");

	            } else {
	                System.out.println(" table Shop already Created in given database...");
	            }
	            Sectionsconn.close();
                }
	        } catch (Exception ex) {
	            System.err.println(ex);
	        }




	    }
	   public void createShopDetailsTable() {


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

	            int m = st.executeUpdate(SQLQueries.CREATE_TABLE_SHOP_DETAILS);
	            if (m >= 1) {
	                System.out.println("Created Shop Details table in given database...");

	            } else {
	                System.out.println(" table Shop Details already Created in given database...");
	            }
	            Sectionsconn.close();
                }
	        } catch (Exception ex) {
	            System.err.println(ex);
	        }




	    }



	   public void insertIntoShopTable(int shopNumberToInsert){
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
	                System.out.println("Please Enter Shop Name To be Insert :");
		        	String shop_name = scanner.next();

	                    String insertSerctionTable = SQLQueries.getInsertIntoShopTable(shop_name);

	                    Statement st = insertConnection.createStatement();

	                    int m = st.executeUpdate(insertSerctionTable);
	                    if (m >= 1) {
	                        System.out.println("Date Inserted in given database...");

	                    } else {
	                        System.out.println(" Date Inserted already Created in given database...");
	                    }
	                }
	                    insertConnection.close();
	                
	                
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
	                	System.out.println("Please Enter Tel :");
	                    String tel = scanner.next();
	                    System.out.println("Please Enter Fax :");
	                    String fax = scanner.next();
	                    System.out.println("Please Enter Email :");
	                    String email = scanner.next();
	                    System.out.println("Please Enter Website :");
	                    String website = scanner.next();
	                
	                	String Sql = "SELECT id FROM Shop Where Shop_Name=?";
	    	        	

	                     PreparedStatement shopPreparedStatment = insertConnection.prepareStatement(Sql); 
	                     shopPreparedStatment.setString(1, Shop_Name);
	                     int shopId = 0;
	                     
	                     ResultSet shopResultSet = shopPreparedStatment.executeQuery();
	                     if(shopResultSet.next())
	                     {
	                    	 shopId = shopResultSet.getInt("id");
	 	                    System.out.println(shopId);

	                     }
	                     
	                    String insertSerctionTable = SQLQueries.getInsertIntoShopDetailsTable(tel, fax, email, website,shopId);
	                    PreparedStatement stmt=insertConnection.prepareStatement(insertSerctionTable);
                        stmt.setString(1, tel);
                        stmt.setString(2, fax);
                        stmt.setString(3, fax);
                        stmt.setString(4, website);
                        stmt.setInt(5, shopId);
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
