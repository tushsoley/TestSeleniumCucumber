package nz.police.pega.firearms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import nz.police.pega.firearms.stepdef.Hooks;

public class LoginAndHomePage {
	public WebDriver driver;
 
	public LoginAndHomePage(){
		this.driver = Hooks.driver;
	}

	@FindBy(how = How.ID ,using="txtUserID")
	private WebElement UserName;
	
	@FindBy(how = How.ID ,using="txtPassword")
	private WebElement Password;
	
	@FindBy(how = How.ID, using ="sub")
	private WebElement Login;
	
	@FindBy(how = How.XPATH , using =".//a[@data-test-id='201603290226370641261700']")
	private WebElement logout;	
	
	@FindBy(how = How.XPATH , using ="//*[@data-test-id='2016033104302509328877']")
	private WebElement visitorLicenceAndPTI;
	
	@FindBy(how = How.ID, using = "PegaGadget0Ifr")
	private WebElement homeFrame;

	

	public WebElement getHomeFrame() {
		return homeFrame;
	}


	public void enterLogin(String username,String password) {
		UserName.clear();
		UserName.sendKeys(username);
			
		Password.clear();
		Password.sendKeys(password);
		
		Login.click();		
	}

	public void initiateNewApplication() throws InterruptedException{		
		visitorLicenceAndPTI.click();		
	}
	
}

