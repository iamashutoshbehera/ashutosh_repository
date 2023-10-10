package base;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v85.emulation.model.VirtualTimePolicy;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import dev.failsafe.Timeout;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Constants;
import utils.DataFactory;

public class BaseTest extends DataFactory {
	public static WebDriver driver;
	
	@BeforeSuite
	public void beforeSite() {
		
		WebDriverManager.chromedriver().setup();
		  ChromeOptions chromeOptions = new ChromeOptions();
		  chromeOptions.addArguments("--remote-allow-origins=*");
		  driver =  new ChromeDriver(chromeOptions);
		  
		  System.out.println("Browser Launched, driver Id : " + driver);
	}
	
	@BeforeTest
	public void beforeTest() {
		
		  driver.manage().window().maximize();
		  driver.get(Constants.URL);
		  System.out.println("Navigated to " + driver.getTitle() + " Page" );
	}
	
	@BeforeClass
	public void beforeClass() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	@BeforeMethod
	public void beforeMethod() {
		
	}
	
	@AfterMethod
	public void afterMethod() {
		
	}
	
	@AfterClass
	public void afterClass() {
		
	}
	
	@AfterTest
	public void afterTest() {
		
		driver.close();
		System.out.println("Broser Closed");
	}
	
	@AfterSuite
	public void afterSuite() {
		
		System.out.println("Scenario Successfully Completed");
	}
}
