package nz.police.pega.firearms.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import nz.police.pega.firearms.HelperMethods;
import nz.police.pega.firearms.stepdef.Hooks;

public class VisitPage {
	public WebDriver driver;
	HelperMethods helperAction = new HelperMethods();
	 
	public VisitPage(){
		this.driver = Hooks.driver;
	}
	@FindBy(how = How.XPATH ,using = "//*[@data-test-id='2018112708515206882d955118-3d66-4ef8-8772-dbc81f5ff3c4648']")
	private WebElement purposeOfVisit;
	
	@FindBy(how = How.XPATH ,using = "//*[@data-test-id='201811270851520689326fc2b7-e71a-4c9c-ad5e-a9d47b10c166525']")
	private WebElement activity;
	
	@FindBy(how = How.XPATH ,using = "//*[@data-test-id='201811270851520690bb0ed6a4-08cb-4654-8f25-bbfdb79606c7438']/div/span[1]/label")
	private WebElement firearmsYes;
	
	@FindBy(how = How.XPATH ,using = "//*[@data-test-id='201811270851520690bb0ed6a4-08cb-4654-8f25-bbfdb79606c7438']/div/span[2]/label")
	private WebElement firearmsNo;
	
	@FindBy(how = How.XPATH ,using = "//*[@data-test-id='2018112708515206893cf15acf-e146-4e2b-9e38-53d643f1cacd526']")
	private WebElement competitionName;
	
	@FindBy(how = How.XPATH ,using = "//*[@data-test-id='201811270851520690dcfc8106-3172-43f5-b1bd-e373db2fd8f2460']")
	private WebElement competitionLocation;
	
	@FindBy(how = How.XPATH ,using = "//*[@data-test-id='201811270851520690f8e83cc7-7937-450b-b284-cb4352ceb232383']")
	private WebElement competetionStart;
	
	@FindBy(how = How.XPATH ,using = "//*[@data-test-id='201811270851520690e3a26cac-33f2-48d1-9ef6-c95d0acbd81a433']")
	private WebElement competetionEnd;
	
	@FindBy(how = How.XPATH ,using = "//*[@data-test-id='201812171052530993d0621f80-c00f-4ea9-b91f-1384968482ce677']/div/span[1]/label")
	private WebElement useOfPistolYes;
	
	@FindBy(how = How.XPATH ,using = "//*[@data-test-id='201812171052530993d0621f80-c00f-4ea9-b91f-1384968482ce677']/div/span[2]/label")
	private WebElement useOfPistolNo;
	
	@FindBy(how = How.XPATH ,using = "//*[@id='PegaGadget2Ifr']")
	private WebElement visitFrame;
	
	public WebElement getActivity() {
		return activity;
	}

	public WebElement getVisitFrame() {
		return visitFrame;
	}

	public void enterPurposeOfVisit(String text){
		purposeOfVisit.sendKeys(text);
	}
	
	public void enterCompetetionDetails(String start, String end){
		competitionName.sendKeys("ABC Competition");
		competitionLocation.sendKeys("auckland");
		competetionStart.sendKeys(start);
		competetionEnd.sendKeys(end);
		useOfPistolNo.click();
	}
	
	public void clickBringingFirearms(String answer){
		if (answer.equalsIgnoreCase("yes")){
			firearmsYes.click();
		}else if(answer.equalsIgnoreCase("no")){
			firearmsNo.click();
		}
	}
}
