package invoiceSys;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.Popup;

import shopServices.AllItemServices;
import shopServices.AllShopServices;
import shopServices.Constants;
import shopServices.InvoiceDetails;

public class Main {

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

		Scanner scannerMenu = new Scanner(System.in);
		AllShopServices allShopServices = new AllShopServices();
		AllItemServices allItemServices = new AllItemServices();
		InvoiceDetails details = new InvoiceDetails();
		Stack<String> programStatistic = new Stack<String>();

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

					for (String x : Menu.getShowMenu()) {
						System.out.println(x);
					}
					System.out.println("************************");
					System.out.println("Select Only One Option :");
					System.out.println("************************");
					Integer optionForMainMenu = 0;
					try {
						 optionForMainMenu = scannerMenu.nextInt();
					} catch (InputMismatchException Exception) {
						System.out.println("Wroong Input !!!! You Should Use Only String Input"+Exception);

					}
					String soptionForMainMenu = String.valueOf(optionForMainMenu);
					programStatistic.push(soptionForMainMenu);
					switch (optionForMainMenu) {
					case 0:
						Constants.getDatabaseConnection(userName, soptionForMainMenu, userPassword);
						break;
					case 1:
						while (exitFlagShopSittingMenu) {

							for (String x : Menu.getShopSettings()) {
								System.out.println(x);
							}
							System.out.println("WELCOME TO SHOP SITTING");
							System.out.println("************************");
							System.out.println("Select Only One Option :");
							System.out.println("************************");
							Integer optionForShopItemSittingMenu = scannerMenu.nextInt();
							String soptionForShopItemSittingMenu = String.valueOf(optionForShopItemSittingMenu);
							programStatistic.push(soptionForShopItemSittingMenu);
							switch (optionForShopItemSittingMenu) {
							case 0:
								allShopServices.createShopTable(Constants.USER_URL, Constants.USER_NAME,
										Constants.USER_PASSWORD);
								allShopServices.createShopDetailsTable(Constants.USER_URL, Constants.USER_NAME,
										Constants.USER_PASSWORD);
								break;
							case 1:
								System.out.println(
										"Do you want to insert Items? If yes, press 1 , if you want to insert invoices, then press 2");
								Integer InsertOption = scannerMenu.nextInt();
								String sInsertOption = String.valueOf(InsertOption);
								programStatistic.push(sInsertOption);
								if (InsertOption == 1) {

									System.out.println("Please Enter Shop_Name :");
									String shop_name = scannerMenu.next();
									programStatistic.push(shop_name);
									allItemServices.insertIntoItemTable(shop_name, Constants.USER_URL,
											Constants.USER_NAME, Constants.USER_PASSWORD);
								} else if (InsertOption == 2) {
									System.out.println("How many Invoice You want to Insert ?");
									Integer InvoiceNumberToInsert = scannerMenu.nextInt();
									String sInvoiceNumberToInsert = String.valueOf(InvoiceNumberToInsert);
									programStatistic.push(sInvoiceNumberToInsert);
									System.out.println("Please Enter Item Name :");
									String Item_Name = scannerMenu.next();
									programStatistic.push(Item_Name);
									details.insertIntoShopDetailsTable(InvoiceNumberToInsert, Item_Name,
											Constants.USER_URL, Constants.USER_NAME, Constants.USER_PASSWORD);

								} else {
									System.out.println("Only 1 Or 2");

								}

								break;
							case 2:
								System.out.println("How many Shop You want to Insert ?");
								Integer shopNumberToInsert = scannerMenu.nextInt();
								String sshopNumberToInsert = String.valueOf(shopNumberToInsert);
								programStatistic.push(sshopNumberToInsert);

								allShopServices.insertIntoShopTable(shopNumberToInsert, Constants.USER_URL,
										Constants.USER_NAME, Constants.USER_PASSWORD);

								break;
							case 3:
								System.out.println("How many Shop You want to Insert ?");
								Integer shopDetailsNumberToInsert = scannerMenu.nextInt();
								String sshopDetailsNumberToInsert = String.valueOf(shopDetailsNumberToInsert);
								programStatistic.push(sshopDetailsNumberToInsert);

								System.out.println("Please Enter Shop_Name :");
								String shop_name = scannerMenu.next();
								programStatistic.push(shop_name);
								allShopServices.insertIntoShopDetailsTable(shopDetailsNumberToInsert, shop_name,
										Constants.USER_URL, Constants.USER_NAME, Constants.USER_PASSWORD);

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

							for (String x : Menu.getShopItemSettings()) {
								System.out.println(x);
							}
							System.out.println("WELCOME TO SHOP ITEM SITTING");
							System.out.println("************************");
							System.out.println("Select Only One Option :");
							System.out.println("************************");
							Integer optionForShopSittingMenu = scannerMenu.nextInt();

							String soptionForShopSittingMenu = String.valueOf(optionForShopSittingMenu);
							programStatistic.push(soptionForShopSittingMenu);

							switch (optionForShopSittingMenu) {
							case 0:
								allItemServices.createItemTable(Constants.USER_URL, Constants.USER_NAME,
										Constants.USER_PASSWORD);
								break;
							case 1:

								System.out.println("Please Enter Shop_Name :");
								String shop_name = scannerMenu.next();
								programStatistic.push(shop_name);

								allItemServices.insertIntoItemTable(shop_name, Constants.USER_URL, Constants.USER_NAME,
										Constants.USER_PASSWORD);

								break;
							case 2:
								System.out.println(" Enter id to be deleted ?");
								int id = scannerMenu.nextInt();
								String sid = String.valueOf(id);
								programStatistic.push(sid);
								AllItemServices.deleteItemsById(id, Constants.USER_URL, Constants.USER_NAME,
										Constants.USER_PASSWORD);
								break;
							case 3:
								System.out.println(" Enter id to be Update ?");
								int itemId = scannerMenu.nextInt();
								String sitemId = String.valueOf(itemId);
								programStatistic.push(sitemId);
								System.out.println(" Enter price to be Update ?");
								int itemprice = scannerMenu.nextInt();
								String sitemprice = String.valueOf(itemprice);
								programStatistic.push(sitemprice);
								AllItemServices.updateItemsPriceById(itemId, itemprice, Constants.USER_URL,
										Constants.USER_NAME, Constants.USER_PASSWORD);

								break;
							case 4:
								allItemServices.readFromTable(Constants.USER_URL, Constants.USER_NAME,
										Constants.USER_PASSWORD);

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
						details.createInvoiceTable(Constants.USER_URL, Constants.USER_NAME, Constants.USER_PASSWORD);

						break;
					case 4:
						details.reportTable(Constants.USER_URL, Constants.USER_NAME, Constants.USER_PASSWORD);
						break;
					case 5:
						details.readFromTable(Constants.USER_URL, Constants.USER_NAME, Constants.USER_PASSWORD);

						break;
					case 6:
						System.out.println(" Enter id to be Selected ?");
						int invoiceId = scannerMenu.nextInt();
						String sinvoiceId = String.valueOf(invoiceId);
						programStatistic.push(sinvoiceId);
						details.readFromInvoiceById(invoiceId, Constants.USER_URL, Constants.USER_NAME,
								Constants.USER_PASSWORD);

						break;
					case 7:
						try {
							Stack<String> st = (Stack<String>) programStatistic;
							System.out.println(st);
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
//				Stack<String> st = (Stack<String>) programStatistic.pop();
//				System.out.println("Stack POP: " + programStatistic.pop()); 
						break;
					case 8:
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
