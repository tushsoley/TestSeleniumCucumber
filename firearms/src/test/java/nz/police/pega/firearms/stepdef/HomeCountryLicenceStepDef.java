package nz.police.pega.firearms.stepdef;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nz.police.pega.firearms.HelperMethods;
import nz.police.pega.firearms.pages.GenericObjectPage;
import nz.police.pega.firearms.pages.HomeCountryLicencePage;

public class HomeCountryLicenceStepDef {

	public WebDriver driver;
	public Properties CONFIG;
	HelperMethods helperAction = new HelperMethods();
	
	
	public HomeCountryLicenceStepDef(){
		driver = Hooks.driver;
		CONFIG = Hooks.CONFIG;
	}
	
		
	@Then("^i should see my home country as \"([^\"]*)\"$")
	public void i_should_see_my_home_country_as(String country) throws Throwable {
		HomeCountryLicencePage homeCountryPage = PageFactory.initElements(driver, HomeCountryLicencePage.class);
		helperAction.verifyText(homeCountryPage.getHomeCountry(), country);
	}

	@When("^i enter home country licence details$")
	public void i_enter_home_country_licence_details() throws Throwable {
		HomeCountryLicencePage homeCountryPage = PageFactory.initElements(driver, HomeCountryLicencePage.class);
		GenericObjectPage genericPage = PageFactory.initElements(driver, GenericObjectPage.class);
		homeCountryPage.enterLicenceDetails();
		homeCountryPage.clickAttachLicenceCopy();
		helperAction.attachAFile(genericPage.getSelectFile(), "C:\\Users\\tusharso\\Desktop\\police2.png");
		genericPage.clickAttach();
		Thread.sleep(2000);
		genericPage.getContinueButton().click();
	}

}
