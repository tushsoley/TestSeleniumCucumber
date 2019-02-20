package nz.police.pega.firearms.stepdef;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import nz.police.pega.firearms.HelperMethods;
import nz.police.pega.firearms.pages.GenericObjectPage;
import nz.police.pega.firearms.pages.VisitPage;

public class VisitStepDef {
	public WebDriver driver;
	public Properties CONFIG;
	HelperMethods helperAction = new HelperMethods();
	
	
	public VisitStepDef(){
		driver = Hooks.driver;
		CONFIG = Hooks.CONFIG;
	}
	@When("^i complete visit details for \"([^\"]*)\"$")
	public void i_complete_visit_details_for(String activity) throws Throwable {
		VisitPage visitPage = PageFactory.initElements(driver, VisitPage.class);
		visitPage.enterPurposeOfVisit("Test Competetion");
		helperAction.selectElementList(visitPage.getActivity(), activity);
		if(!(activity.equalsIgnoreCase("Guided Hunting")||activity.equalsIgnoreCase("Independent Hunting"))){
			visitPage.enterCompetetionDetails(helperAction.addDaysToCurrentDate(40), helperAction.addDaysToCurrentDate(50));
		}
	}

	@When("^i select \"([^\"]*)\" for bringing firearms$")
	public void select_for_bringing_firearms(String answer) throws Throwable {
		VisitPage visitPage = PageFactory.initElements(driver, VisitPage.class);
		GenericObjectPage genericPage = PageFactory.initElements(driver, GenericObjectPage.class);
		visitPage.clickBringingFirearms(answer);
		genericPage.getContinueButton().click();
	}
}
