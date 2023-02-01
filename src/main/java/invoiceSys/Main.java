package invoiceSys;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.Popup;

import shopServices.AllItemServices;
import shopServices.AllShopServices;
import shopServices.Constants;
import shopServices.InvoiceDetails;

public class Main {
	public static HashMap<String, Integer> countMenuSelected(String caseName, Integer count) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		map.put(caseName, count);
		count = count++;
		return map;
	}

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

		Scanner scannerMenu = new Scanner(System.in);
		AllShopServices allShopServices = new AllShopServices();
		AllItemServices allItemServices = new AllItemServices();
		InvoiceDetails details = new InvoiceDetails();
		String caseName = "";
		Integer count = 1;
		boolean exitFlagMainMenu = true;
		boolean exitFlagShopSittingMenu = true;
		boolean exitFlagShopItemSittingMenu = true;
		boolean connectionExit = true;
		String urlConnection = null;
		String userName = null;
		String userPassword = null;
		while (connectionExit) {
			try {
				System.out.println("Enter Url Connection:");
				urlConnection = scannerMenu.next();
			} catch (InputMismatchException Exception) {
				System.out.println("Wroong Input !!!! You Should Use Only String Input");

			}

			try {
				System.out.println("Enter User NAme: ");
				userName = scannerMenu.next();
			} catch (InputMismatchException Exception) {
				System.out.println("Wroong Input !!!! You Should Use Only String Input");

			}

			try {
				System.out.println("Enter User Password: ");
				userPassword = scannerMenu.next();
			} catch (InputMismatchException Exception) {
				System.out.println("Wroong Input !!!! You Should Use Only String Input");

			}

			if (urlConnection.equals(Constants.USER_URL) && userName.equals(Constants.USER_NAME)
					&& userPassword.equals(Constants.USER_PASSWORD)) {
				while (exitFlagMainMenu) {

					Menu.getShowMenu(1);
					System.out.println("************************");
					System.out.println("Select Only One Option :");
					System.out.println("************************");
					Integer optionForMainMenu = 0;
					try {
						optionForMainMenu = scannerMenu.nextInt();
					} catch (InputMismatchException Exception) {
						System.out.println("Wroong Input !!!! You Should Use Only String Input" + Exception);

					}
					String soptionForMainMenu = String.valueOf(optionForMainMenu);
					switch (optionForMainMenu) {
					case 0:
						 caseName = "Connect to Database";
						 count = 1;
						countMenuSelected(caseName,count);
						Constants.getDatabaseConnection(userName, soptionForMainMenu, userPassword);
						break;
					case 1:
						 caseName = "Shop Settings";
						 count = 1;
						countMenuSelected(caseName,count);
						while (exitFlagShopSittingMenu) {

							Menu.getShowMenu(2);
							System.out.println("WELCOME TO SHOP SITTING");
							System.out.println("************************");
							System.out.println("Select Only One Option :");
							System.out.println("************************");
							Integer optionForShopItemSittingMenu = 0;
							try {
								optionForShopItemSittingMenu = scannerMenu.nextInt();
							} catch (InputMismatchException Exception) {
								System.out.println("Wroong Input !!!! You Should Use Only String Input" + Exception);

							}

							String soptionForShopItemSittingMenu = String.valueOf(optionForShopItemSittingMenu);
							switch (optionForShopItemSittingMenu) {
							case 0:
								allShopServices.createShopTable(Constants.USER_URL, Constants.USER_NAME,
										Constants.USER_PASSWORD);
								allShopServices.createShopDetailsTable(Constants.USER_URL, Constants.USER_NAME,
										Constants.USER_PASSWORD);
								break;
							case 1:
								 
								 caseName = "Load Data (Items and invoices)";
								 count = 1;
								countMenuSelected(caseName,count);
								Integer InsertOption = 0;
								System.out.println(
										"Do you want to insert Items? If yes, press 1 , if you want to insert invoices, then press 2");

								try {
									InsertOption = scannerMenu.nextInt();
								} catch (InputMismatchException Exception) {
									System.out
											.println("Wroong Input !!!! You Should Use Only Integer Input" + Exception);

								}
								String sInsertOption = String.valueOf(InsertOption);
								if (InsertOption == 1) {

									System.out.println("Please Enter Shop_Name :");
									String shop_name = "";
									try {
										shop_name = scannerMenu.next();
									} catch (InputMismatchException Exception) {
										System.out.println(
												"Wroong Input !!!! You Should Use Only String Input" + Exception);

									}
									allItemServices.insertIntoItemTable(shop_name, Constants.USER_URL,
											Constants.USER_NAME, Constants.USER_PASSWORD);
								} else if (InsertOption == 2) {
									System.out.println("How many Invoice You want to Insert ?");
									Integer InvoiceNumberToInsert = 0;
									try {
										InvoiceNumberToInsert = scannerMenu.nextInt();
									} catch (InputMismatchException Exception) {
										System.out.println(
												"Wroong Input !!!! You Should Use Only Integer Input" + Exception);

									}
									String sInvoiceNumberToInsert = String.valueOf(InvoiceNumberToInsert);
									System.out.println("Please Enter Item Name :");
									String Item_Name = "";
									try {
										Item_Name = scannerMenu.next();
									} catch (InputMismatchException Exception) {
										System.out.println(
												"Wroong Input !!!! You Should Use Only String Input" + Exception);

									}
									details.insertIntoShopDetailsTable(InvoiceNumberToInsert, Item_Name,
											Constants.USER_URL, Constants.USER_NAME, Constants.USER_PASSWORD);

								} else {
									System.out.println("Only 1 Or 2");

								}

								break;
							case 2:
								 caseName = "Set Shop Name (data should be saved)";
								 count = 1;
								countMenuSelected(caseName,count);
								System.out.println("How many Shop You want to Insert ?");
								Integer shopNumberToInsert = 0;
								try {
									shopNumberToInsert = scannerMenu.nextInt();
								} catch (InputMismatchException Exception) {
									System.out
											.println("Wroong Input !!!! You Should Use Only Integer Input" + Exception);

								}
								String sshopNumberToInsert = String.valueOf(shopNumberToInsert);

								allShopServices.insertIntoShopTable(shopNumberToInsert, Constants.USER_URL,
										Constants.USER_NAME, Constants.USER_PASSWORD);

								break;
							case 3:
								caseName = "Set Invoice Header (Tel / Fax / Email / Website) (Data should be saved)";
								 count = 1;
								countMenuSelected(caseName,count);
								System.out.println("How many Shop You want to Insert ?");
								Integer shopDetailsNumberToInsert = 0;
								try {
									shopDetailsNumberToInsert = scannerMenu.nextInt();
								} catch (InputMismatchException Exception) {
									System.out
											.println("Wroong Input !!!! You Should Use Only Integer Input" + Exception);

								}
								String sshopDetailsNumberToInsert = String.valueOf(shopDetailsNumberToInsert);

								System.out.println("Please Enter Shop_Name :");
								String shop_name = "";
								try {
									shop_name = scannerMenu.next();

								} catch (InputMismatchException Exception) {
									System.out
											.println("Wroong Input !!!! You Should Use Only String Input" + Exception);

								}
								allShopServices.insertIntoShopDetailsTable(shopDetailsNumberToInsert, shop_name,
										Constants.USER_URL, Constants.USER_NAME, Constants.USER_PASSWORD);

								break;
							case 4:
								caseName = "Go Back";
								countMenuSelected(caseName,count);
								exitFlagMainMenu = true;
								exitFlagShopSittingMenu = false;
								break;

							}

						}
						exitFlagShopSittingMenu = false;

						break;
					case 2:
						caseName = "Manage Shop Items";
						 count = 1;
						countMenuSelected(caseName,count);
						while (exitFlagShopItemSittingMenu) {

							Menu.getShowMenu(3);
							System.out.println("WELCOME TO SHOP ITEM SITTING");
							System.out.println("************************");
							System.out.println("Select Only One Option :");
							System.out.println("************************");
							Integer optionForShopSittingMenu = scannerMenu.nextInt();

							String soptionForShopSittingMenu = String.valueOf(optionForShopSittingMenu);

							switch (optionForShopSittingMenu) {
							case 0:
								caseName = "Create Items Table";
								 count = 1;
								countMenuSelected(caseName,count);
								allItemServices.createItemTable(Constants.USER_URL, Constants.USER_NAME,
										Constants.USER_PASSWORD);
								break;
							case 1:
								caseName = "Add Items";
								 count = 1;
								countMenuSelected(caseName,count);
								System.out.println("Please Enter Shop_Name :");
								String shop_name = scannerMenu.next();

								allItemServices.insertIntoItemTable(shop_name, Constants.USER_URL, Constants.USER_NAME,
										Constants.USER_PASSWORD);

								break;
							case 2:
								caseName = "Delete Items";
								 count = 1;
								countMenuSelected(caseName,count);
								System.out.println(" Enter id to be deleted ?");
								int id = scannerMenu.nextInt();
								String sid = String.valueOf(id);
								AllItemServices.deleteItemsById(id, Constants.USER_URL, Constants.USER_NAME,
										Constants.USER_PASSWORD);
								break;
							case 3:
								caseName = "Change Item Price";
								 count = 1;
								countMenuSelected(caseName,count);
								System.out.println(" Enter id to be Update ?");
								int itemId = scannerMenu.nextInt();
								String sitemId = String.valueOf(itemId);
								System.out.println(" Enter price to be Update ?");
								int itemprice = scannerMenu.nextInt();
								String sitemprice = String.valueOf(itemprice);
								AllItemServices.updateItemsPriceById(itemId, itemprice, Constants.USER_URL,
										Constants.USER_NAME, Constants.USER_PASSWORD);

								break;
							case 4:
								caseName = "Report All Items";
								 count = 1;
								countMenuSelected(caseName,count);
								allItemServices.readFromTable(Constants.USER_URL, Constants.USER_NAME,
										Constants.USER_PASSWORD);

								break;
							case 5:
								caseName = "Go Back";
								 count = 1;

								countMenuSelected(caseName,count);
								exitFlagMainMenu = true;
								exitFlagShopItemSittingMenu = false;
								break;

							}

						}
						exitFlagShopItemSittingMenu = false;

						break;
					case 3:
						caseName = "Create New Invoice";
						 count = 1;
						countMenuSelected(caseName,count);
						details.createInvoiceTable(Constants.USER_URL, Constants.USER_NAME, Constants.USER_PASSWORD);

						break;
					case 4:
						caseName = "Report (No Of Items, No of Invoices, Total Sales)";
						 count = 1;
						countMenuSelected(caseName,count);						details.reportTable(Constants.USER_URL, Constants.USER_NAME, Constants.USER_PASSWORD);
						break;
					case 5:
						caseName = "Report: All Invoices";
						 count = 1;
						countMenuSelected(caseName,count);	
						details.readFromTable(Constants.USER_URL, Constants.USER_NAME, Constants.USER_PASSWORD);

						break;
					case 6:
						caseName = "Search (1) Invoice";
						 count = 1;
						countMenuSelected(caseName,count);
						System.out.println(" Enter id to be Selected ?");
						int invoiceId = scannerMenu.nextInt();
						String sinvoiceId = String.valueOf(invoiceId);
						details.readFromInvoiceById(invoiceId, Constants.USER_URL, Constants.USER_NAME,
								Constants.USER_PASSWORD);

						break;
					case 7:
						caseName = "Program Statistics ";
						 count = 1;
						countMenuSelected(caseName,count);
						System.out.println(countMenuSelected(caseName,count));
						
						for(Map.Entry<String,Integer> entry:countMenuSelected(caseName,count).entrySet()){
							
		                    System.out.println("   "+ entry.getKey() +"  " + entry.getValue());
		    }
						
						break;
					case 8:
						caseName = "Exit";
						count=1 ;
						countMenuSelected(caseName,count);
						System.out.println(
								"Are you sure you want to exit? If yes, program ends, if No , then main menu reprinted again");
						String optionFlagMainMenu = scannerMenu.next();
						if (optionFlagMainMenu.equals("yes")) {
							System.out.println("**** THANK YOU ****");

							exitFlagMainMenu = false;
							exitFlagShopSittingMenu = false;
							exitFlagShopItemSittingMenu = false;

						} else if (optionFlagMainMenu.equals("No")) {
							exitFlagMainMenu = true;
						}

						break;
					}

				}
				exitFlagMainMenu = false;
			} else {
				System.out.println("Sorry Wrong Connection");

			}
		}
		connectionExit = false;
	}

}
