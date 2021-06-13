package dayone.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FindElementsconcept {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Automation Scripts\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://mtest.hotcoursesabroad.com/?nr=y&geolocation=30");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		List <WebElement> linkslist=driver.findElements(By.tagName("a"));
		System.out.println(linkslist.size());
		for(int i=0;i<linkslist.size();i++ ){
			String linkstext=linkslist.get(i).getText();
			System.out.println(linkstext);
		}
	}

}
