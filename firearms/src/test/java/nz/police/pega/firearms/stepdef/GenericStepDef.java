package nz.police.pega.firearms.stepdef;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Then;
import nz.police.pega.firearms.HelperMethods;
import nz.police.pega.firearms.pages.GenericObjectPage;

public class GenericStepDef {
	public WebDriver driver;
	public Properties CONFIG;
	HelperMethods helperAction = new HelperMethods();
	
	
	public GenericStepDef(){
		driver = Hooks.driver;
		CONFIG = Hooks.CONFIG;
	}
	@Then("^i should see application status as \"([^\"]*)\"$")
	public void i_should_see_application_status_as(String arg1) throws Throwable {
		GenericObjectPage genericPage = PageFactory.initElements(driver, GenericObjectPage.class);
		helperAction.verifyText(genericPage.getApplicationStatus(),arg1);
	}
}
