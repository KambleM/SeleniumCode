package commonUtils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClassContact {
	
	WebDriver ts = new ChromeDriver();
	WebDriverUtil wutil = new WebDriverUtil();
	PropertyFileUtil putil = new PropertyFileUtil();
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Connect to data base");
	}
	
	@BeforeClass
	public void beforeClass() throws IOException {
		//@BeforeClass is use to launch the application
		String URL = putil.getDataFromPropertyFile("Url");
	   //WebDriver ts = new ChromeDriver();
				
		//to maximize the window
		wutil.maximize(ts);
		//apply wait for implicitwait();
		wutil.implicitWait(ts);
		ts.get(URL);
		
	}
	
	@BeforeMethod
	public void beforeMethod() throws IOException {
		//@before method is use to login to the application
		String USERNAME = putil.getDataFromPropertyFile("Username");
		String PASSWORD = putil.getDataFromPropertyFile("Password");
		
		ts.findElement(By.name("user_name")).sendKeys(USERNAME);
		ts.findElement(By.name("user_password")).sendKeys(PASSWORD);
		ts.findElement(By.id("submitButton")).click();
		
	}
	
	@AfterClass
	public void afterClass() {
		//@AfterClass is use to close the browser
		//	WebDriver ts = new ChromeDriver();
			ts.quit();
		
	}
	
	@AfterMethod
	public void afterMethod() {
		//@AfterMethod is use to signout from the application
		 WebElement image = ts.findElement(By.cssSelector("img[src=\"themes/softed/images/user.PNG\"]"));
		 wutil.mouseHover(ts,image);
		 
		 ts.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("Disconnect to data base");
		
	}

}
