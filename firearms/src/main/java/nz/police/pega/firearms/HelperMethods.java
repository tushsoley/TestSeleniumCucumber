package nz.police.pega.firearms;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import nz.police.pega.firearms.stepdef.Hooks;



public class HelperMethods 
{
	public static WebDriver driver;
	private WebDriverWait wait;
	public String result;
	
	public HelperMethods(){
		driver = Hooks.driver;
	}
	
    public void verifyTextOnPage(String textOnPage) throws InterruptedException{
    	String expected = textOnPage;
    	Thread.sleep(2000);
    	String pageContent = driver.findElement(By.tagName("body")).getText();
    	Assert.assertTrue("Verify text "+ expected + " on Page",pageContent.contains(expected));    	
    }
    
    public void verifyText(WebElement testObject, String texttoverify) throws InterruptedException{
    	String expected = texttoverify.trim().replaceAll("\\s+","");
    	//waitOnClickable(testObject);
    	//waitOnVisibility(testObject);
    	//sleep to be handled correctly
    	Thread.sleep(1000);
    	waitForLoad(driver);
    	String actualtext = testObject.getText().trim().replaceAll("\\s+",""); 
    	System.out.println(expected);
    	System.out.println(actualtext);
    	Assert.assertTrue("Actual Text is - "+ actualtext,actualtext.equalsIgnoreCase(expected));
    }
    
    public void verifyTextPartially(WebElement testObject, String texttoverify) throws InterruptedException{
    	String expected = texttoverify.trim().replaceAll("\\s+","").toLowerCase();
    	//waitOnClickable(testObject);
    	//waitOnVisibility(testObject);
    	//sleep to be handled correctly
    	Thread.sleep(1000);
    	waitForLoad(driver);
    	String actualtext = testObject.getText().trim().replaceAll("\\s+","").toLowerCase(); 
    	System.out.println(expected);
    	System.out.println(actualtext);
    	Assert.assertTrue("Verify text "+ expected + ":",actualtext.contains(expected));
    }
    public void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }
    
    /**
     * Returns 'true' if the value of the 'window.document.readyState' via
     * JavaScript is 'complete'
     */
    public static final ExpectedCondition<Boolean> EXPECT_DOC_READY_STATE = new ExpectedCondition<Boolean>() {
        @Override
        public Boolean apply(WebDriver driver) {
            String script = "if (typeof window != 'undefined' && window.document) { return window.document.readyState; } else { return 'notready'; }";
            Boolean result;
            try {
                result = ((JavascriptExecutor) driver).executeScript(script).equals("complete");
            } catch (Exception ex) {
                result = Boolean.FALSE;
            }
            return result;
        }
    };
    public void waitOnClickable(WebElement testObject){
    	wait = new WebDriverWait(driver, 15);
    	wait.until(ExpectedConditions.elementToBeClickable(testObject));
    }
    
    public void waitOnVisibility(WebElement testObject){
    	wait = new WebDriverWait(driver, 15);
    	wait.until(ExpectedConditions.visibilityOf(testObject));
    }
    
    public void switchToFrame(WebElement frame){
    	driver.switchTo().frame(frame);
    }
    
    public void switchToDefaultContent(){
    	driver.switchTo().defaultContent();
    }
    
    /**
	 * Method to select option from drop down list
	 * data value is text that need to be selected
	 */
	public String selectElementList(WebElement droplist, String value) {		
			List<WebElement> options = droplist.findElements(By.tagName("option"));
			String expectedData = value;
			for(WebElement option : options){
				if(expectedData.equals(option.getText().trim())){
					option.click();
					result = "Pass - Found";
					break;
				}				
			}			
		return result;
	}
	
	/**
	 * Method to count option from drop down list
	 */
	public void verifyCountDropdownList(WebElement droplist,int number) {		
			List<WebElement> options = droplist.findElements(By.tagName("option"));
			int count = options.size();
			Assert.assertTrue("Match option count",count==number);
	}
	
	
	public String addDaysToCurrentDate(int days){
		LocalDate today = LocalDate.now();		
		String output = today.plusDays(days).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		return output;
	}
	
	public void attachAFile(WebElement element, String filePath) throws InterruptedException{
		//driver.setFileDetector(new LocalFileDetector());
		Thread.sleep(400);
	    element.sendKeys(filePath);
	}
}
