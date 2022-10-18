package Adapter;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class AdapterSelenium {
	
	
	private WebDriver driver;
	private static AdapterSelenium adapter = null;
	
	
	// We check if we have an adapter, if we don't. We will create one.
	public static AdapterSelenium getAdapter( String browserType, String driverPath ) {
		
		if( adapter == null ) {
			adapter = new AdapterSelenium( browserType, driverPath );
		}
		
		return adapter;
		
	}
	
	// Create a new adapter.
	public AdapterSelenium( String browserType, String driverPath ) {
		
		try {
			
			if(browserType.equals( "Chrome" )) {
				System.setProperty( "webdriver.chrome.driver", driverPath );
				driver = new ChromeDriver();
			}else if(browserType.equals( "Firefox" )) {
				System.setProperty( "webdriver.gecko.driver", driverPath );
				driver = new FirefoxDriver();
			}
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
		}catch(WebDriverException e) {
			
			Assert.fail("Driver instance error: " + e.getMessage());
			
		}
		
	}
	
	// Open driver.
	public void openURL( String url ) {
		
		driver.get( url );
		
	}
	
	// Close driver.
	public void closeDriver() {
		
		driver.quit();
	}

}