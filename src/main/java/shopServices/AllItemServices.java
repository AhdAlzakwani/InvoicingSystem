package shopServices;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AllItemServices {


	public void createItemTable(String USER_URL ,String USER_NAME,String USER_PASSWORD) {
		Scanner scanner = new Scanner(System.in);
		

		Connection Sectionsconn = null;
		try {

			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);
			

				Sectionsconn = DriverManager.getConnection(Constants.USER_URL, Constants.USER_NAME,
						Constants.USER_PASSWORD);
				Statement st = Sectionsconn.createStatement();
				int m = st.executeUpdate(SQLQueries.CREATE_TABLE_Items);
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

	public void insertIntoItemTable(String Shop_Name,String USER_URL ,String USER_NAME,String USER_PASSWORD) {
		try {
			Scanner scanner = new Scanner(System.in);


			Connection insertConnection = null;

			Driver driver = (Driver) Class.forName(Constants.JDBC_DRIVER_SQL_SERVER).newInstance();
			DriverManager.registerDriver(driver);

		

				insertConnection = DriverManager.getConnection(Constants.USER_URL, Constants.USER_NAME,
						Constants.USER_PASSWORD);
			
					System.out.println("Please Enter Item Name :");
					String item_name = scanner.next();
					System.out.println("Please Enter Price :");
					Double price = scanner.nextDouble();
					System.out.println("Please Enter quantity :");
					Integer quantity = scanner.nextInt();

					String Sql = "Select Shop_Details.id from Shop_Details INNER JOIN Shop On Shop_Details.Shop_id= Shop.id Where Shop.Shop_Name =?";

					PreparedStatement shopPreparedStatment = insertConnection.prepareStatement(Sql);
					shopPreparedStatment.setString(1, Shop_Name);
					int shopId = 0;

					ResultSet shopResultSet = shopPreparedStatment.executeQuery();
					if (shopResultSet.next()) {
						shopId = shopResultSet.getInt("id");
						System.out.println(shopId);

					}

					String insertSerctionTable = SQLQueries.getInsertIntoItemsTable(item_name, price, quantity, shopId);
					PreparedStatement stmt = insertConnection.prepareStatement(insertSerctionTable);
					stmt.setString(1, item_name);
					stmt.setDouble(2, price);;
					stmt.setInt(3, quantity);
					stmt.setInt(4, shopId);
					stmt.executeQuery();

					System.out.println("Inserted Successfuly");

				
				insertConnection.close();

			

		} catch (Exception ex) {
			System.err.println(ex);
		}
	}
	
	
	public static void deleteItemsById(int itemId,String USER_URL ,String USER_NAME,String USER_PASSWORD) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Scanner scanner = new Scanner(System.in);

	
		Connection conn = null;
		
		Driver driver = (Driver) Class.forName(Constants.JDBC_DRIVER_SQL_SERVER).newInstance();
		DriverManager.registerDriver(driver);

	
		
		String sqlDB = SQLQueries.getDeleteItemsById(itemId);
	
		
		conn = DriverManager.getConnection(Constants.USER_URL, Constants.USER_NAME,
				Constants.USER_PASSWORD);

		Statement st = conn.createStatement();

		int m = st.executeUpdate(sqlDB);

		if (m >= 1) {
			System.out.println("Row Deleted in given Table...");

		} else {
			System.out.println(" Row already Deleted in given database...");
		}
		
		conn.close();
		
	}	
	
	public static void updateItemsPriceById(int id, int price,String USER_URL ,String USER_NAME,String USER_PASSWORD) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		Scanner scanner = new Scanner(System.in);

	    Connection conn = null;

		Driver driver = (Driver) Class.forName(Constants.JDBC_DRIVER_SQL_SERVER).newInstance();
		DriverManager.registerDriver(driver);

		
	try {
		
	    String sqlDBss = SQLQueries.getUpdateItemsPriceById(id, price);

		
		conn = DriverManager.getConnection(Constants.USER_URL, Constants.USER_NAME,
				Constants.USER_PASSWORD);

		Statement st = conn.createStatement();

		int m = st.executeUpdate(sqlDBss);

		if (m >= 1) {
			System.out.println("Values updated in given Table...");

		} else {
			System.out.println(" Values already updated in given database...");
		}

		conn.close();
		  

	} catch (Exception ex) {
		System.err.println(ex);
	}
		

	}
	
	public static void readFromTable(String USER_URL ,String USER_NAME,String USER_PASSWORD) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		Scanner scanner = new Scanner(System.in);

	    Connection conn = null;

		Driver driver = (Driver) Class.forName(Constants.JDBC_DRIVER_SQL_SERVER).newInstance();
		DriverManager.registerDriver(driver);

		String sqlDB = SQLQueries.getReadFromTable();

		try {

			conn = DriverManager.getConnection(Constants.USER_URL, Constants.USER_NAME,
					Constants.USER_PASSWORD);

			Statement st = conn.createStatement();

			ResultSet m = st.executeQuery(sqlDB);

			if (m.next()) {

				do {

					System.out.println("id : " + m.getInt(1));
					System.out.println("Item Name : " + m.getString(2));
					System.out.println("Price : " + m.getDouble(3));
					System.out.println("quantity :" + m.getInt(3));
					System.out.println("Shoup Details Id :" + m.getInt(4));
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
	
	
}
		
