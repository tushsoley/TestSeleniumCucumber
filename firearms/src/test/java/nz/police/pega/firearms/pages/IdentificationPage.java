package nz.police.pega.firearms.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import nz.police.pega.firearms.HelperMethods;
import nz.police.pega.firearms.stepdef.Hooks;

public class IdentificationPage {
	public WebDriver driver;
	HelperMethods helperAction = new HelperMethods();
	 
	public IdentificationPage(){
		this.driver = Hooks.driver;
	}
	
	@FindBy(how = How.XPATH ,using = "//*[@data-test-id='2018112720245009248e36b7ed-0be7-410d-b928-9cb8e6f2e55e948']")
	private WebElement passportCountry;
	
	@FindBy(how = How.XPATH ,using = "//*[@data-test-id='201811272024500921526a5dbb-dd1c-4479-800b-1d74e1964e6c531']")
	private WebElement passportNumber;
	
	@FindBy(how = How.XPATH ,using = "//*[@data-test-id='2018112720245009249e65b19e-1145-4c63-af60-8ebe6bf3a950324']")
	private WebElement attachPassport;
	
	@FindBy(how = How.XPATH ,using = "//*[@data-test-id='20181130115138077795c1e0a8-1025-4442-a9cb-2242c7290dda78']")
	private WebElement attachPhoto;
	
		
	public WebElement getpassportCountry() {
		return passportCountry;
	}
	
	public void enterPassportNumber(String number){
		passportNumber.clear();
		passportNumber.sendKeys(number);
	}
	
	public void clickAttachPassport(){
		attachPassport.click();
	}
	public void clickAttachPhoto() throws InterruptedException{
		helperAction.waitOnClickable(attachPhoto);
		//need to handle sleep properly
		Thread.sleep(300);
		attachPhoto.click();
	}	
	
}
