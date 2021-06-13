package dayone.selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class LoginFromPropFile {

	static WebDriver driver;
	public static void main(String[] args) throws IOException, InterruptedException {
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("D:/Automation Scripts/Dayone/src/dayone/selenium/Testdata.properties");
		prop.load(fis);
		
		String browserName=prop.getProperty("browser");
		String url=prop.getProperty("url");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "D:\\Automation Scripts\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		}else if(browserName.equals("firefox")){   
			System.setProperty("webdriver.gecko.driver", "D:\\Automation Scripts\\Selenium\\geckodriver-v0.29.1-win64\\geckodriver.exe");
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		}
		driver.get(url);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(prop.getProperty("avatarimg_xpath"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(prop.getProperty("notregistered_xpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("emailadress_xpath"))).sendKeys(prop.getProperty("emailaddress"));
		driver.findElement(By.xpath(prop.getProperty("registerbtn_xpath"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("firstname_xpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("firstname_xpath"))).sendKeys(prop.getProperty("firstname"));
		driver.findElement(By.xpath(prop.getProperty("lastname_xpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("lastname_xpath"))).sendKeys(prop.getProperty("lastname"));
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("passwod_xpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("passwod_xpath"))).sendKeys(prop.getProperty("password"));
		Thread.sleep(3000);
		WebElement newltrflg=driver.findElement(By.xpath(prop.getProperty("newsltrflg_xpath")));
		 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", newltrflg);
		 Thread.sleep(3000);
		 Actions action=new Actions(driver);
		 action.moveToElement(newltrflg).click().build().perform();
		 generateAlet(driver, "The newsleeter flag is not clickable");
		 Thread.sleep(5000);
		 Alert aler=driver.switchTo().alert();
		 aler.accept();
		driver.findElement(By.xpath(prop.getProperty("t&Cflag_xpath"))).click();
		/*WebElement regbtn=driver.findElement(By.xpath(prop.getProperty("registerbtn")));
		if(regbtn.isEnabled()){
			regbtn.click();
		}
				else
				{
					System.out.println("Button not clickable");
				}*/
				
				}
	
	public static void generateAlet(WebDriver driver, String message){

		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("alert('"+message+"')");
	}
	}
				

		
		


