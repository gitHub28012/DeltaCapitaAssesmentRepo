package com.deltaCapita.genericPackage;

import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/***
 * This class is used initialize the different Object available in project
 * framework
 * 
 * @author Tanmay 12-08-2025
 */
public class InitObjects implements FrameworkConstant {

	private static ExtentReports extent;

	/**
	 *
	 * @return instance of ExtentsReporter
	 */
	public static ExtentReports getExtentInstance() {

		if (extent == null) {
			extent = new ExtentReports();
		}
		return extent;
	}

	/**
	 * used for set up the extent.html reporting for UI + API automation
	 */
	public static void setUpForReporting() {
		ExtentSparkReporter spark = new ExtentSparkReporter(
				ReportPath + LocalDateTime.now().toString().replace(":", "-"));
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("Automation Testing Report!!");

		extent = new ExtentReports();
		extent.attachReporter(spark);
	}

	/**
	 * This method is used to read the data from property file
	 * 
	 * @param fileName
	 * @param key
	 * @return
	 */
	public static String readDataFromPropertyFile(String key) {
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(PROP_PATH);
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}

}
