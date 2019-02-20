package nz.police.pega.firearms.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import nz.police.pega.firearms.HelperMethods;
import nz.police.pega.firearms.stepdef.Hooks;

public class SecurityPage {
	public WebDriver driver;
	HelperMethods helperAction = new HelperMethods();
	 
	public SecurityPage(){
		this.driver = Hooks.driver;
	}
	@FindBy(how = How.XPATH ,using = "//*[@data-test-id='201811290550250983028344b3-e19c-4710-bd1b-3a0a17e485db495']/div/span[1]/label")
	private WebElement storingFirearmsYes;
	
	@FindBy(how = How.XPATH ,using = "//*[@data-test-id='201811290550250983028344b3-e19c-4710-bd1b-3a0a17e485db495']/div/span[2]/label")
	private WebElement storingFirearmsNo;
	
	@FindBy(how = How.XPATH ,using = "//*[@data-test-id='201811290550250984ba41aa0b-367d-486d-bfe7-4b58d9c95f4b133']")
	private WebElement storageArrangements;
	
	@FindBy(how = How.XPATH ,using = "//*[@data-test-id='20181217111444078088da3fab-2f40-4e16-91c8-5c1d226a559d661']")
	private WebElement securityArrangements;
	
	@FindBy(how = How.XPATH ,using = "//*[@data-test-id='2018113009354607260bd3aa14-b0eb-4029-9c99-0255fc68219382']")
	private WebElement storingfirstName;
	
	@FindBy(how = How.XPATH ,using = "//*[@data-test-id='201811300935460727448f2ce3-5831-4cb8-a814-9fbc4d4aad0a191']")
	private WebElement storinglastName;
	
	@FindBy(how = How.XPATH ,using = "//*[@data-test-id='2018112905502509854d4af6d6-8beb-4b86-bfb9-f40b7d6db28e80']")
	private WebElement storingEmail;
	
	@FindBy(how = How.XPATH ,using = "//*[@data-test-id='201811290550250987d5d6e649-4e2a-4756-bd8a-edade350c3e25']")
	private WebElement storingLicenceNumber;
	
	@FindBy(how = How.XPATH ,using = "//*[@data-test-id='2018112905502509876dfab70c-4173-44e4-81cd-9f00483533a0598']/div/span[1]/label")
	private WebElement hireVehicleYes;
	
	@FindBy(how = How.XPATH ,using = "//*[@data-test-id='2018112905502509876dfab70c-4173-44e4-81cd-9f00483533a0598']/div/span[1]/label")
	private WebElement hireVehicleNo;
	
	@FindBy(how = How.XPATH ,using = "//*[@data-test-id='2018112905502509884ba61038-10c5-47ab-bbe7-b51d5fc2340d409']")
	private WebElement hiringCompany;
	
	public void clickStoreFirearmsYes(){
		storingFirearmsYes.click();
	}
	
	public void clickStoreFirearmsNo(){
		storingFirearmsNo.click();
	}
	
	public void enterStorageArrangements(String storageDetails){
		storageArrangements.sendKeys(storageDetails);
		securityArrangements.sendKeys("safe locker");
	}

	public void enterPersonDetails(String first, String last,String email,String licenceNo ){
		storingfirstName.sendKeys(first);
		storinglastName.sendKeys(last);
		storingEmail.sendKeys(email);
		storingLicenceNumber.sendKeys(licenceNo);
		securityArrangements.sendKeys("safe locker");
	}

}
