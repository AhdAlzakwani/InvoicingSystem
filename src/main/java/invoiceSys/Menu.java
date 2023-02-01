package invoiceSys;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

public class Menu {
	public static void getShowMenu(int option) throws InputMismatchException {

		List<String> showMenu = Arrays.asList("0- Connect to Database", "1- Shop Settings", "2- Manage Shop Items",
				"3- Create New Invoice", "4- Report (No Of Items, No of Invoices, Total Sales)",
				"5- Report: All Invoices  ", "6- Search (1) Invoice ", "7- Program Statistics ", "8- Exit ");
		List<String> showShopMenu = Arrays.asList("0- Create Items Table", "1- Load Data (Items and invoices)",
				"2- Set Shop Name (data should be saved)",
				"3- Set Invoice Header (Tel / Fax / Email / Website) (Data should be saved)", "4- Go Back");

		List<String> showItemMenu = Arrays.asList("0- Create Items Table", "1- Add Items", "2- Delete Items",
				"3- Change Item Price ", "4- Report All Items ", "5- Go Back");

		switch (option) {
		case 1:
			printList(showMenu);
			break;
		case 2:
			printList(showShopMenu);
			break;
		case 3:
			printList(showItemMenu);
			break;
		}
	}

	public static void printList(List<String> listmenu) {
		for (String x : listmenu) {
			System.out.println(x);
		}
	}

}
