package invoiceSys;

import java.util.Scanner;

import shopServices.AllShopServices;

public class Main {

	public static void main(String[] args) {

		Scanner scannerMenu = new Scanner(System.in);
		AllShopServices allShopServices = new AllShopServices();

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

						break;
					case 2:

						break;
					case 3:

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

					for (String x : AllShopServices.getShopSettings()) {
						System.out.println(x);
					}
					System.out.println("WELCOME TO SHOP ITEM SITTING");
					System.out.println("************************");
					System.out.println("Select Only One Option :");
					System.out.println("************************");
					Integer optionForShopSittingMenu = scannerMenu.nextInt();
					switch (optionForShopSittingMenu) {

					case 1:
						

						break;
					case 2:

						break;
					case 3:

						break;
					case 4:

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

				break;
			case 4:

				break;
			case 5:

				break;
			case 6:

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
