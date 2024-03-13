package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtils.WebDriverUtil;

public class HomePage extends WebDriverUtil
{

	
	//identify organizations
	@FindBy(xpath="(//a[text()='Organizations'])[1]")
	private WebElement org;
	
	//identify contacts
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contact;
	
	public WebElement getOrg() {
		return org;
	}

	public WebElement getContact() {
		return contact;
	}

	@FindBy(css="img[src='themes/softed/images/user.PNG']")
	private WebElement img;
	
	

	public WebElement getImg() {
		return img;
	}

	
	//mousehover on image
//	@FindBy(xpath ="//img[src=\"themes/softed/images/user.PNG\"]")
//	private WebElement image;
//	
	//identify sign out
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signout;
	
	public WebElement getSignout() {
		return signout;
	}
	//create constructor
	public HomePage(WebDriver ts) {
		PageFactory.initElements(ts, this);
	}
	
	public void home() {
		//click on orgnization
		org.click();
		
		
	}
	public void home(WebDriver ts) {
		mouseHover(ts, img);
		//click on signout button
		signout.click();
		
		
	}
	
}
