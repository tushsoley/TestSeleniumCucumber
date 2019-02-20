package nz.police.pega.firearms.stepdef;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.When;
import nz.police.pega.firearms.HelperMethods;
import nz.police.pega.firearms.pages.GenericObjectPage;
import nz.police.pega.firearms.pages.TravelPage;

public class TravelStepDef {
	public WebDriver driver;
	public Properties CONFIG;
	HelperMethods helperAction = new HelperMethods();
	
	
	public TravelStepDef(){
		driver = Hooks.driver;
		CONFIG = Hooks.CONFIG;
	}
	
	@When("^i complete Travel details for \"([^\"]*)\"$")
	public void i_complete_Travel_details(String type) throws Throwable {
		TravelPage travelPage = PageFactory.initElements(driver, TravelPage.class);
		GenericObjectPage genericPage = PageFactory.initElements(driver, GenericObjectPage.class);
		travelPage.clickArrivalType(type);
		helperAction.selectElementList(travelPage.getArrivalAirport(), "Auckland");
		travelPage.enterArrivalFlightDetails("SQ689", "Singapore Airline");
		travelPage.clickDepartureType(type);
		helperAction.selectElementList(travelPage.getDepartureAirport(), "Auckland");
		travelPage.enterDepartureFlightDetails("SQ689", "Singapore Airline");
		genericPage.getContinueButton().click();
	}
}
