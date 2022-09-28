package testCases;

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

public class AlertsHandling {
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
		// Assert.assertEquals("Swag Labs",st);
		// SoftAssert softAssert = new SoftAssert();
		// softAssert.assertEquals(st, "Swag Labs1");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name=\"cusid\"]")).sendKeys();
		driver.findElement(By.xpath("//input[@name=\"submit\"]")).click();
		// driver.findElement(By.xpath("//input[@name=\"submit\"]")).submit();
		Thread.sleep(1000);
		// driver.findElement(By.xpath("//input[@id=\"login-button\"]")).click();
		// softAssert.assertAll();
		driver.switchTo().alert().accept();
		String s = driver.switchTo().alert().getText();
	System.out.println(s);
	
	String mainWindowHandle  = driver.getWindowHandle();
	
    Set<String> allWindowHandles = driver.getWindowHandles();

    
    Iterator<String> iterator = allWindowHandles.iterator();

    while (iterator.hasNext()) {
        String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
            driver.switchTo().window(ChildWindow);
            WebElement text = driver.findElement(By.id("sampleHeading"));
            System.out.println("Heading of child window is " + text.getText());
        
            }else {
            	}
            
    }}

	public static void alerts() {
		driver.switchTo().alert().dismiss();
		driver.switchTo().alert().accept();
		driver.switchTo().alert().getText();
		driver.switchTo().alert().sendKeys("Text");

	}

	public static void robotClass() {

	}

}