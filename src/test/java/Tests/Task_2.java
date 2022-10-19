package Tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.HomePage;

public class Task_2 {
	
	HomePage PHome;
	String browserType = "Firefox";
	String driverPath  = "/Users/stevearaya/Documents/Drivers/geckodriver";
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
	public void openAgentLocationByZipCode() throws InterruptedException {
		
//		As a UAT tester using https://www.westernunion.com/lt/en/home.html
//		I want automation tool to search for open agent locations near my Zip code 08247
//		So that I could get address details of the first location printed in console
		
		PHome.clickFindLocationsOption();
		Thread.sleep(3000);
		PHome.inputAddress( "08247" );
		PHome.clickOpenOption();
		PHome.clickDistanceOption();
		PHome.getAgentLocation();
		
		Thread.sleep(3000);
		
	}

}
