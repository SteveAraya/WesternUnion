package Pages;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;

import Adapter.AdapterSelenium;

public class HomePage {
	
	
	By byBurgerMenu       = By.id("hamburger-nav-item");
	By byBMOSettings      = By.xpath("//a[@href='/lt/en/account/app/settings']/span");
	By bySettingsTittle   = By.xpath("//main[@id='settingsPage']//h1/translate");
	By byCountrySelection = By.id("Question");
	By byNavigateBtn      = By.xpath("//button[@ng-click='redirect();']");
	By byUSASelectFooter  = By.xpath("//div[@class='b-flag-select__value overflow-hidden white-space-nowrap font-body-sm w-100 text-action-light text-ellipsis']");
	
	
	private AdapterSelenium adapter;
	
	
	public HomePage( String browserType, String driverPath ) {
		
		adapter = AdapterSelenium.getAdapter( browserType, driverPath );
		
	}
	
	// Open driver.
	public void openURL( String url ) {
		
		adapter.openURL( url );
		
	}
	
	public void clickBurgerBtn() {
		
		adapter.toClick( byBurgerMenu );
		
	}
	
	public void clickNavigateYesBtn() {
		
		adapter.toClick( byNavigateBtn );
		
	}
	
	public void clickSettingsOption() {
		
		adapter.toClick( byBMOSettings );
		
	}
	
	public void selectUSACountry( String value ) {
		
		adapter.select( byCountrySelection, value );
		
	}
	
	public void validateSettingPage() throws IOException {
		
		assertEquals(adapter.getText( bySettingsTittle ), "Settings");
		
	}
	
	public void validateUSASelectFooter() throws IOException {
		
		assertEquals(adapter.getText( byUSASelectFooter ), "United States");
		
	}
	
	public void validateUSAUrl() {
		
		assertEquals(adapter.getUSAUrl(), "https://www.westernunion.com/us/en/home.html" );
		
	}
	
	// Close driver.
	public void closeDriver() {
		
		adapter.closeDriver();
		
	}

}
