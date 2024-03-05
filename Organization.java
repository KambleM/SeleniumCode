package vtigercrm;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commonUtils.ExcelUtil;
import commonUtils.JavaUtil;
import commonUtils.ListenerImplementation;
import commonUtils.PropertyFileUtil;
import commonUtils.WebDriverUtil;

@Listeners(ListenerImplementation.class)
public class Organization {
	
	
	PropertyFileUtil putil = new PropertyFileUtil();
	WebDriverUtil wutil = new WebDriverUtil();
	ExcelUtil eutil = new ExcelUtil();
	JavaUtil jutil = new JavaUtil();
	
	@Test
	public void organizationTest() throws IOException, InterruptedException {
		
		WebDriver ts = new ChromeDriver();
	    //to maximize the window
		wutil.maximize(ts);
		//apply wait for implicitwait();
		wutil.implicitWait(ts);
		
		String URL = putil.getDataFromPropertyFile("Url");
		String USERNAME = putil.getDataFromPropertyFile("Username");
		String PASSWORD = putil.getDataFromPropertyFile("Password");
		
		String Orgname = eutil.getDataFromExcel("Organizations",0 ,1);
		String group = eutil.getDataFromExcel("Organizations", 1, 1);
		
		ts.get(URL);
		ts.findElement(By.name("user_name")).sendKeys(USERNAME);
		ts.findElement(By.name("user_password")).sendKeys(PASSWORD);
			
		
		ts.findElement(By.id("submitButton")).click();
		//click on organization..(+)
	    ts.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click() ;
	    ts.findElement(By.cssSelector("img[alt='Create Organization...']")).click() ;
		ts.findElement(By.name("accountname")).sendKeys(Orgname + jutil.getRandomNumber()) ;
	    ts.findElement(By.cssSelector("input[value='T']")).click() ;
	    
	    WebElement dropdown = ts.findElement(By.name("assigned_group_id"));
	    
	    wutil.handledropdown(dropdown, group);
	    ts.findElement(By.xpath("(//input[@name='button'])[1]")).click();
	    
	    Thread.sleep(2000);
	    //mousehover on image
	    WebElement image = ts.findElement(By.cssSelector("img[src=\"themes/softed/images/user.PNG\"]"));
	    wutil.mouseHover(ts,image);
	    
	    ts.findElement(By.xpath("//a[text()='Sign Out']")).click();
	    
		
		
		
		
	}

}
