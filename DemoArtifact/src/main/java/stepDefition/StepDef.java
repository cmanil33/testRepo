package stepDefition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjects.FlightsObject;
import utilities.CommonFunctionalities;

public class StepDef extends CommonFunctionalities{

	public  WebDriver driver;
	FlightsObject fo ;


	// HOOK method  - Runs first/ before the actual the scenarios from the feature files
	@Before
	public void setUp() {
		
		//Initializing the driver
		driver = driverInit();		
	}

	// HOOK method  - Runs last/ after the actual the scenarios from the feature files
	@After
	public void tearDown(Scenario scenario) throws IOException {
		try {
			if (scenario.isFailed()) {
				String screenshotName = scenario.getName().replaceAll(" ", "_");
				System.out.println("screenshotName : "+screenshotName);
				getScreenshot(screenshotName);
			}
		}
		finally {
			driver.quit();	
		}

	}


	@Given("^user is navigated to the application \"([^\"]*)\" site$")
	public void user_is_navigated_to_the_application_something_site(String strArg1) {

		//Naviagting to the site/ application
		launchApp(strArg1);
		
		//Calling Login Method to SignIN to the application
		loginApp("user@phptravels.com", "demouser");
	}

	@When("^user entered the (.+) and (.+)$")
	public void user_entered_the_and(String username, String password){
		driver.findElement(By.xpath("//*[@placeholder='Email']")).sendKeys(username);
		driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys(password);
	}


	@Then("^verify if user is successfully logged in$")
	public void verify_if_user_is_successfully_logged_in(){
		String userName = driver.findElement(By.xpath("//span[text()='Demo']")).getText();
		System.out.println("user name is "+ userName);
		//		Assert.assertEquals(userName, "Demo");
		Assert.assertEquals("Actual value and expected value are not same", userName, "Demo");
	}

	@And("^user clicked on login button$")
	public void user_clicked_on_login_button(){
		driver.findElement(By.xpath("//span[text()='Login']")).click();
	}

	@When("^user clicked on Flights tab$")
	public void user_clicked_on_flights_tab() {
		
		fo = new FlightsObject(driver);
		fo.getFlightTab().click();
//		driver.findElement(By.xpath("//a[text()='flights']")).click();
	}


	@Then("verify if user is able to see {string} and {string} and {string} flight types")
	public void verify_if_user_is_able_to_see_and_and_flight_types(String string1, String string2, String string3) {
		List<String> expectedTypes = Arrays.asList(string1, string2, string3);

		try {
			waitByVisibilityOfElement(By.xpath("//*[@id='flight_type']/option"));
			List<String> actualTypes = getListOfWebELements(By.xpath("//*[@id='flight_type']/option/hhg"));	
			Assert.assertEquals("Actual List and expected List are not same", actualTypes, expectedTypes);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}





}
