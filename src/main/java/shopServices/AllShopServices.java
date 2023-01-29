package shopServices;

import java.util.Arrays;
import java.util.List;

public class AllShopServices {
	   public static List<String> getShopSettings() {


	        return Arrays.asList("1- Load Data (Items and invoices)",
	                "2- Set Shop Name",
	                "3- Set Invoice Header (Tel / Fax / Email / Website) ",
	                "4- Go Back"
	        );

	    }

}
