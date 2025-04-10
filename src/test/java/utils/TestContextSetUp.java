package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;


public class TestContextSetUp {
	public WebDriver driver;
	public TestBase testBase;
	public GenericUtils genericUtils;
	public String landingPageProductName; 
	
	public TestContextSetUp() throws IOException {
		
		testBase = new TestBase();
		this.driver =testBase.driver; //pointing driver in this class to testBase class driver
		genericUtils = new GenericUtils(this.driver);
		
	}

}
