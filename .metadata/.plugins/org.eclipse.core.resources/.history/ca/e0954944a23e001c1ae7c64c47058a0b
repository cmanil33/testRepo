package runnerPkg;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(  		
		features = "src\\main\\java\\featureFiles",
		glue="stepDefition",   // step definition package name
		monochrome=true,
		plugin = {"html:target/cucumberFiles/reports/cucumber.html"},
		tags = ("@smoke"))   
public class TestRunner {

}
