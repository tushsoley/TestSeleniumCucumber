package nz.police.pega.firearms.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import nz.police.pega.firearms.HelperMethods;
import nz.police.pega.firearms.stepdef.Hooks;

public class TravelPage {
	public WebDriver driver;
	HelperMethods helperAction = new HelperMethods();
	 
	public TravelPage(){
		this.driver = Hooks.driver;
	}
	
	@FindBy(how = How.XPATH ,using = "(//*[@data-test-id='20181127082218072334c26aa6-3fd5-4701-903d-e47c0430d177293'][1]/div/span[1]/label)[1]")
	private WebElement arrivalAir;
	
	@FindBy(how = How.XPATH ,using = "(//*[@data-test-id='20181127082218072334c26aa6-3fd5-4701-903d-e47c0430d177293'][1]/div/span[2]/label)[1]")
	private WebElement arrivalSea;
	
	@FindBy(how = How.XPATH ,using = "(//*[@data-test-id='20181127082218072334c26aa6-3fd5-4701-903d-e47c0430d177293'][1]/div/span[1]/label)[2]")
	private WebElement departureAir;
	
	@FindBy(how = How.XPATH ,using = "(//*[@data-test-id='20181127082218072334c26aa6-3fd5-4701-903d-e47c0430d177293'][1]/div/span[2]/label)[2]")
	private WebElement departureSea;
	
	@FindBy(how = How.XPATH ,using = "(//*[@data-test-id='201811270822180725fe24858e-8b88-433e-b35c-948fe8069c74462'])[1]")
	private WebElement arrivalAirport;
	
	@FindBy(how = How.XPATH ,using = "(//*[@data-test-id='201811270822180725a33fc8f0-915e-4d53-8b44-6d10b35da869312'])[1]")
	private WebElement arrivalFlight;
	
	@FindBy(how = How.XPATH ,using = "(//*[@data-test-id='201811270822180725dcdb72b7-0745-43bc-b2ed-fcfda4c13290436'])[1]")
	private WebElement arrivalAirline;
	
	@FindBy(how = How.XPATH ,using = "(//*[@data-test-id='201811270822180725fe24858e-8b88-433e-b35c-948fe8069c74462'])[2]")
	private WebElement departureAirport;
	
	@FindBy(how = How.XPATH ,using = "(//*[@data-test-id='201811270822180725a33fc8f0-915e-4d53-8b44-6d10b35da869312'])[2]")
	private WebElement departureFlight;
	
	@FindBy(how = How.XPATH ,using = "(//*[@data-test-id='201811270822180725dcdb72b7-0745-43bc-b2ed-fcfda4c13290436'])[2]")
	private WebElement departureAirline;
	
	public void clickArrivalType(String type){
		if(type.equalsIgnoreCase("air")){
			arrivalAir.click();
		}else{
			arrivalSea.click();
		}
	}
	
	public void clickDepartureType(String type){
		if(type.equalsIgnoreCase("air")){
			departureAir.click();
		}else{
			departureSea.click();
		}
	}

	public WebElement getArrivalAirport() {
		return arrivalAirport;
	}

	public WebElement getDepartureAirport() {
		return departureAirport;
	}
	
	public void enterArrivalFlightDetails(String flight, String airline){
		arrivalFlight.sendKeys(flight);
		arrivalAirline.sendKeys(airline);
	}
	
	public void enterDepartureFlightDetails(String flight, String airline){
		departureFlight.sendKeys(flight);
		departureAirline.sendKeys(airline);
	}
}
