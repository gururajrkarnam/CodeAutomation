package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="input-email")
	WebElement username;
	
	@FindBy(id="input-password")
	WebElement password;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement Login_Button;
	
	public WebElement username() {
		return username;
	}
	
	public WebElement password() {
		return password;
	}
	
	public WebElement Login_Button() {
		return Login_Button;
	}
	

}
