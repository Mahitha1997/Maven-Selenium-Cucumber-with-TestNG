package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetUp;

public class Hooks {
	TestContextSetUp TestContextSetup;
	WebDriver driver;

	public Hooks(TestContextSetUp TestContextSetup) {
		this.driver= TestContextSetup.driver;
		this.TestContextSetup =TestContextSetup;
		
	}
	
	@AfterStep
	public void AddScreenshot(Scenario scenario) {
		if(scenario.isFailed()) {
			byte[] sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourceFile, "image/png", "image");
		}
		
	}
	
	
	@After
	public void TearDown() {
		driver.close();
		driver.quit();
		
	}
}
