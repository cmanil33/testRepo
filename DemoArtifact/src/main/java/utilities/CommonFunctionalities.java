package utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunctionalities {

	public WebDriver driver;
	Actions act; 

	String s1 ="anil";
	StringBuilder s2 = new StringBuilder("anil");
	StringBuffer s3 = new StringBuffer("hhh");
	
	void abc() {
		
		s2.append(" kumar");
		s3.append(" jjh");
	}
	
	public WebDriver driverInit() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\OneDrive\\Desktop\\Selenium Training Resources\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

		//Implicit wait
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();

		return driver;
	}

	public void launchApp(String appUrl) {
		driver.get(appUrl);
	}
	
	public void loginApp(String username, String password) {
		driver.findElement(By.xpath("//*[@placeholder='Email']")).sendKeys(username);
		driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys(password);
		driver.findElement(By.xpath("//span[text()='Login']")).click();
	}
	
	
	public void getScreenshot(String name) throws IOException {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String pathDir = System.getProperty("user.dir");
		System.out.println("pathDir : "+pathDir);
		FileHandler.copy(scrFile, new File(pathDir+"/target/cucumberFiles/screenshots/" + name + ".png"));

	}

	public void selectValueFromStaticDropDown(WebElement wb, String value) {
		Select s1 = new Select(wb);
		s1.selectByVisibleText(value);		
	}

	public void mouseHoverOnWebElement(WebElement wb) {
		act = new Actions(driver);
		act.moveToElement(wb).build().perform();		
	}

	public void windowHandle(String title) {
		Set<String> windows = driver.getWindowHandles();  
		
		for(String s : windows) {
			driver.switchTo().window(s); 		
			if(driver.getTitle().contains(title)) {
				break;
			}						
		}
	}


	public void waitByVisibilityOfElement(By wb) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(wb));
	}
	
	public void waitByPresenceOfElement(By wb) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(wb));
	}
	
	public ArrayList<String> getListOfWebELements(By locator) {
		ArrayList<String> actualList = new ArrayList<String>(); 
		List<WebElement> listElements = driver.findElements(locator);
		
		for(WebElement wb : listElements) {
			actualList.add(wb.getText());
		}
		
		return actualList;
	}

}
