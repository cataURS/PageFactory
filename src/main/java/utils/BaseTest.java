package utils;

import java.io.File;
import java.net.MalformedURLException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.google.common.io.Files;

import pages.LoginPage;
/**
 * Responsability of this class is to instantiate the driver and close it after each test class
 * Also records failure after each failed @Test method
 * @author dragostanta
 *
 */
public class BaseTest extends Driver {

	public WebDriver driver;
	
	/**
	 * Scope of method is to call the browser instantiation form Driver.class and navigate to APP URL
	 * @param browser : value can be passed through MAVEN command <mvn -Dbrowser=chrome> or through Testng.xml variable
	 * @throws MalformedURLException 
	 */
	@Parameters({"browser"})
	@BeforeClass(alwaysRun = true)
	public void setup(String browser) throws MalformedURLException {
		
		driver = initDriver(browser);
		driver.get("https://keybooks.ro/");
	}
	
	/**
	 * Scope of method is to close the broswer instance after all @Test methods from a class are executed
	 * @throws InterruptedException
	 */
	@AfterClass
	public void teardown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		
	}
	
	/**
	 * Scope of method is to take a screenshot using Selenium build in TakesScreenShot class
	 * <br>
	 * only if the TestNg listener object (result) will have the status FAILURE on execution
	 * @param result : TestNg listener object 
	 */
	@AfterMethod
	public void recordFailure(ITestResult result) {
		
		if(ITestResult.FAILURE == result.getStatus()) {
			
			TakesScreenshot poza = (TakesScreenshot)driver;
			File picture = poza.getScreenshotAs(OutputType.FILE);
			
			try {
				Files.copy(picture, new File("screenshots/"+result.getName() + ".png"));
				Log.info("Saved picture in 'screenshots/' "+result.getName() + ".png");
				
			}catch (Exception e) {
				Log.error("Could not save picture!");
				Log.error(e.getMessage());
				
			}
			
		}
		
	}
	

}