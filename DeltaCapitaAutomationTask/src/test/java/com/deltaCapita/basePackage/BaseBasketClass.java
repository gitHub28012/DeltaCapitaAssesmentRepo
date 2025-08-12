package com.deltaCapita.basePackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.deltaCapita.genericPackage.BasketCostCalculatorHelperTest;
import com.deltaCapita.genericPackage.InitObjects;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class BaseBasketClass extends InitObjects {

	protected static WebDriver driver;
	String EXCEL_PRICES_PATH="./src/test/java/testData/FruitPrices.xlsx";

	@BeforeSuite
	public void setUpForReport() {
		InitObjects.setUpForReporting();
	}

	@BeforeClass
	public void browserSetup() {
		String browserValue = InitObjects.readDataFromPropertyFile("browser");
		String expectedURL = InitObjects.readDataFromPropertyFile("url");

		if (browserValue.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();

		} else if (browserValue.equalsIgnoreCase("FireFox")) {
			driver = new FirefoxDriver();
		} else if (browserValue.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		} else {
			Reporter.log("Please enter valide browserValue", true);
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(DURATION_SECONDS));
		driver.get(expectedURL);
		
		 BasketCostCalculatorHelperTest.loadDataFromExcel(EXCEL_PRICES_PATH,"prices");

	}
	
	@AfterClass
	public void browserTearDown()
	{
		driver.quit();
	}
	
	@AfterSuite
	public void tearDownForReport()
	{
		InitObjects.getExtentInstance().flush();
	}

}
