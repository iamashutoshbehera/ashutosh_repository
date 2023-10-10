package pageEvents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utils.Utility;

public class HomePage {
	
	@FindBy(xpath = "//div[@class='nI-gNb-drawer__icon-img-wrapper']") private WebElement profileIcon;
	@FindBy(xpath = "//a[@title='Logout']") private WebElement logoutButton;
	@FindBy(xpath = "//a[@class='nI-gNb-info__sub-link']") private WebElement updateProfile;
	@FindBy(xpath = "//span[@class= 'nI-gNb-sb__placeholder']") private WebElement jobSearchBar;
	@FindBy(xpath =  "//input[@class= 'suggestor-input ']") private WebElement searchBar;
	@FindBy(xpath = "//span[text()= '2 years']") private WebElement twoYearsExperence;
	@FindBy(xpath = "//input[@id= 'experienceDD']") private WebElement searchExperience;
	@FindBy(xpath = "//input[@placeholder= 'Enter location']") private WebElement searchPlaceBox;
	@FindBy(xpath = "//span[@class= 'ni-gnb-icn ni-gnb-icn-search']") private WebElement searchIcon;
	
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
	
	public void searchJobTitle() throws InterruptedException {
		Utility.waitForVisiblity(jobSearchBar, 10);
		Utility.performClik(jobSearchBar);
		Utility.sendValues(searchBar, "QA Automation Engineer");
	}
	
	public void selectExperience() throws InterruptedException {
		Utility.performClik(searchExperience);
		Utility.waitForVisiblity(twoYearsExperence, 10);
		
		Utility.performClik(twoYearsExperence);
	
	}
	
	public void searchPlace() throws InterruptedException {
		Utility.sendValues(searchPlaceBox, "Bangalore/Bengaluru");
	}
	
	public void clickOnSerchIcon() throws InterruptedException {
		Utility.waitForVisiblity(searchIcon, 10);
		Utility.performClik(searchIcon);
	}
	
}
