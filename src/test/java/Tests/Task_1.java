package Tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.HomePage;

public class Task_1 {
	
	HomePage PHome;
	String browserType = "Chrome";
	String driverPath  = "/Users/stevearaya/Documents/Drivers/chromedriver";
	String url         = "https://www.westernunion.com/lt/en/home.html";
	
	@BeforeClass
	public void beforeClass() {
		
		PHome = new HomePage( browserType, driverPath );
		
	}
	
	@BeforeMethod
	public void beforeTest() {
		
		PHome.openURL( url );
		
	}
	
	@AfterClass
	public void afterClass() {
		
		PHome.closeDriver();
		
	}
	
	@AfterMethod
	public void afterTest() {
		
		
		
	}
	
	@Test
	public void changeCountrySelection() throws InterruptedException {
		
//		1.	Navigate to https://www.westernunion.com/lt/en/home.html
//		2.	Expand Burger menu
//		3.	Select Settings page
//		4.	Change WU.com Country to United States
//		5.	Assert that correct country page was loaded.
		
		Thread.sleep(5000);
		
	}

}
