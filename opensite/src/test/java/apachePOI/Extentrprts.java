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

public class Extentrprts {
	public static WebDriver driver;
	public ExtentReports report;
	public ExtentTest logger;
	public ExtentTest parentLogger;

	@BeforeSuite
	public void setUpSuite() throws Exception {
		ExtentSparkReporter extent = new ExtentSparkReporter("D:\\html" + "htmlName" + ".html");
		// extent.setAppendExisting(true);
		report = new ExtentReports();
		report.attachReporter(extent);
	}

	@AfterSuite
	public void tearD() {
		report.flush();
	}
}
