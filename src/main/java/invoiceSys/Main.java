package invoiceSys;

import java.sql.SQLException;
import java.util.Scanner;

import shopServices.AllItemServices;
import shopServices.AllShopServices;
import shopServices.InvoiceDetails;

public class Main {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

		Scanner scannerMenu = new Scanner(System.in);
		AllShopServices allShopServices = new AllShopServices();
		AllItemServices allItemServices = new AllItemServices();
		InvoiceDetails details = new InvoiceDetails();

		boolean exitFlagMainMenu = true;
		boolean exitFlagShopSittingMenu = true;
		boolean exitFlagShopItemSittingMenu = true;
		
		
		while (exitFlagMainMenu) {

			for (String x : Menu.getMenuArray()) {
				System.out.println(x);
			}
			System.out.println("************************");
			System.out.println("Select Only One Option :");
			System.out.println("************************");

			Integer optionForMainMenu = scannerMenu.nextInt();
			switch (optionForMainMenu) {
			
			case 1:
				while (exitFlagShopSittingMenu) {

					for (String x : AllShopServices.getShopSettings()) {
						System.out.println(x);
					}
					System.out.println("WELCOME TO SHOP SITTING");
					System.out.println("************************");
					System.out.println("Select Only One Option :");
					System.out.println("************************");
					Integer optionForShopItemSittingMenu = scannerMenu.nextInt();
					switch (optionForShopItemSittingMenu) {
					case 0:
						allShopServices.createShopTable();
						allShopServices.createShopDetailsTable();
						break;
					case 1:
						System.out.println("Do you want to insert Items? If yes, press 1 , if you want to insert invoices, then press 2");
						Integer InsertOption = scannerMenu.nextInt();
						if(InsertOption == 1)
						{
							
							System.out.println("Please Enter Shop_Name :");
		                    String shop_name = scannerMenu.next();
							allItemServices.insertIntoItemTable(shop_name);
						}
						else if(InsertOption == 2)
						{
							System.out.println("How many Invoice You want to Insert ?");
							Integer InvoiceNumberToInsert = scannerMenu.nextInt();
							System.out.println("Please Enter Item Name :");
		                    String Item_Name = scannerMenu.next();
							details.insertIntoShopDetailsTable(InvoiceNumberToInsert, Item_Name);
							
						}
						else {
							System.out.println("Only 1 Or 2");

						}

						break;
					case 2:
						System.out.println("How many Shop You want to Insert ?");
						Integer shopNumberToInsert = scannerMenu.nextInt();
						allShopServices.insertIntoShopTable(shopNumberToInsert);
						

						break;
					case 3:
						System.out.println("How many Shop You want to Insert ?");
						Integer shopDetailsNumberToInsert = scannerMenu.nextInt();
						System.out.println("Please Enter Shop_Name :");
	                    String shop_name = scannerMenu.next();
						allShopServices.insertIntoShopDetailsTable(shopDetailsNumberToInsert,shop_name);
						
						break;
					case 4:
						exitFlagMainMenu = true;
						exitFlagShopSittingMenu = false;
						break;

					}

				}
				exitFlagShopSittingMenu = false;

				break;
			case 2:
				while (exitFlagShopItemSittingMenu) {

					for (String x : allItemServices.getShopItemSettings()) {
						System.out.println(x);
					}
					System.out.println("WELCOME TO SHOP ITEM SITTING");
					System.out.println("************************");
					System.out.println("Select Only One Option :");
					System.out.println("************************");
					Integer optionForShopSittingMenu = scannerMenu.nextInt();
					switch (optionForShopSittingMenu) {
					case 0:
						allItemServices.createItemTable();
						break;
					case 1:
						
						System.out.println("Please Enter Shop_Name :");
	                    String shop_name = scannerMenu.next();
						allItemServices.insertIntoItemTable(shop_name);

						break;
					case 2:
						System.out.println(" Enter id to be deleted ?");
						  int id = scannerMenu.nextInt();
						  AllItemServices.deleteItemsById(id);
						break;
					case 3:
						System.out.println(" Enter id to be Update ?");
						  int itemId = scannerMenu.nextInt();
						  System.out.println(" Enter price to be Update ?");
						  int itemprice = scannerMenu.nextInt();
						  AllItemServices.updateItemsPriceById(itemId,itemprice);

						break;
					case 4:
						allItemServices.readFromTable();

						break;
					case 5:
						exitFlagMainMenu = true;
						exitFlagShopItemSittingMenu = false;
						break;

					}

				}
				exitFlagShopItemSittingMenu = false;

				break;
			case 3:
				details.createInvoiceTable();

				break;
			case 4:

				break;
			case 5:
				details.readFromTable();

				break;
			case 6:
				System.out.println(" Enter id to be Selected ?");
				  int invoiceId = scannerMenu.nextInt();
				  details.readFromInvoiceById(invoiceId);

				break;
			case 7:

				break;
			case 8:
				System.out.println("Are you sure you want to exit? If yes, program ends, if No , then main menu reprinted again");
				String optionFlagMainMenu = scannerMenu.next();
				if(optionFlagMainMenu.equals("yes"))
				{
					System.out.println("**** THANK YOU ****");

					exitFlagMainMenu = false;
					 exitFlagShopSittingMenu = false;
					 exitFlagShopItemSittingMenu = false;
					
				}
				else if(optionFlagMainMenu.equals("No"))
				{
					exitFlagMainMenu = true;
				}
			


				break;
			}

		}
		exitFlagMainMenu = false;
	}

}
