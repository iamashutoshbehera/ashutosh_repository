package pageEvents;

import java.util.List;

import org.bouncycastle.jcajce.provider.symmetric.util.PBE.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Utility;

public class SearchResultPage {

	@FindBy(xpath = "//a[@class='title ellipsis']") List <WebElement> listOfJob;
	@FindBy(xpath = "//p[@class='sort-droop-label']") WebElement jobFilterDropBox;
	@FindBy(xpath = "//ul[@class = 'sort-droop-list open']/li") List <WebElement> filterOptionList;
	@FindBy(xpath = "(//img[@alt='Naukri Logo'])[1])") WebElement noukriLogo;
	@FindBy(xpath = "(//button[@id='apply-button'])[1]") WebElement applyButton;
	
	
	public SearchResultPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void selectFiletrOption(String filterType) throws InterruptedException {
		Utility.waitForVisiblity(jobFilterDropBox, 10);
		Utility.performClik(jobFilterDropBox);
		
		for(WebElement option : filterOptionList) {
			if(filterType.equals(option.getText())) {
				Utility.performClik(option);
			}
		}
	}
	public void getListOfJobTitle() {
		int count = 1;
		for(WebElement jobTItle : listOfJob) {
			System.out.println(count++ + " > Job Title : " + jobTItle.getText());
		}
	}
	
	public void selectJobTitile() throws InterruptedException {
		for(WebElement jobTItle : listOfJob) {
			System.out.println(" > Job Title : " + jobTItle.getText());
			
			if(jobTItle.getText().contains("Automation")) {
				System.out.println(jobTItle.getText());
				Utility.performClik(jobTItle);
				manageSearchJobChildPage();
			}
		}
		
	}
	
	public void manageSearchJobChildPage() throws InterruptedException {
		String parentTab = Utility.getParentTab();
		
		Utility.switchToChildTab();
		validateForNaukriPage();
		
		Utility.closeBrowser();
		Utility.switchToParentTab(parentTab);
	}
	
	public void validateForNaukriPage() {
		
		if(noukriLogo.isDisplayed() == false) {
			Utility.closeBrowser();
		}
	}
	
	public void checkForSkills() {
		
	}
	
	public void applyJob() {
		
	}
}
