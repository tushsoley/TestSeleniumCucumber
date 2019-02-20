package nz.police.pega.firearms.stepdef;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions (
		features = {"src//test//resources//features//Visitors"}		
		,glue = {"nz.police.pega.firearms.stepdef"}
		,plugin = {"pretty", "html:target/cucumber-html-report","json:cucumber.json"}
		,tags = {"~@Smoke","@Eligibility"}
		)

public class RunnerTest {

}