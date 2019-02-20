package nz.police.pega.firearms.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import nz.police.pega.firearms.HelperMethods;
import nz.police.pega.firearms.stepdef.Hooks;

public class HomeCountryLicencePage {
	public WebDriver driver;
	HelperMethods helperAction = new HelperMethods();
	 
	public HomeCountryLicencePage(){
		this.driver = Hooks.driver;
	}
	@FindBy(how = How.XPATH ,using = "//*[@data-test-id='201811272012540655160ac0e4-7ae8-46bc-a6a4-91a7b2f61f3836']")
	private WebElement licenceNumber;
	
	@FindBy(how = How.XPATH ,using = "//*[@data-test-id='201811272012540656d6d204c6-e75f-4641-8f7d-9f04611b84be197']")
	private WebElement issuedBy;
	
	@FindBy(how = How.XPATH ,using = "//*[@data-test-id='201811272012540656c6d65a65-8822-4b26-a4fa-e88bc55923b4656']")
	private WebElement licenceExpiryDate;
	
	@FindBy(how = How.XPATH ,using = "//*[@data-test-id='2018112720125406575c35a43a-b9ff-4482-8a8d-290441513f178']")
	private WebElement attachLicenceCopy;
	
	@FindBy(how = How.XPATH ,using = "//*[@data-test-id='201811271951450338b60d2899-456e-4254-af03-d2062d138115426']")
	private WebElement homeCountry;	
	
		
	public WebElement getHomeCountry() {
		return homeCountry;
	}


	public void clickAttachLicenceCopy() {
		helperAction.waitOnClickable(attachLicenceCopy);
		attachLicenceCopy.click();
	}


	public void enterLicenceDetails(){
		licenceNumber.sendKeys("ABC12345");
		issuedBy.sendKeys("Police Department");
		licenceExpiryDate.sendKeys(helperAction.addDaysToCurrentDate(365));
	}
}
