package nz.police.pega.firearms.stepdef;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.When;
import nz.police.pega.firearms.HelperMethods;
import nz.police.pega.firearms.pages.GenericObjectPage;
import nz.police.pega.firearms.pages.IdentificationPage;

public class IdentificationStepDef {
	public WebDriver driver;
	public Properties CONFIG;
	HelperMethods helperAction = new HelperMethods();
	
	
	public IdentificationStepDef(){
		driver = Hooks.driver;
		CONFIG = Hooks.CONFIG;
	}
	
	@When("^i complete identification details$")
	public void i_complete_identification_details() throws InterruptedException{
		IdentificationPage identificationPage = PageFactory.initElements(driver, IdentificationPage.class);
		GenericObjectPage genericPage = PageFactory.initElements(driver, GenericObjectPage.class);
		helperAction.selectElementList(identificationPage.getpassportCountry(), "Australia");
		identificationPage.enterPassportNumber("123456");
		//attach passport
		identificationPage.clickAttachPassport();		
		helperAction.attachAFile(genericPage.getSelectFile(), "C:\\Users\\tusharso\\Desktop\\police2.png");			
		genericPage.clickAttach();
		//attach photoid
		attachPhoto("C:\\Users\\tusharso\\Desktop\\police2.png");
		//sleep need to handle properly
		Thread.sleep(1000);
		genericPage.getContinueButton().click();		
	}
	
	public void attachPhoto(String PhotoFilePath) throws InterruptedException{
		IdentificationPage identificationPage = PageFactory.initElements(driver, IdentificationPage.class);
		GenericObjectPage genericPage = PageFactory.initElements(driver, GenericObjectPage.class);
		//sleep need to handle properly
		Thread.sleep(1000);
		identificationPage.clickAttachPhoto();
		helperAction.attachAFile(genericPage.getSelectFile(), PhotoFilePath);
		//sleep need to handle properly
		Thread.sleep(1000);
		genericPage.clickAttach();
	}
}
