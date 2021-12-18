package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.CamerasPage;
import pageobjects.LandingPage;
import resources.Base;

public class CameraFunctionality extends Base {
	
WebDriver driver;
	
	@Test
	public void login() throws IOException, InterruptedException {
		
		driver = InitializeDriver();
		driver.get(prop.getProperty("url"));
		
		CamerasPage camerasPage = new CamerasPage(driver);
		LandingPage landingpage = new LandingPage(driver);
		Thread.sleep(3000);
		landingpage.Camera_Tab().click();
		Assert.assertEquals(true, camerasPage.Canon_Camera().isDisplayed());
		System.out.println("assert passed");
		camerasPage.dropdown().click();
		Select fruits = new Select(camerasPage.dropdown());
		fruits.selectByIndex(2);
		
	
		
	}

	
}
