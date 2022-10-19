package Adapter;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	
	public void toClick( By locator ) {
		
		try {
			
			createElement( locator,"CLICK" ).click();
			
		}catch( ElementClickInterceptedException e ) {
			
			System.out.println("The element with the path: " + locator + " can't be clicked.");
			Assert.fail("The element with the path: " + locator + " can't be clicked.");
			
		}
		
	}
	
	public String getText( By locator ) {
		
		String text = "";
		
		try {
			
			text = createElement( locator, "GET" ).getText();
			
		}catch( ElementNotInteractableException e){
			
			System.out.println("The element with the path: " + locator + " can't interact.");
			Assert.fail("The element with the path: " + locator + " can't interact.");
			
		}
		
		return text;
		
		
	}
	
	public String getUSAUrl( ) {
		
		String URL = driver.getCurrentUrl();
		return URL;
		
	}
	
	public void select(By locator, String value) {
		
		Select elementToSelect = new Select(createElement(locator, "SELECT"));
		elementToSelect.selectByValue(value);
		
	}
	
	public void input( By locator, String value ) {
		
		WebElement elemento = createElement( locator, "INPUT" );
		elemento.clear();
		elemento.sendKeys( value );
		elemento.sendKeys( Keys.ENTER );
		
	}
	
	public WebElement createElement( By locator, String action ) {
		
		WebDriverWait wait  = new WebDriverWait( driver, Duration.ofSeconds(60) );
		WebElement element  = null;
		
		try {
			
			if(action.equals("CLICK")) {
				
				element = wait.until(ExpectedConditions.elementToBeClickable( locator ));
		
				
			}else if(action.equals("INPUT")) {
				
				element = wait.until(ExpectedConditions.presenceOfElementLocated( locator ));
				
			}else if(action.equals("GET")) {
				
				element = wait.until(ExpectedConditions.visibilityOfElementLocated( locator ));
				
			}else if(action.equals("SELECT")) {
				
				element = wait.until(ExpectedConditions.visibilityOfElementLocated( locator ));
				
			}else {
				
				element = wait.until(ExpectedConditions.visibilityOfElementLocated( locator ));
				
			}
			
		}catch( NoSuchElementException e ){
			
			System.out.println("The element with the path: : " + locator + " does not exist.");
			Assert.fail("The element with the path: : " + locator + " does not exist.");
			
		}
		
		return element;
		
	}
	
	// Close driver.
	public void closeDriver() {
		
		driver.quit();
	}

}