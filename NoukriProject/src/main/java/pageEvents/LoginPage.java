package pageEvents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.BaseTest;
import utils.Utility;

public class LoginPage {
	
	@FindBy(xpath = "//a[@class='nI-gNb-lg-rg__login']") private WebElement login;
	@FindBy(xpath = "//input[contains(@placeholder,'Username')]") private WebElement loginUserIdTextBox;
	@FindBy(xpath = "//input[contains(@placeholder,'password')]") private WebElement passwordTextBox;
	@FindBy(xpath = "//button[@class='btn-primary loginButton']") private WebElement loginButton;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickOnLoginButton() throws InterruptedException {
		
		Utility.waitForVisiblity(login, 10);
		Utility.performClik(login);
	}
	
	public void enterUsername(String userName) throws InterruptedException {
		
		Utility.waitForVisiblity(login, 10);
		Utility.sendValues(loginUserIdTextBox, userName);
	}
	
	public void enterPassword(String password) {
		
		Utility.waitForVisiblity(passwordTextBox, 10);
		passwordTextBox.sendKeys(password);
	}
	
	public void submitUserLogin() {
		
		Utility.waitForVisiblity(loginButton, 10);
		loginButton.click();
	}
}
