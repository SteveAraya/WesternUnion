package Tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.HomePage;

public class Task_1 {
	
	
	HomePage PHome;
	String countryUSAID = "object:252";
	
	
	@Parameters({"browserType", "driverPath", "siteUrl"})
	@BeforeClass
	public void beforeClass( String browserType, String driverPath, String siteUrl ) {
		
		PHome = new HomePage( browserType, driverPath );
		PHome.openURL( siteUrl );
		
	}
	
	@BeforeMethod
	public void beforeTest() {
		
		// Actions before every test.
		
	}
	
	@AfterClass
	public void afterClass() {
		
//		PHome.closeDriver();
		
	}
	
	@AfterMethod
	public void afterTest() {
		
		// Actions after every test.
		
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
		PHome.selectUSACountry( countryUSAID );
		PHome.clickNavigateYesBtn();
		PHome.validateUSASelectFooter();
		PHome.validateUSAUrl();
		Thread.sleep(3000);
		
	}

}
