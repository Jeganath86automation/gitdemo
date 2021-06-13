package dayone.selenium;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksImages {

	public static void main(String[] args) throws MalformedURLException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Automation Scripts\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get("https://mtest.hotcoursesabroad.com/study/course/hongkong/bachelor-of-engineering-honours-civil-engineering/54774720/program.html?nr=y");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		List<WebElement> linklist = driver.findElements(By.tagName("a"));
		linklist.addAll(driver.findElements(By.tagName("img")));
		System.out.println("Total links and images in the page: " + linklist.size());

		List<WebElement> activelinks = new ArrayList<WebElement>();
		for (int i = 0; i < linklist.size(); i++) {
			System.out.println(linklist.get(i).getAttribute("href"));
			if (linklist.get(i).getAttribute("href") != null && (!linklist.get(i).getAttribute("href").contains("javascript"))) {
				activelinks.add(linklist.get(i));
			}
		}
		
		System.out.println("Total active links an images in the page: " + activelinks.size());
		
		for(int j=0;j<activelinks.size();j++){
			HttpsURLConnection connect=(HttpsURLConnection) new URL(activelinks.get(j).getAttribute("href")).openConnection();
			connect.connect();
			String response=connect.getResponseMessage();
			connect.disconnect();
			System.out.println(activelinks.get(j).getAttribute("href") +"====>"+ response);
			
		}
		

	}

}
