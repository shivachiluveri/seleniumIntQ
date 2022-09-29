package testCases2;
/*
 * Switch to/close desired child window, parent windows
*/
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleMultipleWindows {

	public static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		
		String parentWindow = driver.getWindowHandle();

		Set<String> handles = driver.getWindowHandles();// set does not maintain the order so convert to list
		List<String> hList = new ArrayList<String>(handles);

	}
	
	static void switchToParentWindow(String parentWindow) {
		driver.switchTo().window(parentWindow);
		
		
	}
	static void closeAllChildWindows(List<String> hList, String parentWindow) {
		for(String e : hList) {
			if(!e.equals(parentWindow)) {
				driver.switchTo().window(e).close();
			}
		}
		
	}

	public static boolean switchToRightWindow(String windowTitle, List<String> hList) {
		for (String e : hList) {
			String title = driver.switchTo().window(e).getTitle();
			if (title.contains(windowTitle)) {
				System.out.println("found right window");
				return true;
			}
		}

		return false;

	}

}
