package testCases2;

/*
 * Handle tricky iframe Shadow Root WebElement using Selenium
 * https://www.youtube.com/watch?v=0R0erfuJ76g
 * https://www.youtube.com/watch?v=Gqc8Rq3KdPM
*/
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameShadowDOM {

	public static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		driver.manage().window().maximize();
		String st = driver.getTitle();
		System.out.println("Page title is : " + st);
		driver.switchTo().frame("pact");
	//	driver.switchTo().parentFrame();
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebElement element = (WebElement)jse.executeAsyncScript
				("return document.querySelector(\"#snacktime\").shadowRoot.querySelector(\"#tea\")");
		
		String js = "arguments[0].setAttribute('value','ilachi tea')";
		jse.executeScript(js, element);
		
		

	}

}
