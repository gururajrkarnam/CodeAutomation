package tests;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class LoginTest extends Base {
	
	WebDriver driver;
	
	@Test
	public void login() throws IOException, InterruptedException {
		
		driver = InitializeDriver();
		driver.get(prop.getProperty("url"));
		
		
		LandingPage landingpage = new LandingPage(driver);
		Thread.sleep(3000);
		landingpage.myAccountDropdown().click();
		Thread.sleep(3000);
		landingpage.login().click();
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.username().sendKeys(prop.getProperty("username"));
		loginpage.password().sendKeys(prop.getProperty("password"));
		Thread.sleep(2000);
		loginpage.Login_Button().click();
		
		AccountPage accountpage = new AccountPage(driver);
		Assert.assertTrue(accountpage.editYourAccountInformationOption().isDisplayed());
	}
	
	
	@AfterMethod
	public void closure() {
		
		driver.close();
	}

}
