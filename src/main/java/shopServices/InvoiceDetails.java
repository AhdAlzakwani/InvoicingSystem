package shopServices;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	 
	
	
	 public void insertIntoShopDetailsTable(int shopNumberToInsert, String itemName){
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
	                	System.out.println("Please Enter customer First name :");
	                    String customer_first_name = scanner.next();
	                    System.out.println("Please Enter customer Last name :");
	                    String customer_last_name = scanner.next();
	                    String customer_full_name = customer_first_name +""+customer_last_name;
	                    System.out.println("Please Enter phone_number :");
	                    Integer phone_number = scanner.nextInt();
	                    System.out.println("How many you give the Counter  :");
	                    Integer balance = scanner.nextInt();
	                   Date invoice_date = new Date(System.currentTimeMillis());
	                 
	                    
	                
	                    String sqlnumberOfItem = "Select COUNT(*) from Items where item_Name=?";
	                    String sqlTotaleAmount = "Select price*(quantity) from Items where item_Name=?";
	                    String sqlPaidAmount ="Select price From Items where item_Name=?";
	                    String sqlBalance = "Select price From Items where item_Name=?";
	                    String sqlItemId = "Select id From Items where item_Name=?";

	                
	    	        	//Create PreparedStatement For numberOfItem

	                     PreparedStatement numberOfItemPreparedStatment = insertConnection.prepareStatement(sqlnumberOfItem); 
	                     numberOfItemPreparedStatment.setString(1, itemName);
	                     
	                     int count = 0;
	                     
	                     ResultSet numberOfItemResultSet = numberOfItemPreparedStatment.executeQuery();
	                     if(numberOfItemResultSet.next())
	                     {
	                    	 
	                    	 count = numberOfItemResultSet.getInt(1);
	 	                    System.out.println("numberOfItem is :"+count);

	                     }
	                     
	                     
	                   //Create PreparedStatement For totaleAmount
	                     PreparedStatement totaleAmountPreparedStatment = insertConnection.prepareStatement(sqlTotaleAmount); 
	                     totaleAmountPreparedStatment.setString(1, itemName);
	                     
	                     int totaleAmountcount = 0;
	                     
	                     ResultSet totaleAmountResultSet = totaleAmountPreparedStatment.executeQuery();
	                     if(totaleAmountResultSet.next())
	                     {
	                    	 
	                    	 totaleAmountcount = totaleAmountResultSet.getInt(1);
	 	                    System.out.println("totaleAmount is :"+totaleAmountcount);

	                     }
	                     
	                   //Create PreparedStatement For PaidAmount
	                     PreparedStatement paidAmountPreparedStatment = insertConnection.prepareStatement(sqlPaidAmount); 
	                     paidAmountPreparedStatment.setString(1, itemName);
	                     
	                     int paidAmountcount = 0;
	                     
	                     ResultSet paidAmountResultSet = paidAmountPreparedStatment.executeQuery();
	                     if(paidAmountResultSet.next())
	                     {
	                    	 
	                    	 paidAmountcount = paidAmountResultSet.getInt(1);
	 	                    System.out.println("paidAmount is :"+paidAmountcount);

	                     }
	                     
	                     //Create PreparedStatement For Balance
	                     PreparedStatement balancePreparedStatment = insertConnection.prepareStatement(sqlBalance); 
	                     balancePreparedStatment.setString(1, itemName);
	                     
	                     int balancecount = 0;
	                     Integer countBalance = 0;
	                     ResultSet balanceResultSet = balancePreparedStatment.executeQuery();
	                     if(balanceResultSet.next())
	                     {
	                    	 
	                    	 balancecount = balanceResultSet.getInt(1);
	 	                    System.out.println("price is :"+balancecount);
	 	                    countBalance = balance - balancecount;
	 	                    System.out.println("countBalance is :"+countBalance);

	 	                    

	                     }
	                     
	                   //Create PreparedStatement For itemId

	                     PreparedStatement itemIdPreparedStatment = insertConnection.prepareStatement(sqlItemId); 
	                     itemIdPreparedStatment.setString(1, itemName);
	                     
	                     int itemIdcount = 0;
	                     
	                     ResultSet itemIdResultSet = itemIdPreparedStatment.executeQuery();
	                     if(itemIdResultSet.next())
	                     {
	                    	 
	                    	 itemIdcount = itemIdResultSet.getInt("id");
	 	                    System.out.println("itemId is :"+itemIdcount);

	                     }
	                     
	                     
	                     
	                     
	                 String insertSerctionTable = SQLQueries.getInsertIntoInvoicTable(customer_full_name, phone_number, invoice_date, count,totaleAmountcount,paidAmountcount,countBalance, itemIdcount);
	                 PreparedStatement stmt=insertConnection.prepareStatement(insertSerctionTable);
                     stmt.setString(1, customer_full_name);
                     stmt.setInt(2, phone_number);
                     stmt.setDate(3, invoice_date);
                     stmt.setInt(4, count);
                     stmt.setDouble(5, totaleAmountcount);
                     stmt.setDouble(6, paidAmountcount);
                     stmt.setDouble(7, countBalance);
                     stmt.setInt(8, itemIdcount);
                      stmt.executeQuery();
                     
 	                    System.out.println("Inserted Successfuly");

                     
	                
	                }
	                    insertConnection.close();
	                
	                
	            }
	        
	        } catch (Exception ex) {
	            System.err.println(ex);
	        }
	    }
	 
	 public static void readFromTable() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
			Scanner scanner = new Scanner(System.in);

			System.out.println("Please Enter Database URl");
			String inputUserUrl = scanner.next();
			System.out.println("Please Enter user Name :");
			String inputUserName = scanner.next();
			System.out.println("Please Enter user Password :");
			String inputUserPass = scanner.next();
		    Connection conn = null;

			Driver driver = (Driver) Class.forName(Constants.JDBC_DRIVER_SQL_SERVER).newInstance();
			DriverManager.registerDriver(driver);

			String sqlDB = SQLQueries.getInvoicTable();

			try {

				conn = DriverManager.getConnection(Constants.USER_URL, Constants.USER_NAME,
						Constants.USER_PASSWORD);

				Statement st = conn.createStatement();

				ResultSet m = st.executeQuery(sqlDB);

				if (m.next()) {

					do {

						System.out.println("id : " + m.getInt(1));
						System.out.println("Coustomer Full Name : " + m.getString(2));
						System.out.println("Phone Number :" + m.getInt(3));
						System.out.println("Invoice Date :" + m.getDate(4));
						System.out.println("Number Of Item :" + m.getInt(5));
						System.out.println("Totale Amount : " + m.getDouble(6));
						System.out.println("Paid Amount : " + m.getDouble(7));
						System.out.println("Balance : " + m.getDouble(8));
						System.out.println("Item Id :" + m.getInt(9));
						System.out.println("*********************************");
						
						

					} while (m.next());

				} else {
					System.out.println("No such user id is already registered");
				}

				conn.close();
			}
			

			catch (Exception ex) {
				System.err.println(ex);
			}

			
			}
	 public static void readFromInvoiceById(int id) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
			Scanner scanner = new Scanner(System.in);

			System.out.println("Please Enter Database URl");
			String inputUserUrl = scanner.next();
			System.out.println("Please Enter user Name :");
			String inputUserName = scanner.next();
			System.out.println("Please Enter user Password :");
			String inputUserPass = scanner.next();
		    Connection conn = null;

			Driver driver = (Driver) Class.forName(Constants.JDBC_DRIVER_SQL_SERVER).newInstance();
			DriverManager.registerDriver(driver);

			String sqlDB = SQLQueries.getInvoicByIdTable(id);

			try {

				conn = DriverManager.getConnection(Constants.USER_URL, Constants.USER_NAME,
						Constants.USER_PASSWORD);

				Statement st = conn.createStatement();

				ResultSet m = st.executeQuery(sqlDB);

				if (m.next()) {

					do {

						System.out.println("id : " + m.getInt(1));
						System.out.println("Coustomer Full Name : " + m.getString(2));
						System.out.println("Phone Number :" + m.getInt(3));
						System.out.println("Invoice Date :" + m.getDate(4));
						System.out.println("Number Of Item :" + m.getInt(5));
						System.out.println("Totale Amount : " + m.getDouble(6));
						System.out.println("Paid Amount : " + m.getDouble(7));
						System.out.println("Balance : " + m.getDouble(8));
						System.out.println("Item Id :" + m.getInt(9));
						System.out.println("*********************************");
						
						

					} while (m.next());

				} else {
					System.out.println("No such user id is already registered");
				}

				conn.close();
			}
			

			catch (Exception ex) {
				System.err.println(ex);
			}

			
			}
	 
	 public static void reportTable() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
			Scanner scanner = new Scanner(System.in);

			System.out.println("Please Enter Database URl");
			String inputUserUrl = scanner.next();
			System.out.println("Please Enter user Name :");
			String inputUserName = scanner.next();
			System.out.println("Please Enter user Password :");
			String inputUserPass = scanner.next();
		    Connection conn = null;

			Driver driver = (Driver) Class.forName(Constants.JDBC_DRIVER_SQL_SERVER).newInstance();
			DriverManager.registerDriver(driver);

			String sqlDB = "Select COUNT(*) from Items";
			String sqlDB1 = "Select COUNT(*) from Invoice";
			String sqlDB2 = "Select SUM(total_amount)from Invoice";

			try {

				conn = DriverManager.getConnection(Constants.USER_URL, Constants.USER_NAME,
						Constants.USER_PASSWORD);

				Statement st = conn.createStatement();

				ResultSet m = st.executeQuery(sqlDB);

				if (m.next()) {

					do {

						System.out.println("No_Of_Items : " + m.getInt(1));
						System.out.println("*********************************");

					} while (m.next());

				} else {
					System.out.println("No such user id is already registered");
				}
				
				
				ResultSet n = st.executeQuery(sqlDB1);

				if (n.next()) {

					do {

						System.out.println("No_of_Invoices : " + n.getInt(1));
						System.out.println("*********************************");

					} while (n.next());

				} else {
					System.out.println("No such user id is already registered");
				}
				
				ResultSet h = st.executeQuery(sqlDB2);

				if (h.next()) {

					do {

						System.out.println("Total_Sales : " + h.getInt(1));
						System.out.println("*********************************");

					} while (h.next());

				} else {
					System.out.println("No such user id is already registered");
				}
				

				conn.close();
			}
			

			catch (Exception ex) {
				System.err.println(ex);
			}

			
			}
	 
	 
	 
}
