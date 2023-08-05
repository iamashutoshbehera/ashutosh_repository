package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
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
	}
	
	@BeforeTest
	public void beforeTest() {
		
		  driver.manage().window().maximize();
		  driver.get(Constants.URL);
	}
	
	@AfterTest
	public void afterTest() {
		
		driver.close();
	}
	
	@AfterSuite
	public void afterSuite() {
		
		System.out.println("Scenario Completed");
	}
}
