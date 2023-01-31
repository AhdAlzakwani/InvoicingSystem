package invoiceSys;

import java.util.Arrays;
import java.util.List;

public class Menu {
	   public static List<String> getMenuArray() {


	        return Arrays.asList("0- Connect to Database",
	        		"1- Shop Settings",
	                "2- Manage Shop Items",
	                "3- Create New Invoice",
	                "4- Report (No Of Items, No of Invoices, Total Sales)",
	                "5- Report: All Invoices  ",
	                "6- Search (1) Invoice ",
	                "7- Program Statistics ",
	                "8- Exit "
	        );

	    }
	   
	   public static List<String> getShopSettings() {

			return Arrays.asList("0- Create Items Table",
					"1- Add Items",
					"2- Delete Items",
					"3- Change Item Price ",
					"4- Report All Items ", "5- Go Back");

		}
	   
		public static List<String> getShopItemSettings() {

			return Arrays.asList("0- Create Items Table",
					"1- Add Items",
					"2- Delete Items",
					"3- Change Item Price ",
					"4- Report All Items ", "5- Go Back");

		}
	

}
