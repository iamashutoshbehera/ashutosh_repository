package pageEvents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utility;

public class HomePage {
	
	@FindBy(xpath = "//div[@class='nI-gNb-drawer__icon-img-wrapper']") private WebElement profileIcon;
	@FindBy(xpath = "//a[@title='Logout']") private WebElement logoutButton;
	@FindBy(xpath = "//a[@class='nI-gNb-info__sub-link']") private WebElement updateProfile;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnProfileIcon() {
		Utility.waitForVisiblity(profileIcon, 10);
		profileIcon.click();
	}
	
	public void clicOnLogout() {
		Utility.waitForVisiblity(logoutButton, 10);
		logoutButton.click();;
	}
	
	public void clickUpdateProfile() {
		Utility.waitForVisiblity(updateProfile, 10);
		updateProfile.click();;
	}
		
}
