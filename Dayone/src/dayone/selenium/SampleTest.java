package dayone.selenium;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Automation Scripts\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://mtest.whatuni.com/");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(text(), 'ALLOW ALL')]")).click();
		Thread.sleep(3000);		
		driver.findElement(By.xpath("//a[@id='loglink']//span[contains(text(), 'Sign up')]")).click();
		Thread.sleep(3000);		
		driver.findElement(By.xpath("//a[contains(text(), 'FACEBOOK')]")).click();
		Set<String> handler=driver.getWindowHandles();
		Iterator<String> It=handler.iterator();
		String parentID=It.next();
		System.out.println("Parent ID is:"+ parentID);
		
		String childID=It.next();
		System.out.println("Child ID is:"+ childID);
		
		driver.switchTo().window(childID);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("jeganath.bj@gmail.com");
		//driver.findElement(By.id("email")).sendKeys("jeganath.bj@gmail.com");
		System.out.println("Child window title is: "+ driver.getTitle());
		driver.close();
		driver.switchTo().window(parentID);
		System.out.println("Parent window title is: "+ driver.getTitle());
		driver.close();

	}

}
