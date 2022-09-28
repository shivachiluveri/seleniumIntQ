package testCases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import org.apache.commons.io.FileUtils;


public class RobotClassPractice {
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
		driver.get("https://www.saucedemo.com/");

		String st = driver.getTitle();
		System.out.println("Page title is : " + st);
		   boolean verifyTitle = driver.getTitle().equalsIgnoreCase("Swag Labs");

	        Assert.assertTrue(verifyTitle);

		// Assert.assertEquals("Swag Labs",st);
	//	SoftAssert softAssert = new SoftAssert();
	//	softAssert.assertEquals(st, "Swag Labs1");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
		Thread.sleep(1000);
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='login-button']")).isSelected());
		driver.findElement(By.xpath("//input[@placeholder=\"Password\"]")).sendKeys("secret_sauce");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id=\"login-button\"]")).click();
       
		//softAssert.assertAll();
       

	}
	
	
	
public static void screenshot() throws IOException {
	 TakesScreenshot scrShot =((TakesScreenshot)driver);
     File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
     File DestFile=new File("C:\\Selenium\\ss.png");
     FileUtils.copyFile(SrcFile, DestFile);
	}


public static void robotClass() {
	//Robot robot = new Robot();
	
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}