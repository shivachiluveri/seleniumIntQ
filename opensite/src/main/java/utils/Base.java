package utils;

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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Base {

	public static WebDriver driver;
	public static Properties prop;
	public ExtentReports report;
	public ExtentTest logger;
	/*
	 * 
	 * @BeforeSuite public void setUpSuite() throws Exception{ ExtentHtmlReporter
	 * extent = new ExtentHtmlReporter("D:\\html" +"htmlName" + ".html"); report =
	 * new ExtentReports(); report.attachReporter(extent); }
	 */
	
	
	
	
	
	 public WebDriver initializeDriver() throws IOException {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("D:\\ipCybris.automation\\IPCybris_Automation\\globalData.properties");
			prop.load(fis);
			String browserName = prop.getProperty("browser");
			System.out.println("Browser is::" + browserName);

			if (browserName.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "D:\\ipCybris.automation\\IPCybris_Automation\\BrowserServers\\chromedriver.exe");
				driver = new ChromeDriver();

			} else if (browserName.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", "D:\\ipCybris.automation\\IPCybris_Automation\\BrowserServers\\geckodriver.exe");
				driver = new FirefoxDriver();

			} else if (browserName.equals("IE")) {
				System.setProperty("webdriver.ie.driver", "E:\\IPCybris_Automation\\BrowserServers\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}

			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();

			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
	
	
		/*
		 * public void emails() {
		 * 
		 * // Create object of Property file Properties props = new Properties();
		 * 
		 * // this will set host of server- you can change based on your requirement
		 * props.put("mail.smtp.host", "smtp.gmail.com");
		 * 
		 * // set the port of socket factorys props.put("mail.smtp.socketFactory.port",
		 * "465");
		 * 
		 * // set socket factory props.put("mail.smtp.socketFactory.class",
		 * "javax.net.ssl.SSLSocketFactory");
		 * 
		 * // set the authentication to true props.put("mail.smtp.auth", "true");
		 * 
		 * // set the port of SMTP server props.put("mail.smtp.port", "465");
		 * 
		 * // This will handle the complete authentication Session session =
		 * Session.getDefaultInstance(props,
		 * 
		 * new javax.mail.Authenticator() {
		 * 
		 * protected PasswordAuthentication getPasswordAuthentication() {
		 * 
		 * return new PasswordAuthentication("shiva.chiluveri@techolution.com",
		 * "sisback@87");
		 * 
		 * }
		 * 
		 * });
		 * 
		 * try {
		 * 
		 * // Create object of MimeMessage class Message message = new
		 * MimeMessage(session);
		 * 
		 * // Set the from address message.setFrom(new
		 * InternetAddress("shiva.chiluveri@techolution.com")); // Set the recipient
		 * address message.setRecipients(Message.RecipientType.TO,
		 * InternetAddress.parse("shivachiluveri@techolution.com")); //
		 * message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(
		 * "raghava.dyapa@techolution.com")); // Add the subject link
		 * message.setSubject("IPcybris QA"); // Create object to add multimedia type
		 * content BodyPart messageBodyPart1 = new MimeBodyPart(); // Set the body of
		 * email messageBodyPart1.setText("IPcybris Test Automation HTML Report"); //
		 * Create another object to add another content MimeBodyPart messageBodyPart2 =
		 * new MimeBodyPart(); // Mention the file which you want to send String
		 * filename = "E:\\java_workspace\\IPCybris\\Screenshots\\htmlReport.html"; //
		 * Create data source and pass the filename DataSource source = new
		 * FileDataSource(filename); // set the handler
		 * messageBodyPart2.setDataHandler(new DataHandler(source)); // set the file
		 * messageBodyPart2.setFileName(filename); Multipart multipart = new
		 * MimeMultipart(); // add body part 1 multipart.addBodyPart(messageBodyPart2);
		 * // add body part 2 multipart.addBodyPart(messageBodyPart1); // set the
		 * content message.setContent(multipart); // finally send the email
		 * Transport.send(message); System.out.println("=====Email Sent====="); } catch
		 * (MessagingException e) { throw new RuntimeException(e); } }
		 */
		@AfterMethod(enabled = true)
	    public void tearD(){
		    report.flush();
	    }

	public String name() {
		String fn;
		String text = "abcdefghijklmnopqrstuvwxyz";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 4) {
			int index = (int) (rnd.nextFloat() * text.length());
			salt.append(text.charAt(index));
		}
		fn = salt.toString();
		return fn;
	}
		public String phoneNum() {
			String phone;
			String nums = "0123456789";
			StringBuilder salt1 = new StringBuilder();
			Random rnd = new Random();
			while (salt1.length() < 10) {
				int index = (int) (rnd.nextFloat() * nums.length());
				salt1.append(nums.charAt(index));
			}
			phone = salt1.toString();
			return phone;
		}
	}
