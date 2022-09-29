package apachePOI;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.*;

public class InitializeDriver {
	public static WebDriver driver;
	public static Properties prop;
	public ExtentReports report;
	public ExtentTest logger;
	public ExtentTest parentLogger;

	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"D:\\ipCybris.automation\\IPCybris_Automation\\globalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		System.out.println("Browser is::" + browserName);

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"D:\\ipCybris.automation\\IPCybris_Automation\\BrowserServers\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"D:\\ipCybris.automation\\IPCybris_Automation\\BrowserServers\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "E:\\IPCybris_Automation\\BrowserServers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

	public void getScreenshot(WebDriver driver, String screenName) throws IOException {
		// File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// FileUtils.copyFile(src, new
		// File("E:\\java_workspace\\IPCybris\\Screenshots"+result+"screenshot.png"));
		TakesScreenshot pic = (TakesScreenshot) driver;
		File src = pic.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./Screenshots/" + screenName + ".png"));
		System.out.println("screenshot taken");

	}

}
