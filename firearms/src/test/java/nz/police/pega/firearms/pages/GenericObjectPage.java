package nz.police.pega.firearms.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import nz.police.pega.firearms.stepdef.Hooks;

public class GenericObjectPage {
	public WebDriver driver;
	 
	public GenericObjectPage(){
		this.driver = Hooks.driver;
	}

	@FindBy(how = How.XPATH ,using="//*[@data-test-id='20161017110917023176385']")
	private WebElement continueButton;
	
//	@FindBy(how = How.XPATH ,using = "//input[@id='$PpyAttachmentPage$ppxAttachName']")
	@FindBy(how = How.XPATH ,using = "//input[@title='Select file(s)']")
	private WebElement selectFile;
	
	@FindBy(how = How.XPATH ,using = "//button[@alt='Attach']")
	private WebElement Attach;
	
	//@FindBy(how = How.XPATH ,using = "//*[@data-test-id='2016083016191602341167946']")
	@FindBy(how = How.XPATH ,using = "//*[@data-test-id='201806191351520571476']")
	private WebElement applicationStatus;
	
	public WebElement getContinueButton() {
		return continueButton;
	}
	
	public WebElement getSelectFile() {
		return selectFile;
	}
	
	public void clickAttach() throws InterruptedException{
		Thread.sleep(2000);
		Attach.click();
	}
	
	public String getStatus(){
		return applicationStatus.getText();
	}

	public WebElement getApplicationStatus() {
		return applicationStatus;
	}
}
