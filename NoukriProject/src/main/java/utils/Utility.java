package utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class Utility extends BaseTest {
	
public static void performClik(WebElement element) throws InterruptedException {
		
		for(int i = 1 ; i <= 5 ; i++) {
			
			try {
				element.click();
				break;
			}catch(ElementClickInterceptedException e) {
				Thread.sleep(500);
			}catch (ElementNotInteractableException ee) {
				Thread.sleep(500);
			}
		}
	}
	
	
	public static void sendValues(WebElement element, String value ) throws InterruptedException {
		
		for(int i = 1 ; i <= 5 ; i++) {

			try {
				element.sendKeys(value);
				break;
			}catch(ElementClickInterceptedException e) {
				Thread.sleep(500);
			}catch (ElementNotInteractableException ee) {
				Thread.sleep(500);
			}
		}
	}

	public static void waitForVisiblity(WebElement element, int time) {
		
		Duration secInTime = Duration.ofSeconds(time);
		WebDriverWait wait = new WebDriverWait(driver, secInTime);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public static void uploadFile() throws AWTException, InterruptedException {
		Thread.sleep(1000);
		Robot r = new Robot();
		StringSelection s = new StringSelection ("C:\\WorkSpace\\NoukriProject\\DOCFile\\Ashutosh_Behera_Experienced_Resume.docx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
		
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
	}
	
	public static String getParentTab() {
		return driver.getWindowHandle();
	}
	
	public static void switchToChildTab() {
		
		String parent=driver.getWindowHandle();
		Set<String>s=driver.getWindowHandles();
		Iterator <String> I1= s.iterator();

		while(I1.hasNext())
		{
			
			String child_window=I1.next();
			if(!parent.equals(child_window))
			{
				driver.switchTo().window(child_window);
				return;
			}
		}
	}
	
	public static void switchToParentTab(String parent) {
		driver.switchTo().window(parent);
	}
	
	public static void closeBrowser() {
		driver.close();
	}
	
}
