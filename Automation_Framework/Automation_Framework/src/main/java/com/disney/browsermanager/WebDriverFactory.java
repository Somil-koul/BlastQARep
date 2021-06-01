package com.disney.browsermanager;

import java.io.File;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.disney.listeners.WebEventListener;

//@SuppressWarnings("deprecation")
public class WebDriverFactory extends BrowserFactory {
	public static ThreadLocal<WebDriver> wd = new ThreadLocal<WebDriver>();
	// Create Map to store data from excel
	public static Map<String, String> excelTestData = new HashMap<String, String>();
	public static String browser;
	public static String url;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static String dest;
	public static String time;
	static String ReportName;
	public static String ReportFolderName;
	private static ExtentReports extent;
	private static ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	public static ExtentTest child;

	@BeforeSuite
	public void beforeSuite() {
		ReportFolderName = "ExecutionReports-" + getCurrentDateTime();
		ExtentHtmlReporter html = new ExtentHtmlReporter(System.getProperty("user.dir") + "/src/test/Reports/"
				+ ReportFolderName + File.separator + "Extent.html");
		extent = new ExtentReports();
		extent.attachReporter(html);
		html.loadXMLConfig(System.getProperty("user.dir") + "/src/test/resources/" + "extent-config.xml");
		extent.setSystemInfo("os", "windows 10");
	}

	@Parameters(value = { "browservalue" })
	@BeforeMethod(alwaysRun = true)
	public synchronized void beforeMethod(@Optional("chrome") String browservalue, Method method) throws Exception {

		System.out.println("before method name " + method);
		child = parentTest.get().createNode(method.getName());
		test.set(child);

		softAssert = new SoftAssert();
		if (browservalue.contentEquals("chrome") || browser.contentEquals("chrome_headless")
				|| browser.contentEquals("firefox")) {
			logger.info("Browser: " + Browser);
			logger.info("WebsiteURL: " + WebsiteURL);
			new WebDriverFactory();
			driver = WebDriverFactory.createDriver();
			e_driver = new EventFiringWebDriver(driver);
			eventListener = new WebEventListener();
			e_driver.register(eventListener);
			driver = e_driver;
//			setDriver(driver);

		}

	}

	@AfterMethod
	public synchronized void afterMethod(ITestResult result) {

//		getDriver().quit();
		driver.quit();

		if (result.getStatus() == ITestResult.FAILURE) {
			test.get().fail(result.getThrowable());
			AddVerificationScreenShot(result.toString());
		}

		else if (result.getStatus() == ITestResult.SKIP) {
			test.get().skip(result.getThrowable());
		}
		else {
			test.get().pass("Test passed");
		}
		extent.flush();

	}

	@BeforeClass
	public synchronized void beforeMethod() {

		ExtentTest parent = extent.createTest(getName(getClass().getName()));
		parentTest.set(parent);
	}

	public static String getCurrentDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HHmmss");
		Date date = new Date();
		time = dateFormat.format(date);
		return time;
	}

	public static synchronized String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String imgPath = "./" + "screenshot" + File.separator + getCurrentDateTime() + ".png";
		File path = new File(
				System.getProperty("user.dir") + "/src/test/Reports/" + ReportFolderName + File.separator + imgPath);
		FileUtils.copyFile(sourceFile, path);
		return imgPath;
	}

	public static synchronized void AddVerificationScreenShot(String VerifyingScreenshot) {
		System.out.println(dest);
		try {

			String screnshotpath = getScreenshot(driver, "screenshot");
			child.info("VERIFY SCREENSHOT", MediaEntityBuilder.createScreenCaptureFromPath(screnshotpath).build());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@AfterClass
	public synchronized void closeBrowser() {

//		getDriver().close();
//		driver.close();
		
	}

	public String getName(String name) {

		name = name.replace(" ", "");
		String subString = name.substring(name.lastIndexOf("."));
		System.out.println(subString.replace(".", "").trim().replace("()", ""));
		return subString.replace(".", "").trim().replace("()", "");

	}

}