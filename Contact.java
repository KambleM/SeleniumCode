package commonUtils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Contact {
	
	PropertyFileUtil putil = new PropertyFileUtil();
	WebDriverUtil wutil = new WebDriverUtil();
	ExcelUtil eutil = new ExcelUtil();
	JavaUtil jutil = new JavaUtil();
	
	
	@Test
	
	public void contactTest() throws IOException, InterruptedException {
		
		WebDriver ts = new ChromeDriver();
	    //to maximize the window
		wutil.maximize(ts);
		//apply wait for implicitwait();
		wutil.implicitWait(ts);
		
		String URL = putil.getDataFromPropertyFile("Url");
		String USERNAME = putil.getDataFromPropertyFile("Username");
		String PASSWORD = putil.getDataFromPropertyFile("Password");
		
		String fn = eutil.getDataFromExcel("Contacts",0 ,1);
		String ln = eutil.getDataFromExcel("Contacts", 1, 1);
		String ab = eutil.getDataFromExcel("Contacts", 2, 1);
		
		
		ts.get(URL);
		ts.findElement(By.name("user_name")).sendKeys(USERNAME);
		ts.findElement(By.name("user_password")).sendKeys(PASSWORD);
		ts.findElement(By.id("submitButton")).click();
		//click on plus
		ts.findElement(By.xpath("//a[text()='Contacts']")).click();
		ts.findElement(By.cssSelector("img[alt = 'Create Contact...']")).click();
		//input feild
		ts.findElement(By.name("firstname")).sendKeys(fn);
		ts.findElement(By.name("lastname")).sendKeys(ln);
		ts.findElement(By.name("assigntype")).click();
		ts.findElement(By.cssSelector("input[value='T']")).click() ;
		
		WebElement dropdown = ts.findElement(By.name("assigned_group_id"));
		
		Select s2 = new Select(dropdown);
		
		ts.findElement(By.xpath("//option[text()='Team Selling']")).click();
		
		
		
		
		
	}

}
