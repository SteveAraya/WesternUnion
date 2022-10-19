package Pages;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;

import Adapter.AdapterSelenium;

public class HomePage {
	
	
	By byBurgerMenu        = By.id("hamburger-nav-item");
	By byBMOSettings       = By.xpath("//a[@href='/lt/en/account/app/settings']/span");
	By bySettingsTittle    = By.xpath("//main[@id='settingsPage']//h1/translate");
	By byCountrySelection  = By.id("Question");
	By byNavigateBtn       = By.xpath("//button[@ng-click='redirect();']");
	By byUSASelectFooter   = By.xpath("//div[@class='b-flag-select__value overflow-hidden white-space-nowrap font-body-sm w-100 text-action-light text-ellipsis']");
	
	By byOFindLocations    = By.xpath("//a[@href='/lt/en/find-locations.html']/span");
//	By byAddressInput      = By.xpath("//input[@placeholder='Address, city, state or ZIP']");
	By byAddressInput      = By.cssSelector(".wu_AddressInput_TextInput___1hB48");
	By byOpenOptionBtn     = By.xpath("//button/span[text()='Open now']/ancestor::button");
	By byDistanceOptionBtn = By.xpath("//button/span[text()='Distance']/ancestor::button");
	By byAddressLocation   = By.xpath("//ol[@class='wu_Results_ResultList___2eQwV wu_NoPads___2hnVG']//li[1]/div/div[3]/div/div[2]");
			
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
	
	public void clickFindLocationsOption() {
		
		adapter.toClick( byOFindLocations );
		
	}
	
	public void clickOpenOption() {
		
		adapter.toClick( byOpenOptionBtn );
		
	}
	
	public void clickDistanceOption() {
		
		adapter.toClick( byDistanceOptionBtn );
		
	}
	
	public void inputAddress( String value ) {
		
		adapter.input( byAddressInput, value );
		
	}
	
	public void selectUSACountry( String value ) {
		
		adapter.select( byCountrySelection, value );
		
	}
	
	public void getAgentLocation() {
		
		String agent_location = adapter.getText( byAddressLocation );
		System.out.println(agent_location);
		
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
