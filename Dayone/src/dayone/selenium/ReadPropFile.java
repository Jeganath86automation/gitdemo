package dayone.selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadPropFile {

	static WebDriver driver;

	public static void main(String[] args) throws IOException {
		

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
		
	}

}
