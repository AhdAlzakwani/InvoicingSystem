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
			+ " item_Name VARCHAR(5000),"
			+ " price double(5000),"
			+ " Shop_Details_id INTEGER foreign key references Shop_Details(id), "
			+ " PRIMARY KEY ( id ))";

}
