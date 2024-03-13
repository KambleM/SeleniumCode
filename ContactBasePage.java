package basicpom;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import commonUtils.ExcelUtil;
import commonUtils.JavaUtil;
import commonUtils.PropertyFileUtil;
import commonUtils.WebDriverUtil;
import pom.ContactHomePage;
import pom.ContactsInfoPage;
import pom.LoginPage;


     
public class ContactBasePage {
	static  WebDriver ts;
	public static void main(String[] args) throws IOException {
		
        PropertyFileUtil util = new PropertyFileUtil();
	    ExcelUtil eutil = new ExcelUtil();
	    WebDriverUtil wutil = new WebDriverUtil();
	    JavaUtil jutil = new JavaUtil();
		
		String BROWSER = util.getDataFromPropertyFile("Browser");
		
		String URL = util.getDataFromPropertyFile("Url");
		
		String USERNAME = util.getDataFromPropertyFile("Username");
		String PASSWORD = util.getDataFromPropertyFile("Password");
		
		//to read data from excel file
		String fn = eutil.getDataFromExcel("Contacts", 0, 1);
		String ln = eutil.getDataFromExcel("Contacts", 1, 1);
		String org = eutil.getDataFromExcel("Contacts", 3, 1);
		String assignTo = eutil.getDataFromExcel("Contacts", 2, 1);
		
		
		//to launch the browser
		
		if(BROWSER.equals("Chrome")) {
			ts = new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("Edge")) {
			ts = new EdgeDriver();
		}else {
			ts = new FirefoxDriver();
		}
		ts.manage().window().maximize();
		ts.get(URL);
		
		//create object of LoginPage
		LoginPage lp = new LoginPage(ts);
		
		//to initialize the webelement;
		PageFactory.initElements(ts, lp);
		lp.getUsernametf().sendKeys(USERNAME);
		//Thread.sleep(2000);
		//ts.navigate().refresh();
		//lp.getUsernametf().sendKeys("user");
  	    lp.getPasswordtf().sendKeys(PASSWORD);
		lp.getLoginbtn().click();
		
		//homepage of contact
		ContactHomePage chp = new ContactHomePage();
		PageFactory.initElements(ts, chp);
		chp.getGetContacts().click();
		chp.getGetplus().click();
		
		
		ContactsInfoPage cip = new ContactsInfoPage();
		PageFactory.initElements(ts, cip);
		cip.getGetFirstName().sendKeys(fn);
		cip.getGetLastName().sendKeys(ln);
		cip.getGetPlus().click();
		//cip.getGetOrg().click();
		
		Set<String> id = ts.getWindowHandles();
		
        wutil.switchWindow(ts, "http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=");
		
        cip.getGetTextfeild().sendKeys(org);
		
        cip.getSearch().click();
		
        cip.getId().click();
        
    	wutil.switchWindow(ts, "http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing");
		cip.getGetGroupButton().click();
		
		cip.getDropdown().sendKeys(assignTo);
		
		cip.getGetSave().click();
		
		wutil.mouseHover(ts, chp.getImg());
		
		chp.getSignout().click();
	

}
}
