package nz.police.pega.firearms.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import nz.police.pega.firearms.HelperMethods;
import nz.police.pega.firearms.stepdef.Hooks;

public class TheoryTestPage {
	public WebDriver driver;
	HelperMethods helperAction = new HelperMethods();
	 
	public TheoryTestPage(){
		this.driver = Hooks.driver;
	}
	
	@FindBy(how = How.XPATH ,using = "//*[@data-test-id='201812051117330886bb97f559-346e-46fa-a1fd-3f259f1eb38d490']")
	private WebElement correctAnswers;
	
	@FindBy(how = How.XPATH ,using = "//*[@data-test-id='20181204142020067087d8b131-8714-4a5c-b291-024097e4a938828']")
	private WebElement takeTest;
	
	@FindBy(how = How.XPATH ,using = "//*[@data-test-id='201811281555380825673b8144-5fb2-46be-b862-5591980548c2828']")
	private WebElement takeTestAgain;	
	
	@FindBy(how = How.ID ,using = "ModalButtonSubmit")
	private WebElement submitTest;
	
	@FindBy(how = How.XPATH ,using = "//*[@data-test-id='201808120943310957798']/div/div")
	private WebElement resultText;
	
	
	public void clickTakeTestCorrectly(){
		helperAction.waitOnClickable(correctAnswers);
		correctAnswers.click();
		helperAction.waitOnClickable(takeTest);
		takeTest.click();
	}
	
	public void clickSubmit(){
		helperAction.waitOnClickable(submitTest);
		submitTest.click();
	}

	public WebElement getResultText() {
		return resultText;
	}
	

	
}
