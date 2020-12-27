package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utilities.Helper;


public class TestBase {
	JavascriptExecutor jse;

	public static WebDriver driver;

	
	@BeforeSuite
	@Parameters({"browser"})
	public void startDriver(@Optional("chrome") String browserName) { //@optional: puts its value in browserName if no value comes from testng.xml file

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			jse = (JavascriptExecutor) driver;

		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			jse = (JavascriptExecutor) driver;

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.navigate().to("http://automationpractice.com/index.php");
	}


	@AfterSuite
	public void stopDriver() {
		driver.quit();
	}

	// Take screenshot when testcase fail and add it in screenshot folder
	@AfterMethod
	public void screenshotOnFailure(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Failed!");
			System.out.println("Taking Screenshot...");
			Helper.captureScreenshot(driver, result.getName());

		}

	}

}
