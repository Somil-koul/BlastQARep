package com.disney.browsermanager;

import java.awt.Robot;
//import java.io.File;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestResult;
import org.testng.asserts.SoftAssert;

import com.disney.utils.Log;

public class InitMethod {
	public static ApplicationConfigReader appConfig = new ApplicationConfigReader();
	public Map<String, String> excelTestData = new HashMap<String, String>();

	public static String WebsiteURL = appConfig.getWebsiteUrl();
	public static String Browser = appConfig.getBrowser();
	public static int MaxPageLoadTime = appConfig.getMaxPageLoadTime();
	public static int ImplicitlyWait = appConfig.getImplicitlyWait();
	public static int explicitWaitTime = appConfig.getExplicitWait();
	public static String UserName = appConfig.getUserName();
	public static String Password = appConfig.getPassword();
//	public static String FS = File.separator;

	public static String OSName = System.getProperty("os.name");
	public static String OSArchitecture = System.getProperty("os.arch");
	public static String OSVersion = System.getProperty("os.version");
	public static String OSBit = System.getProperty("sun.arch.data.model");

	public static String ProjectWorkingDirectory = System.getProperty("user.dir");

	public static String TestData = "./src/main/resources/TestData/";
	public static String ExcelFiles = "./src/main/resources/TestData/Excel Files/";
	public static String PropertiesFiles = "./src/main/resources/TestData/Properties Files/";
	public static String Reports = "./src/main/resources/Reports/";
	public static String Images = "./src/main/resources/Reports/Images/";
	public static String Videos = "./src/main/resources/Reports/Videos/";

	public static Robot re;
	public static Alert al;
	public static String robotImageName;
	public static Select se;
	public static String FileToUpload;
	public static Actions newaction;
	public static Actions ac;
	public static ITestResult testResult;
	public static SoftAssert softAssert;
	public static ITestResult result = null;
	public static URI uri;

	public static final String OUTPUT_FOLDER = "./src/main/resources/Reports/";
	public static final String FILE_NAME = "Extent Report.html";
	public ISuite suite;
	public ISuiteResult res;
	public static final Logger logger = Log.getLogData(Log.class.getName());

	public static final String SUCCESS = "Success.txt";
	public static final String FAIL = "Fail.txt";

}
