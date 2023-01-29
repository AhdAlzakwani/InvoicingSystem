package shopServices;

public class SQLQueries {
	public static String CREATE_TABLE_SHOP = "CREATE TABLE Shop " + "(id INTEGER Identity(1,1), "
			+ " Shop_Name VARCHAR(5000),"
			+ " PRIMARY KEY ( id ))";
	
	
	
	public static String CREATE_TABLE_SHOP_DETAILS = "CREATE TABLE Shop_Details " + "(id INTEGER Identity(1,1), "
			+ " Tel Text,"
			+"Fax Text, "
			+"Email Text,"
			+"Website Text,"
			+ " Shop_id INTEGER foreign key references Shop(id), "
		    + " PRIMARY KEY ( id ))";
	
	
	
	public static String CREATE_TABLE_Items = "CREATE TABLE Items " + "(id INTEGER Identity(1,1), "
			+ " item_Name VARCHAR(50),"
			+ " price float,"
			+ " quantity INTEGER,"
			+ " Shop_Details_id INTEGER foreign key references Shop_Details(id), "
			+ " PRIMARY KEY ( id ))";
	
	public static String CREATE_TABLE_Invoice = "CREATE TABLE Invoice " + "(id INTEGER Identity(1,1), "
			+ " customer_full_name VARCHAR(500),"
			+ " phone_number INTEGER,"
			+ " invoice_date date,"
			+ " number_of_items INTEGER,"
			+ " total_amount float,"
			+ " paid_amount float,"
			+ " Items_id INTEGER foreign key references Items(id), "
			+ " PRIMARY KEY ( id ))";
	


	public static String getInsertIntoSectionTable(String shop_name) {
		String INSERT_TABLE_SHOP = "insert into Shop (Shop_Name)VALUES('"+shop_name+"')";
		return INSERT_TABLE_SHOP;
	}

}
