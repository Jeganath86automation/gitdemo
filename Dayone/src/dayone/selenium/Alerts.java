package dayone.selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Automation Scripts\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("file:///C:/Users/Jeganathan.B/Desktop/alertbox.html");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(2000);
		Alert alert= driver.switchTo().alert();
		Thread.sleep(2000);
		String alttext=driver.switchTo().alert().getText();
		System.out.println(alttext);
		alert.accept();
		driver.close();
		
		
		
		
		
	}

}
