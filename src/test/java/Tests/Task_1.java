package Tests;

import java.io.IOException;

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
	public void changeCountrySelection() throws InterruptedException, IOException {
		
//		1.	Navigate to https://www.westernunion.com/lt/en/home.html (Ready)
//		2.	Expand Burger menu                                       (Ready)
//		3.	Select Settings page                                     (Ready)
//		4.	Change WU.com Country to United States                   (Ready)
//		5.	Assert that correct country page was loaded.             (Ready)
		
		
		PHome.clickBurgerBtn();
		PHome.clickSettingsOption();
		PHome.validateSettingPage();
		PHome.selectUSACountry("object:252");
		PHome.clickNavigateYesBtn();
		PHome.validateUSASelectFooter();
		PHome.validateUSAUrl();
		Thread.sleep(3000);
		
	}

}
