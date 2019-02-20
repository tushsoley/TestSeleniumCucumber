package nz.police.pega.firearms.stepdef;

import java.time.LocalDate;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import nz.police.pega.firearms.HelperMethods;
import nz.police.pega.firearms.pages.EligibilityPage;
import nz.police.pega.firearms.pages.GenericObjectPage;

public class EligibilityStepDef {
	public WebDriver driver;
	public Properties CONFIG;
	HelperMethods helperAction = new HelperMethods();
	EligibilityPage eligibilityPage = new EligibilityPage();
	
	
	public EligibilityStepDef(){
		driver = Hooks.driver;
		CONFIG = Hooks.CONFIG;
	}
	@When("^i complete eligibility questions for Approved country \"([^\"]*)\"$")
	public void i_complete_eligibility_questions_approved_country(String country) throws Throwable {		
		GenericObjectPage genericPage = PageFactory.initElements(driver, GenericObjectPage.class);
		helperAction.switchToFrame(eligibilityPage.getEligibilityFrame());
		//Select Country
		helperAction.selectElementList(eligibilityPage.getCountry(), country);
		eligibilityPage.selectAnswerCountryLicence("yes");
		eligibilityPage.enterTravelDates(helperAction.addDaysToCurrentDate(40), helperAction.addDaysToCurrentDate(50));		
		genericPage.getContinueButton().click();
		//helperAction.switchToDefaultContent();
	}
	
	@When("^I select country \"([^\"]*)\" on Eligibility Page$")
	public void i_select_a_on_Eligibility_Page(String country) {		
		helperAction.switchToFrame(eligibilityPage.getEligibilityFrame());
		helperAction.selectElementList(eligibilityPage.getCountry(), country);
		helperAction.switchToDefaultContent();
	}

	@Then("^I should see message for unapproved country \"([^\"]*)\"$")
	public void i_should_see_message_with(String message) throws InterruptedException {
		EligibilityPage eligibilityPage = PageFactory.initElements(driver, EligibilityPage.class);
		helperAction.switchToFrame(eligibilityPage.getEligibilityFrame());
		helperAction.verifyText(eligibilityPage.getUnapprovedCountryWarning(), message);
		helperAction.switchToDefaultContent();
	}

	@Then("^Total countries available for selection is \"([^\"]*)\"$")
	public void total_countries_available_for_selection_is(int count) throws Throwable {
		EligibilityPage eligibilityPage = PageFactory.initElements(driver, EligibilityPage.class);
		helperAction.switchToFrame(eligibilityPage.getEligibilityFrame());
		helperAction.verifyCountDropdownList(eligibilityPage.getCountry(),count);
		helperAction.switchToDefaultContent();
	}
}
