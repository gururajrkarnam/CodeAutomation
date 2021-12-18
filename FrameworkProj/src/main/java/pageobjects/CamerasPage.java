package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CamerasPage {
	
	WebDriver driver;
	
public CamerasPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	


	@FindBy(xpath ="//select[@id='input-sort']")
	WebElement dropdown;
	
public WebElement dropdown() {
		
		return dropdown;
		
	}
	
	@FindBy(xpath ="//a[text()='Canon EOS 5D']")
	WebElement Canon_Camera;
	
	public WebElement Canon_Camera() {
		
		return Canon_Camera;
		
	}

}
