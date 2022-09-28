package interviewTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomExpCondition {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.tutorialspoint.com/about/about_careers.htm");
		// identify element
		WebElement l = driver.findElement(By.linkText("Team"));
		l.click();
		// object of WebDriverWait class with wait time
		WebDriverWait w = new WebDriverWait(driver, null);
				//WebDriverWait(driver, 7);
		// custom expected condition with until method
		w.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				// identify paragraph
				WebElement e = driver.findElement(By.tagName("p"));
				if (e != null) {
					// to check if paragraph is displayed and has text India
					if (e.isDisplayed() && e.getText().contains("India")) {
						System.out.println("Element found");
						return true;
					} else {
						System.out.println("Element not found");
						return false;
					}
				}
				return false;
			}
		});
		driver.close();
	}
}