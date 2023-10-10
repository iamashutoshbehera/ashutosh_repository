package com.test;

import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.HomePage;
import pageEvents.LoginPage;
import pageEvents.SearchResultPage;
import reExeuter.RetryAnalyser;

public class ApplyJobs extends BaseTest {

	@Test (dataProvider = "login")
	public void applyJobs (String username, String password) throws InterruptedException{
		  LoginPage loginPage = new LoginPage(driver);
		  HomePage homePage = new HomePage(driver);
		  SearchResultPage searchPage = new SearchResultPage(driver);
		  
		  loginPage.clickOnLoginButton();
		  loginPage.enterUsername(username);
		  loginPage.enterPassword(password);
		  loginPage.submitUserLogin();
		  
		  homePage.searchJobTitle();
		  homePage.selectExperience();
		  homePage.searchPlace();
		  homePage.clickOnSerchIcon();
		  
		  searchPage.selectFiletrOption("Date");
//		  searchPage.getListOfJobTitle();
		  searchPage.selectJobTitile();
		  
		  homePage.clickOnProfileIcon();
		  homePage.clicOnLogout();
	}
	
}
