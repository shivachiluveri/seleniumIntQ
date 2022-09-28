package actionsClass;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import org.apache.commons.io.FileUtils;

public class SelectActions {
	public static WebDriver driver;

	/*
	 * public static void main(String args[]) throws InterruptedException,
	 * IOException { openBrowsere();
	 * 
	 * }
	 */

	@Test
	public static void openBrowsere() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/newtours/register.php");
		String st = driver.getTitle();
		selectDD();
	}
	public static void selectDD() {
		Select dd = new Select(driver.findElement(By.name("country")));
		List<WebElement> al = dd.getOptions();
		System.out.println(al.size());
		List<String> elementToSelect = new ArrayList();
		elementToSelect.add("INDIA");
		for(int i=0; i<=al.size();i++) {
		String	eDD = al.get(i).getText();
			String aDD = elementToSelect.get(0);
			if(eDD.equalsIgnoreCase(aDD)) {
				dd.selectByIndex(i);
				break;
				
			}
			
		}
	
	}
}