package Pages;

import Adapter.AdapterSelenium;

public class HomePage {
	
	
	private AdapterSelenium adapter;
	
	
	public HomePage( String browserType, String driverPath ) {
		
		adapter = AdapterSelenium.getAdapter( browserType, driverPath );
		
	}
	
	// Open driver.
	public void openURL( String url ) {
		
		adapter.openURL( url );
		
	}
	
	// Close driver.
	public void closeDriver() {
		
		adapter.closeDriver();
		
	}

}
