package shopServices;

import java.sql.Date;

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
			+ " balance float,"
			+ " Items_id INTEGER foreign key references Items(id), "
			+ " PRIMARY KEY ( id ))";
	


	public static String getInsertIntoShopTable(String shop_name) {
		String INSERT_TABLE_SHOP = "insert into Shop (Shop_Name)VALUES('"+shop_name+"')";
		return INSERT_TABLE_SHOP;
	}

	
	public static String getInsertIntoShopDetailsTable(String tel, String fax, String Email,String website, Integer shop_id) {
		
		String INSERT_TABLE_SHOP = "insert into Shop_Details (Tel, Fax, Email, Website, Shop_id)VALUES(?,?,?,?,?)";
		return INSERT_TABLE_SHOP;
	}
	
public static String getInsertIntoItemsTable(String item_Name, Double price, Integer quantity,Integer Shop_Details_id) {
		
		String INSERT_TABLE_SHOP = "insert into Items (item_Name, price, quantity, Shop_Details_id)VALUES(?,?,?,?)";
		return INSERT_TABLE_SHOP;
	}

public static String getInsertIntoInvoicTable(String customer_full_name, Integer phone_number, Date invoice_date,Integer number_of_items,double total_amount,double  paid_amount,double  balance, Integer Items_id) {
	
	String INSERT_TABLE_SHOP = "insert into Invoice (customer_full_name, phone_number, invoice_date, number_of_items,total_amount, paid_amount,balance, Items_id )VALUES(?,?,?,?,?,?,?,?)";
	return INSERT_TABLE_SHOP;
}

public static String getDeleteItemsById(int itemId) {
	
	String DELETE_TABLE_ITEM = "delete from Items where id ="+itemId;
	return DELETE_TABLE_ITEM;

}
public static String getUpdateItemsPriceById(int itemId, int price) {
	
	String UPDATE_TABLE_ITEM ="update Items set price ="+price+" where id="+itemId;
	return UPDATE_TABLE_ITEM;

}

public static String getReadFromTable() {
	
	String READ_TABLE_ITEM ="SELECT * FROM Items";
	return READ_TABLE_ITEM;

}
public static String getInvoicTable() {
	
	String READ_TABLE_INVOICE ="SELECT * FROM Invoice";
	return READ_TABLE_INVOICE;

}
public static String getInvoicByIdTable(int invoiseId) {
	
	String READ_TABLE_INVOICE ="Select * from Invoice INNER JOIN Items ON Items.id = Invoice.Items_id WHERE Invoice.id ="+invoiseId;
	return READ_TABLE_INVOICE;

}
}
