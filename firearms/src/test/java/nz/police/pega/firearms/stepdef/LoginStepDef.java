package nz.police.pega.firearms.stepdef;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import nz.police.pega.firearms.HelperMethods;
import nz.police.pega.firearms.pages.LoginAndHomePage;

public class LoginStepDef   
{
	public WebDriver driver;
	public Properties CONFIG;
	HelperMethods helperAction = new HelperMethods();
	
	
	public LoginStepDef(){
		driver = Hooks.driver;
		CONFIG = Hooks.CONFIG;
	}
		
	@Given("^i login as \"([^\"]*)\"$")
	public void i_login_as(String userType) throws Throwable {
		LoginAndHomePage loginPage = PageFactory.initElements(driver, LoginAndHomePage.class);
	    driver.get(CONFIG.getProperty("url"));
	    loginPage.enterLogin(CONFIG.getProperty("applicantUserName"), CONFIG.getProperty("applicantPassword"));
	    helperAction.switchToFrame(loginPage.getHomeFrame());
	    loginPage.initiateNewApplication();
	    helperAction.switchToDefaultContent();
	}
	
	@Then("^I verify that \"([^\"]*)\" message is displayed$")
	public void i_verify_that_message_is_displayed(String textToVerify) throws InterruptedException {
		helperAction.verifyTextOnPage(textToVerify);
	}

	
}
