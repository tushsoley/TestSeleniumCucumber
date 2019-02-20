package nz.police.pega.firearms.stepdef;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nz.police.pega.firearms.HelperMethods;
import nz.police.pega.firearms.pages.GenericObjectPage;
import nz.police.pega.firearms.pages.TheoryTestPage;

public class TheoryTestStepDef {
	public WebDriver driver;
	public Properties CONFIG;
	HelperMethods helperAction = new HelperMethods();
	
	
	public TheoryTestStepDef(){
		driver = Hooks.driver;
		CONFIG = Hooks.CONFIG;
	}
	
	@When("^i complete theory test$")
	public void i_complete_theory_test() {
		TheoryTestPage TheoryTestpage = PageFactory.initElements(driver, TheoryTestPage.class);
		TheoryTestpage.clickTakeTestCorrectly();
		TheoryTestpage.clickSubmit();		
	}

	@Then("^i should see theory test results$")
	public void i_should_see_theory_test_results() throws Throwable {
		TheoryTestPage TheoryTestpage = PageFactory.initElements(driver, TheoryTestPage.class);
		GenericObjectPage genericPage = PageFactory.initElements(driver, GenericObjectPage.class);
		//added sleep to make it working need to find right solution as text does not match when no sleep
		Thread.sleep(1000);
		helperAction.verifyTextPartially(TheoryTestpage.getResultText(),"Congratulations, you have achieved the required pass rate of 100%.");
		genericPage.getContinueButton().click();
		
	}
}
