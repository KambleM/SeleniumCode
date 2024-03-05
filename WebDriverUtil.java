package commonUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtil {
	
	
	
	
	public void maximize(WebDriver ts) {
		
		ts.manage().window().maximize();
	}
	
	public void implicitWait(WebDriver ts) {
		ts.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	public void handledropdown( WebElement ele , String targetedelement) {
		Select s = new Select(ele);
		s.selectByVisibleText(targetedelement);
	}

	public void mouseHover(WebDriver ts2, WebElement image) {
		Actions a = new Actions(ts2);
		a.moveToElement(image);
		a.perform();
		
	}
	
	public void switchWindow(WebDriver ts , String expectedUrl) {
		Set<String> id = ts.getWindowHandles();
		for(String var : id) {
			String actualUrl = ts.switchTo().window(var).getCurrentUrl();
			//String expectedUrl = "http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=";
			
			if(actualUrl.contains(expectedUrl)) {
				break;
			}
		}
	}
	public File screenShot(WebDriver ts , String screenshotName) throws IOException {
		TakesScreenshot ss = (TakesScreenshot)ts;
		File tempFile = ss.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("./Screenshot/" + screenshotName + ".png");
		FileUtils.copyFile(tempFile, destinationFile);
		return destinationFile;
	}
}
