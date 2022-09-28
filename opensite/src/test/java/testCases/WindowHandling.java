package testCases;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowHandling {
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
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//a[@href='https://twitter.com/saucelabs']")).click();
		Thread.sleep(1000);
		String mainWindowHandle = driver.getWindowHandle();
		
		String mainTitle=
				  driver.getTitle();
				  
				  System.out.println("Heading of parent window is::::: " + mainTitle);
				 
				 
				 
		/*
		 * Set<String> allWindowHandles = driver.getWindowHandles(); Iterator<String>
		 * iterator = allWindowHandles.iterator(); while (iterator.hasNext()) { String
		 * ChildWindow = iterator.next(); if
		 * (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
		 * driver.switchTo().window(ChildWindow); //WebElement text =
		 * driver.findElement(By.id("sampleHeading")); String title = driver.getTitle();
		 * 
		 * System.out.println("Heading of child window is:::: " + title);
		 * 
		 * driver.switchTo().window(mainWindowHandle); String mainTitle=
		 * driver.getTitle();
		 * 
		 * System.out.println("Heading of parent window is::::: " + mainTitle);
		 * 
		 * 
		 * } else { } }
		 */
	//	driver.findElement(By.xpath("//a[@href='www.facebook.com/saucelabs']")).click();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//a[@href='https://www.linkedin.com/saucelabs']")).click();
		
	}
}