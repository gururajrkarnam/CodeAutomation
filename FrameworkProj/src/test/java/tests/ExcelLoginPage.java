package tests;

import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.lib.util.Xls_Reader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelLoginPage {

	
	public static void main(String[] args) {
		
		WebDriver driver=null;
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); 
		
		
		
		
		
		Xls_Reader reader = new Xls_Reader("./src/main/java/com/excel/lib/util/SampleExcel.xlsx");
		String sheetName = "login";
		
		WebElement username = driver.findElement(By.name("username"));
		WebElement pwd = driver.findElement(By.name("password"));
		WebElement Submit_Button=driver.findElement(By.xpath("//input[@value='Login']"));
		
		
		int rowCount=reader.getRowCount(sheetName);
		
		for(int rowNum=2;rowNum<=rowCount;rowNum++) {
			
			String LoginId=reader.getCellData(sheetName,"Username",rowNum);
			String Password = reader.getCellData(sheetName, "Password",rowNum);
			
			System.out.println(LoginId  + "" + Password);
			System.out.println();
			
			username.clear();
			username.sendKeys(LoginId);
			pwd.clear();
			pwd.sendKeys(Password);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			try {
			
				Submit_Button.click();
			}
			catch(Exception e) {
			System.out.println("Inside catch block");
			Submit_Button.click();
			e.printStackTrace();
		}
		driver.close();
	}

}}
