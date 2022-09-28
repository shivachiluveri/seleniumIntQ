package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;

public class ElementHidden {
	public static void main(String[] args) {
      System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
      WebDriver driver = new ChromeDriver();
      //implicit wait
    //  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

      
      //URL launch
      driver.get("https://courses.letskodeit.com/practice");
      // identify element and click
      driver.findElement(By.id("hide-textbox")).click();
      // Javascript executor class with executeScript method
      JavascriptExecutor j = (JavascriptExecutor) driver;
      // identify element and set value
      j.executeScript
      ("document.getElementById('displayed-text').value='Selenium';");
      String s = (String) j.executeScript("return    document.getElementById('displayed-text').value");
      System.out.print("Value entered in hidden field: " +s);
      //driver.close();
   }
}