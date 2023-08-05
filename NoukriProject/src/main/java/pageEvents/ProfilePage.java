package pageEvents;

import java.awt.AWTException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utility;

public class ProfilePage {
	
//	@FindBy(xpath = "(//a[@href='javascript:;'])[1]") private WebElement updateResumeLink;
	
	@FindBy(xpath = "(//div[@class='action'])[1]") private WebElement updateResumeLink;		
	@FindBy(xpath = "//p[@class = 'head']") private WebElement updateProfileSuccess;
	
	public ProfilePage(WebDriver driver){
		PageFactory.initElements(driver, this); 
	}
	
	public void successUpdateProfile() {
		
		Utility.waitForVisiblity(updateProfileSuccess, 10);
	}
	
	public void clickUpdateResume() {
		
		Utility.waitForVisiblity(updateResumeLink, 10);
		updateResumeLink.click();
	}
	
	public void uploadResume() throws AWTException, InterruptedException {
		
		Utility.uploadFile();
	}
}
