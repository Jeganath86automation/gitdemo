	package dayone.selenium;

import javax.jws.soap.SOAPBinding.Style;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDayOne {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Automation Scripts\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Realme 5");
		WebElement srchbn=driver.findElement(By.id("nav-search-submit-button"));
		Thread.sleep(3000);
		drawborder(srchbn, driver);
		Thread.sleep(7000); 
		driver.navigate().to("https://www.google.com");		
		driver.navigate().back();
		driver.close();
	}
		
		public static void drawborder(WebElement element, WebDriver driver)
		{
			JavascriptExecutor js=((JavascriptExecutor)driver);
			js.executeScript("arguments[0].style.border='13px solid blue'",element);
		}
		
	}


