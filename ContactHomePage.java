package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactHomePage {
	
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement getContacts;
	
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement getplus;

	public WebElement getGetContacts() {
		return getContacts;
	}

	public WebElement getGetplus() {
		return getplus;
	}
	
	@FindBy(css="img[src='themes/softed/images/user.PNG']")
	private WebElement img;

	public WebElement getImg() {
		return img;
	}
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signout;
	
	public WebElement getSignout() {
		return signout;
	}
	
	

}
