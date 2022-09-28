package actionsClass;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover1 {

	public static WebDriver driver;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/menu/"); 
		System.out.println("demoqa webpage Displayed");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Actions actions = new Actions(driver);
		WebElement menuOption = driver.findElement(By.xpath(".//div[contains(text(),'Music')]"));
		actions.moveToElement(menuOption).perform();
		System.out.println("Done Mouse hover on 'Music' from Menu");
		WebElement subMenuOption = driver.findElement(By.xpath(".//div[contains(text(),'Rock')]"));
		actions.moveToElement(subMenuOption).perform();
		System.out.println("Done Mouse hover on 'Rock' from Menu");
		WebElement selectMenuOption = driver.findElement(By.xpath(".//div[contains(text(),'Alternative')]"));
		selectMenuOption.click();
		System.out.println("Selected 'Alternative' from Menu");
//		driver.close();
	}

}	