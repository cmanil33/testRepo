package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlightsObject {

	public WebDriver driver;

	private By flightTab = By.xpath("//a[text()='flights']");
	private By passegener = By.xpath("");
	
	public FlightsObject(WebDriver driver) {	
		this.driver=driver;	
	}

	public WebElement getFlightTab()
	{
		return driver.findElement(flightTab);   // this indirectly means  driver.findElement(By.xpath("//*[@id='flight_type']/option"));
	}
	
	
	public List<WebElement> getPassegener()
	{
		return driver.findElements(passegener);
	}
	
	
	
}
