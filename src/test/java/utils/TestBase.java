package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public WebDriver driver;
	
	public TestBase() throws IOException {
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "/src/test/resources/global.properties");
		Properties prop =new Properties();
		prop.load(fis);
		String url = prop.getProperty("url");
		//String browser = prop.getProperty("browser");
		
		String browser_properties = prop.getProperty("browser");
		String browser_maven=System.getProperty("browser");//Get browser value given from command line 
		// result = testCondition ? value1 : value2
		String browser = browser_maven!=null ? browser_maven : browser_properties;
		
		if(driver==null) {
			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/chromedriver.exe");
			    driver=new ChromeDriver();	
			}
			else if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/test/resources/firefoxdriver.exe");
			    driver=new FirefoxDriver();	
				
			}
			else if(browser.equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"/src/test/resources/edgedriver.exe");
			    driver=new EdgeDriver();	
				
			}
			
			driver.get(url);
			driver.manage().window().maximize();
			
		}
		
	}
}
