package testcase;

import java.util.HashMap;

public class hashmapsample {

	public static void main(String[] args) {
		 HashMap<String, String> capitalCities = new HashMap<String, String>();

		    // Add keys and values (Country, City)
		    capitalCities.put("England", "London");
		    capitalCities.put("Germany", "Berlin");
		    capitalCities.put("Norway", "Oslo");
		    capitalCities.put("USA", "WashingtonDC");
		    System.out.println(capitalCities);

	}

}
