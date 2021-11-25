package frameWorkClasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

//	private static final TimeUnit SECONDS = null;
	// Declare the WebDriver

	public static WebDriver driver;

	// constructor of the base class
	public BasePage() {
		if (driver == null) {
			// get parameter values
			String browser = getDataConfigProperties("browser");
			System.out.println(browser);
			String systemUnderTest = getDataConfigProperties("systemUnderTest");
			System.out.println(systemUnderTest);
			String pdriverdir = getDataConfigProperties("driverdir");
			System.out.println(pdriverdir);
			// String pdriverdirFirefox = getDataConfigProperties("driverFirefox");
			// String pdriverdirEdge = getDataConfigProperties("driverEdge");

			if (browser.equalsIgnoreCase("chrome")) {
				// set the path to chrome
				
				
				System.setProperty("webdriver.chrome.driver", pdriverdir + "chromedriver.exe");
				// check if paramenter passed in chrome
				driver = new ChromeDriver();
				driver.get(systemUnderTest);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

			}

			else if (browser.equals(IgnoreCase("firefox"))) {
				// set the path to gecko
				System.setProperty("webdriver.gecko.driver", pdriverdir + "geckodriver.exe");
				// check if paramenter passed in firefox
				driver = new FirefoxDriver();
				driver.get(systemUnderTest);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

			}

			else if (browser.equals(IgnoreCase("edge"))) {
				// set the path to gecko
				System.setProperty("webdriver.edge.driver", pdriverdir + "MicrosoftWebdriver.exe");
				// check if paramenter passed in firefox
				driver = new EdgeDriver();
				driver.get(systemUnderTest);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			}
		}

	}

	private Object IgnoreCase(String string) {
		return null;
		// TODO Auto-generated method stub

	}

	// Create a method to read the config

	public String getDataConfigProperties(String propertyName) {
		Properties p = new Properties();
		InputStream is = null;

		try {
			is = new FileInputStream("config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
			try {
				p.load(is);
			} catch (IOException e) {
				e.printStackTrace();

			}
			return p.getProperty(propertyName);
					
			}
			
	// create a method to Wait for Element
	public void waitForElement(int elementWait,By pLocator) 
	{
		WebDriverWait wait = new WebDriverWait(driver,elementWait);
		wait.until(ExpectedConditions.visibilityOfElementLocated(pLocator));
	}
	// create a method to wait for the URL
	public void waitForUrl(int elementWait,String pLocator) 
	{
		WebDriverWait wait = new WebDriverWait(driver,elementWait);
		wait.until(ExpectedConditions.urlContains(pLocator));
	}
	
	// create a method to Wait for Click
	public void waitForClick(int elementWait,By pLocator) 
	{
		WebDriverWait wait = new WebDriverWait(driver,elementWait);
		wait.until(ExpectedConditions.elementToBeClickable(pLocator));	
	}
		
	// create a method to get Element Text
	public String getElementText(By pLocator) 
	{
		waitForElement(10,pLocator);
		String h1 =getElement(pLocator).getText();
		return h1;
	}
			
	// create a method to click Element
	public void clickElement(By pLocator) 
	{
		waitForClick(10,pLocator);
		getElement(pLocator).click();
		
	}
	
	
	// create a method to get Element
	public WebElement getElement(By pLocator) 
	{
		waitForClick(10,pLocator);
		return driver.findElement(pLocator);
	}
	
	// clean up (close the browser)
	public void cleanup() 
	{
		driver.close();
		
	}	
	// create a method to EnterText
	
	public void EnterText(By pLocator,String pText) 
	{
		waitForClick(10,pLocator);
		driver.findElement(pLocator).sendKeys(pText);
		
	}
	//create a method to select the dropdown
	public void selectDropDown(By pLocator,String pValue )
	{
		//Creates an instance of the dropdown object
		Select sDrpdown = new Select (getElement(pLocator));
		//populates the Dropdown 
		sDrpdown.selectByVisibleText(pValue);
	}

	public Object[][] getExcelData(String string, String string2) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
}			 
			
			
			// create a method to select the drop down	
			
			



	
