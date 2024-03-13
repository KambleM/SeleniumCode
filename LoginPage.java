package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//identify username tf
	@FindBy(name="user_name")
	 private WebElement usernametf;
	
	//identify password tf
	@FindBy(name="user_password")
	private WebElement passwordtf;
	
	//identify login button
	@FindBy(id="submitButton")
	private WebElement loginbtn;

	public WebElement getUsernametf() {
		return usernametf;
	}

	public WebElement getPasswordtf() {
		return passwordtf;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	//create a constructor-initialize webelement
	public LoginPage(WebDriver ts) {
		PageFactory.initElements(ts, this);
	}
	
	//create method---to perform the action
	public void Login(String usernameData , String passwordData) {
		usernametf.sendKeys(usernameData);
		passwordtf.sendKeys(passwordData);
		loginbtn.click();
		
	}

}
