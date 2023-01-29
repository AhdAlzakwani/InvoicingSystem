package invoiceSys;

import java.util.Scanner;

import shopServices.AllShopServices;

public class Main {

	public static void main(String[] args) {
		
		Scanner scannerMenu = new Scanner(System.in);
		boolean exitFlagMainMenu = true;
		boolean exitFlagShopSittingMenu = true;
		while(exitFlagMainMenu) {
			
			for (String x : Menu.getMenuArray()) {
                System.out.println(x);
			}
			Integer optionForMainMenu = scannerMenu.nextInt();
            switch (optionForMainMenu) {

                case 1:
                	while(exitFlagShopSittingMenu) {
                		
                		for (String x : AllShopServices.getShopSettings()) {
                            System.out.println(x);
            			}
                		
                	}exitFlagShopSittingMenu = false;
                	
                	
                    break;
                case 2:

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


                    break;
            }
			
			
		}exitFlagMainMenu = false;
	}

}
