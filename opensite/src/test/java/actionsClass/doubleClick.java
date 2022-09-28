package actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class doubleClick {
	public static WebDriver driver;

	public static void doubleClick() {
		driver.get("URL of target website or webpage"); // Define the URL of the target website.
		Actions act = new Actions(driver);

		// Double click on element
		WebElement ele = driver.findElement(By.xpath("XPath of the element"));
		act.doubleClick(ele).perform();
	}

	public static void rightClick() {
		driver.get("URL of target website or webpage"); // Define the URL of the target website.
		Actions act = new Actions(driver);

		// Double click on element
		WebElement ele = driver.findElement(By.xpath("XPath of the element"));
		act.contextClick(ele).perform();
	}

}

