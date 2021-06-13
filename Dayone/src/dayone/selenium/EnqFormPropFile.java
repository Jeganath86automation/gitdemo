package dayone.selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class EnqFormPropFile {
 
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
		String pagetitle=driver.getTitle();
		if(pagetitle.equalsIgnoreCase(prop.getProperty("pagetitle")))
				{
			DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy h-m-s");
	        Date date = new Date();
			System.out.println("Page is redirected to 404 page");
			File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, new File("D:/Automation Scripts/Dayone/src/dayone/selenium/404error "+dateFormat.format(date)+".jpg" ));
			driver.close();
				}else
				{
					System.out.println("Page is loaded fine");
				}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(prop.getProperty("topnvalenicon_xpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("topnavsrch_xpath"))).sendKeys(prop.getProperty("topnavsearch"));
		driver.findElement(By.xpath("//ul[@id='topNvUnivUl']//li//a//descendant::span[@id='univ_0']")).click();
		driver.findElement(By.xpath(prop.getProperty("cibutton_xpath"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(prop.getProperty("allwall_xpath"))).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("enqfirstname_xpath"))).sendKeys(prop.getProperty("enqfirstname"));
		driver.findElement(By.xpath(prop.getProperty("enqlasttname_xpath"))).sendKeys(prop.getProperty("enqlastname"));
		driver.findElement(By.xpath(prop.getProperty("enqemailaddress_xpath"))).sendKeys(prop.getProperty("enqemailaddress"));
		Thread.sleep(2000);
		WebElement countryofresidence=driver.findElement(By.xpath(prop.getProperty("cor_xpath")));
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);", countryofresidence);
		Thread.sleep(3000);
		Select corval=new Select(driver.findElement(By.xpath(prop.getProperty("cor_xpath"))));
		corval.selectByVisibleText("Cambodia");
		driver.findElement(By.xpath(prop.getProperty("coc_xpath"))).click();
		Select phonetype=new Select(driver.findElement(By.xpath(prop.getProperty("phonetype_xpath"))));
		phonetype.selectByIndex(1);
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("mobnumber_xpath"))).click();  
		driver.findElement(By.xpath(prop.getProperty("mobnumber_xpath"))).sendKeys("1234567890");
		Select stdlvl=new Select(driver.findElement(By.xpath(prop.getProperty("studylevl_xapth"))));
		stdlvl.selectByVisibleText("Undergraduate");
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Select subj=new Select(driver.findElement(By.xpath(prop.getProperty("subject_xpath"))));
		subj.selectByVisibleText("Agriculture");
		Select year=new Select(driver.findElement(By.xpath(prop.getProperty("startyear_xpath"))));
		year.selectByVisibleText("2021");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Select month=new Select(driver.findElement(By.xpath(prop.getProperty("startmonth_xpath"))));
		month.selectByVisibleText("December");
		
		}
	
	

}
