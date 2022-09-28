package interviewTestCases;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import org.apache.commons.io.FileUtils;

public class ExpectdConditions {
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
		driver.get("http://demo.guru99.com/test/delete_customer.php");
		String st = driver.getTitle();
		System.out.println("Page title is : " + st);
		boolean verifyTitle = driver.getTitle().equalsIgnoreCase("Delete Customer");
		Assert.assertTrue(verifyTitle);
		driver.manage().window().maximize();
		clickOnTab("Agile Project");
	}
	public static void clickOnTab(String tab) {
	
	}
}


