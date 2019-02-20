package nz.police.pega.firearms.stepdef;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {
/*	// Define a static logger variable so that it references the log4j 2 Logger
	// instance
	public final Logger APPLICATION_LOGS = LogManager.getLogger(getClass());*/
	public static WebDriver driver;
	public Properties ENVIRONMENT;
	public Scenario scenario;
	public static Properties CONFIG;
	
	
	
	
	/**
     * Initialize all properties file containing configuration parameters
     * that can be used later in scenarios
     */
	@Before(order=1)
	public void initilizeConfigFiles(Scenario scenario) throws IOException{
		if(ENVIRONMENT == null){
			ENVIRONMENT = new Properties();
			FileInputStream envFile = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\test\\java\\nz\\police\\pega\\firearms\\config\\" + "environment.properties");
			ENVIRONMENT.load(envFile);
		}
				
		if(CONFIG == null){
			CONFIG = new Properties();
			FileInputStream configFile = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\test\\java\\nz\\police\\pega\\firearms\\config\\" + "configuration_" + (ENVIRONMENT.getProperty("Environment").toLowerCase()) +
					".properties");
			CONFIG.load(configFile);
		}
	}
	
	/**
     * Delete all cookies at the start of each scenario to avoid
     * shared state between tests
     */
	
	@Before(order=2)
	public void openBrowser(Scenario scenario){		
		switch(CONFIG.getProperty("Browser").toLowerCase()){
			case "ie" :
				System.setProperty("webdriver.ie.driver","C:\\testing\\Selenium Drivers\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				break;
			case "internetexplorer" :
				WebDriverManager.iedriver().arch64().setup();
				driver = new InternetExplorerDriver();
				break;
			case "chrome" :
				System.setProperty("webdriver.chrome.driver","C:\\testing\\Selenium Drivers\\chromedriver_42.exe");
				System.setProperty("webdriver.chrome.logfile", "C:\\testing\\Selenium Drivers\\chromedriver.log");
		        //WebDriverManager.chromedriver().setup();
				/*ChromeOptions option = new ChromeOptions();
				option.setHeadless(true);*/
				//driver = new ChromeDriver(option);
		        driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				this.scenario = scenario;
				break;
			case "firefox" :
				System.setProperty("webdriver.gecko.driver","C:\\testing\\Selenium Drivers\\geckodriver_32_v0.22.exe");
				driver = new FirefoxDriver();
				break;
			case "edge" :
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 	
	}
	
	@After
	/**
     * take screenshot upon failure and quit webdriver
     */
	public void closeWebDriver(Scenario scenario){
		scenario.write("Scenarion Completed");
		if(scenario.isFailed()){
			scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES), "image/png");
		}
		driver.quit();
	}
}
