package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsInfoPage {
	
	@FindBy(name="firstname")
	private WebElement getFirstName;
	
	@FindBy(name="lastname")
	private WebElement getLastName;
	
	@FindBy(xpath="(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement getPlus;
	
	@FindBy(xpath="//a[text()='Intel354']")
	private WebElement getOrg;
	
	@FindBy(id="search_txt")
	private WebElement getTextfeild;
	
	public WebElement getGetTextfeild() {
		return getTextfeild;
	}

	@FindBy(name="account_name")
	private WebElement getName;
	
	public WebElement getGetName() {
		return getName;
	}

	public WebElement getGetOrg() {
		return getOrg;
	}

	@FindBy(xpath="(//input[@name='assigntype'])[2]")
	private WebElement getGroupButton;
	
	@FindBy(name="assigned_group_id")
	private WebElement dropdown;
	
	@FindBy(name="button")
	private WebElement getSave;
	
	@FindBy(name="search")
	private WebElement search;
	
	@FindBy(id="1")
	private WebElement id;

	public WebElement getId() {
		return id;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getGetFirstName() {
		return getFirstName;
	}

	public WebElement getGetLastName() {
		return getLastName;
	}

	public WebElement getGetPlus() {
		return getPlus;
	}

	public WebElement getGetGroupButton() {
		return getGroupButton;
	}

	public WebElement getDropdown() {
		return dropdown;
	}

	public WebElement getGetSave() {
		return getSave;
	}

}
