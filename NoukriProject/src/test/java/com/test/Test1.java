package com.test;

import java.awt.AWTException;

import org.testng.annotations.Test;
import base.BaseTest;
import pageEvents.HomePage;
import pageEvents.LoginPage;
import pageEvents.ProfilePage;

public class Test1 extends BaseTest {
	
  @Test (dataProvider = "login" , invocationCount = 1)
  public void f(String username, String password) throws InterruptedException, AWTException {
	  LoginPage loginPage = new LoginPage(driver);
	  HomePage homePage = new HomePage(driver);
	  ProfilePage profilePage = new ProfilePage(driver);
	  
	  loginPage.clickOnLoginButton();
	  	
	  loginPage.enterUsername(username);
	  loginPage.enterPassword(password);
	  loginPage.submitUserLogin();
	  
	  homePage.clickOnProfileIcon();
	  homePage.clickUpdateProfile();
	  
	  profilePage.clickUpdateResume();
	  profilePage.uploadResume();
	  profilePage.successUpdateProfile();
	  
	  homePage.clickOnProfileIcon();
	  homePage.clicOnLogout();
  }
  
}
