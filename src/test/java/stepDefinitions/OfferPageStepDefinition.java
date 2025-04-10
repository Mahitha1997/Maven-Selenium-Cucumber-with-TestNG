package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.OfferPage;
import utils.TestBase;
import utils.TestContextSetUp;
import utils.GenericUtils;

public class OfferPageStepDefinition {
	public WebDriver driver;
	public String offerPageProductName;
	TestContextSetUp TestContextSetup;
	OfferPage offerPage;
	LandingPage landingPage;
	GenericUtils genericUtils;
	
	public OfferPageStepDefinition(TestContextSetUp TestContextSetup) {
		
		this.driver=TestContextSetup.driver;
		genericUtils = TestContextSetup.genericUtils;
		this.TestContextSetup=TestContextSetup;
	}
	
	
	@Then("^user searched for (.+) shortname in offers page$")
	public void user_searched_for_beet_shortname_in_offers_page(String shortName) throws InterruptedException {
		
		offerPage =new OfferPage(driver);
		
		switchToOffersPage();
		offerPage.searchItem(shortName);
		Thread.sleep(2000);
		offerPageProductName = offerPage.getProductName();
		
	    
	}
	
	public void switchToOffersPage()
	{
		landingPage = new LandingPage(driver);
		landingPage.selectTopDealsPage();
		genericUtils.SwitchWindowToChild();
		
		
	}
	@Then("validate product name in offers page matches with Landing Page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() {
		System.out.println(offerPageProductName);
		System.out.println(TestContextSetup.landingPageProductName);
		Assert.assertEquals(offerPageProductName, TestContextSetup.landingPageProductName);
		
		
	}


}
