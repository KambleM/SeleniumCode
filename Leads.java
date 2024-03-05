package vtigercrm;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import commonUtils.ExcelUtil;
import commonUtils.JavaUtil;
import commonUtils.PropertyFileUtil;
import commonUtils.WebDriverUtil;

public class Leads {
	
	PropertyFileUtil putil = new PropertyFileUtil();
	WebDriverUtil wutil = new WebDriverUtil();
	ExcelUtil eutil = new ExcelUtil();
	JavaUtil jutil = new JavaUtil();
	
	@Test
	public void leadTest() throws IOException {
		//to launch the browser
		WebDriver ts = new ChromeDriver();
		//to maximize the screen
		wutil.maximize(ts);
		//
		wutil.implicitWait(ts);
		
		//to launch the application
		String URL = putil.getDataFromPropertyFile("Url");
		String USERNAME = putil.getDataFromPropertyFile("Username");
		String PASSWORD = putil.getDataFromPropertyFile("Password");
		
		String fn = eutil.getDataFromExcel("Leads", 0, 1);
		String ln = eutil.getDataFromExcel("Leads", 1, 1);
		String company = eutil.getDataFromExcel("Leads", 2, 1);
		
		
		
		
		//username password
		ts.get(URL);
    	ts.findElement(By.name("user_name")).sendKeys(USERNAME);
		ts.findElement(By.name("user_password")).sendKeys(PASSWORD);
		//submit button
		ts.findElement(By.id("submitButton")).click();
		//To click on leads
		ts.findElement(By.xpath("//a[text()='Leads']")).click();
		//To click on plus button
		ts.findElement(By.cssSelector("img[src='themes/softed/images/btnL3Add.gif']")).click();
		
	
		
		ts.findElement(By.name("firstname")).sendKeys(fn);
		ts.findElement(By.name("lastname")).sendKeys(ln);
		ts.findElement(By.name("company")).sendKeys(company);
		
		ts.findElement(By.cssSelector("input[value='T']")).click();
		
        WebElement dropdown = ts.findElement(By.name("assigned_group_id"));
		
		wutil.handledropdown(dropdown,"Team Selling");
		
		WebElement image = ts.findElement(By.cssSelector("img[src=\"themes/softed/images/user.PNG\"]"));
	    wutil.mouseHover(ts,image);
	    
	    ts.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		
		
		
	}

}
