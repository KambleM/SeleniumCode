package vtigercrm;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonUtils.BaseClassContact;
import commonUtils.ExcelUtil;
import commonUtils.JavaUtil;
import commonUtils.PropertyFileUtil;
import commonUtils.WebDriverUtil;

public class ContactTestNG  extends BaseClassContact{
	
	PropertyFileUtil putil = new PropertyFileUtil();
	WebDriverUtil wutil = new WebDriverUtil();
	ExcelUtil eutil = new ExcelUtil();
	JavaUtil jutil = new JavaUtil();
	WebDriver ts = new ChromeDriver();
	
	@Test
	
	public void contactTest() throws IOException, InterruptedException {
		
//		WebDriver ts = new ChromeDriver();
	    //to maximize the window
//		wutil.maximize(ts);
//		//apply wait for implicitwait();
//		wutil.implicitWait(ts);
//		//to launch application
//		String URL = putil.getDataFromPropertyFile("Url");
//		String USERNAME = putil.getDataFromPropertyFile("Username");
//		String PASSWORD = putil.getDataFromPropertyFile("Password");
		
		//to fetch data from excel
		String fn = eutil.getDataFromExcel("Contacts",0 ,1);
		String ln = eutil.getDataFromExcel("Contacts", 1, 1);
		//String ab = eutil.getDataFromExcel("Contacts", 2, 1);
		String organization = eutil.getDataFromExcel("Contacts", 3, 1);
		
//		ts.get(URL);
//		ts.findElement(By.name("user_name")).sendKeys(USERNAME);
//		ts.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		ts.findElement(By.id("submitButton")).click();
		
		
		//click on plus
		ts.findElement(By.xpath("//a[text()='Contacts']")).click();
		ts.findElement(By.cssSelector("img[alt = 'Create Contact...']")).click();
		//input feild
		ts.findElement(By.name("firstname")).sendKeys(fn);
		ts.findElement(By.name("lastname")).sendKeys(ln);
		
		
		//to fail the testScript
		String actualUrl = ts.getCurrentUrl();
		String expectedUrl = "http://localhost:8888/pune/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing";
	    Assert.assertEquals(actualUrl , expectedUrl);
	    
		ts.findElement(By.name("assigntype")).click();
		ts.findElement(By.cssSelector("input[value='T']")).click() ;
		
		WebElement dropdown = ts.findElement(By.name("assigned_group_id"));
		
		wutil.handledropdown(dropdown,"Team Selling");
		
		//Select s2 = new Select(dropdown);
		
		//ts.findElement(By.xpath("//option[text()='Team Selling']")).click();
		
		ts.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
		//transfer the driver control from parent window to child window
		
		wutil.switchWindow(ts, "http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=");
		
//		for(String var : id) {
//			String actualUrl = ts.switchTo().window(var).getCurrentUrl();
//			String childUrl = "http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=";
//			
//			if(actualUrl.contains("childUrl")) {
//				
//			}
//		}
		
		
		
		
		//to enter the organization name in search textfeild
		ts.findElement(By.id("search_txt")).sendKeys(organization);
		//to click on search now button
		ts.findElement(By.name("search")).click();
		
		ts.findElement(By.id("1")).click();
		
		//ts.findElement(By.xpath("//a[text()='Intel354']")).click();
		
		wutil.switchWindow(ts, "http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing");
		
		
		ts.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		
		//to take screenshot
		wutil.screenShot(ts, "contact");
		
//		 WebElement image = ts.findElement(By.cssSelector("img[src=\"themes/softed/images/user.PNG\"]"));
//		 wutil.mouseHover(ts,image);
//		 
//		 ts.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		
		
	}
	

}
