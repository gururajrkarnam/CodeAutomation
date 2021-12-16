package tests;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class LoginTestWithDataProvider extends Base {
	
	WebDriver driver;
	
	@BeforeMethod
	public void OpenBrowser() throws IOException {
		driver = InitializeDriver();
		driver.get(prop.getProperty("url"));
		
	}
	
	@Test(dataProvider="GetLoginData")
	public void login(String email,String password,String expectedResult) throws IOException, InterruptedException {
		
		
		
		LandingPage landingpage = new LandingPage(driver);
		Thread.sleep(3000);
		landingpage.myAccountDropdown().click();
		Thread.sleep(3000);
		landingpage.login().click();
		Thread.sleep(3000);
		LoginPage loginpage = new LoginPage(driver);
		loginpage.username().sendKeys(email);
		loginpage.password().sendKeys(password);
		Thread.sleep(2000);
		loginpage.Login_Button().click();
		
		AccountPage accountpage = new AccountPage(driver);
		
		String acutualResult = null;
		try {
			
				if(accountpage.editYourAccountInformationOption().isDisplayed()) {
				acutualResult = "Successful";
			}
			
		}catch(Exception e) {
			
				acutualResult = "Failure";
			
		}
		
		Assert.assertEquals(acutualResult,expectedResult);
		
	}
	
	
	@AfterMethod
	public void closure() {
		
		driver.close();
	}
	
	@DataProvider
	public Object[][] GetLoginData(){
		
		Object[][] data={{"gururajrkarnam@gmail.com","Admin@123","Successful"},{"Dummy@test.in","xyz","Failure"}};
		return data;
	}
}