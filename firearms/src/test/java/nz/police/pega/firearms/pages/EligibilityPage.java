package nz.police.pega.firearms.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import nz.police.pega.firearms.stepdef.Hooks;

public class EligibilityPage {
	public WebDriver driver;
	 
	public EligibilityPage(){
		this.driver = Hooks.driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH ,using = "//*[@data-test-id='201811271158110111395d2c05-45a3-4657-aeed-ac06721a0f2b146']")
	private WebElement Country;
	
	@FindBy(how = How.XPATH ,using="//div[@data-test-id='20181127115811011229085f87-2aaf-435a-b05c-f178915c5650237']/div/span[1]/label")
	private WebElement proceedYes;
	
	@FindBy(how = How.XPATH ,using="//div[@data-test-id='20181127115811011229085f87-2aaf-435a-b05c-f178915c5650237']/div/span[2]/label")
	private WebElement proceedNo;
	
	@FindBy(how = How.XPATH ,using="//div[@data-test-id='2018120509413406910393dce2-3bbe-4265-8777-dfb548142b5f626']/div/span[1]/label")
	private WebElement firearmLicenceYes;
	
	@FindBy(how = How.XPATH ,using="//div[@data-test-id='2018120509413406910393dce2-3bbe-4265-8777-dfb548142b5f626']/div/span[2]/label")
	private WebElement firearmLicenceNo;
	
	@FindBy(how = How.XPATH ,using="//*[@data-test-id='2018112711581101124a3b8574-60b9-47b2-9adc-21b211aec3ec85']")
	private WebElement arrivalDate;
	
	@FindBy(how = How.XPATH ,using="//*[@data-test-id='20181127115811011534b7faf0-1189-4b72-b5f2-6e6459c80a15308']")
	private WebElement departureDate;
	
	@FindBy(how = How.XPATH ,using="//*[@data-test-id='201808120943310957798']/div[3]/div")
	private WebElement unapprovedCountryWarning;

	public WebElement getUnapprovedCountryWarning() {
		return unapprovedCountryWarning;
	}

	@FindBy(how = How.ID, using = "PegaGadget1Ifr")
	private WebElement eligibilityFrame;
	

	public WebElement getEligibilityFrame() {
		return eligibilityFrame;
	}

	public WebElement getCountry() {
		return Country;
	}
	
	public void enterTravelDates(String arrival, String dep){
		arrivalDate.sendKeys(arrival);
		((JavascriptExecutor)driver).executeScript("arguments[0].value = '" + dep + "';", departureDate);
		//departureDate.sendKeys(dep);
	}
	
	public void selectAnswerProceed(String answer){
		if(answer.equalsIgnoreCase("yes")){
			proceedYes.click();
		}else if(answer.equalsIgnoreCase("no")){
			proceedNo.click();
		}
	}
	public void selectAnswerCountryLicence(String answer){
		if(answer.equalsIgnoreCase("yes")){
			firearmLicenceYes.click();
		}else if(answer.equalsIgnoreCase("no")){
			firearmLicenceNo.click();
		}
	}
}


