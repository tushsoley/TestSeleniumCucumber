package nz.police.pega.firearms.stepdef;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.When;
import nz.police.pega.firearms.HelperMethods;
import nz.police.pega.firearms.pages.GenericObjectPage;
import nz.police.pega.firearms.pages.SecurityPage;

public class SecurityStepDef {
	public WebDriver driver;
	public Properties CONFIG;
	HelperMethods helperAction = new HelperMethods();
	
	
	public SecurityStepDef(){
		driver = Hooks.driver;
		CONFIG = Hooks.CONFIG;
	}
	
	@When("^i enter security questions as \"([^\"]*)\"$")
	public void i_enter_security_questions_as(String answer) throws Throwable {
		SecurityPage securityPage = PageFactory.initElements(driver, SecurityPage.class);
		GenericObjectPage genericPage = PageFactory.initElements(driver, GenericObjectPage.class);
		if(answer.equalsIgnoreCase("yes")){
			securityPage.clickStoreFirearmsYes();
			securityPage.enterPersonDetails("TestF","TestL","Test@test.com","A1234567");
		}else if(answer.equalsIgnoreCase("no")){
			securityPage.clickStoreFirearmsNo();
			securityPage.enterStorageArrangements("Name_Address_contact");
		}
		genericPage.getContinueButton().click();		
	}
	
}
