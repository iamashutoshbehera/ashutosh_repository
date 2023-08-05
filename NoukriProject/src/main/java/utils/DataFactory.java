package utils;

import org.testng.annotations.DataProvider;

public class DataFactory {

	@DataProvider (name = "login")
	public Object[][] loginCredentials() {
		
	    return new Object [][] { {"iamashutoshbehera@gmail.com", "Ashutosh@35"}};
	}
	
}
