package dayone.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BootstrapDropdown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Automation Scripts\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://getbootstrap.com/docs/4.0/components/dropdowns/");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement bsdrpdown=driver.findElement(By.xpath("//button[@id='dropdownMenuButton']"));
		Actions action=new Actions(driver);
		action.moveToElement(bsdrpdown).click().build().perform();
		List<WebElement> list=driver.findElements(By.xpath("//div[@class='dropdown-menu show' and @aria-labelledby='dropdownMenuButton']//a"));
		System.out.println(list.size());
		
		for(int i=0; i<list.size();i++){
			System.out.println(list.get(i).getText());
			if(list.get(i).getText().contains("Another action")){
				list.get(i).click();
				}
		}
	}

}
