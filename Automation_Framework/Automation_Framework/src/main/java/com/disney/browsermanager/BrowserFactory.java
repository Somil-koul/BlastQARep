package com.disney.browsermanager;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

import com.disney.browsermanager.CapabilityFactory;
import com.disney.browsermanager.InitMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory extends InitMethod {

//	protected static ThreadLocal<RemoteWebDriver> Remotedriver = new ThreadLocal<>();
//	private static ThreadLocal<WebDriver> webdriver = new ThreadLocal<WebDriver>();
	protected static WebDriver driver = null;
	public static CapabilityFactory capabilityFactory = new CapabilityFactory();
	public static SessionId session;

	static DesiredCapabilities capabilities;

	// @SuppressWarnings("deprecation")
	public static WebDriver createDriver() throws Exception {

		switch (Browser.toLowerCase()) {
		case "chrome":
			System.out.println("First Line ********************");
			WebDriverManager.chromedriver().setup();
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			ChromeOptions options = new ChromeOptions();
			options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			options.addArguments("start-maximized");
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("enable-automation");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-infobars");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--disable-browser-side-navigation");
			options.addArguments("--disable-gpu");
			options.addArguments("--disable-default-apps");
			options.addArguments("--disable-gpu");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--disable-notifications");
			options.addArguments("chrome.switches", "--disable-extensions");
			options.setPageLoadStrategy(PageLoadStrategy.NONE);
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
			driver = new ChromeDriver(options);
//			setDriver(driver);
			break;

		case "chrome_headless":
			WebDriverManager.chromedriver().setup();
			Map<String, Object> prefs1 = new HashMap<String, Object>();
			ChromeOptions options1 = new ChromeOptions();
			options1.addArguments("start-maximized");
			options1.setExperimentalOption("prefs", prefs1);
			options1.addArguments("enable-automation");
			options1.addArguments("--no-sandbox");
			options1.addArguments("--disable-infobars");
			options1.addArguments("--disable-dev-shm-usage");
			options1.addArguments("--disable-browser-side-navigation");
			options1.addArguments("--disable-gpu");
			options1.addArguments("headless");
			options1.addArguments("--disable-default-apps");
			options1.addArguments("--disable-gpu");
			options1.addArguments("--disable-dev-shm-usage");
			options1.addArguments("--disable-notifications");
			options1.addArguments("chrome.switches", "--disable-extensions");
			driver = new ChromeDriver(options1);
			session = ((ChromeDriver) driver).getSessionId();
			driver.manage().window().maximize();
			System.out.println("Session id: " + session.toString());
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
//			setDriver(new FirefoxDriver());
			driver = new FirefoxDriver();
			break;

		default:
			throw new NotFoundException("Browser Not Found. Please Provide a Valid Browser");
		}
		
		if (!Browser.toLowerCase().contains("chrome_docker")) {
			System.out.println("Second line *************");
//			getDriver().get(WebsiteURL);
//			getDriver().manage().window().maximize();
			driver.get(WebsiteURL);
			driver.manage().window().maximize();
		}

		if (ImplicitlyWait > 0) {
			System.out.println("Third line ********************");
			implicitlywait(ImplicitlyWait);
		}

		if (MaxPageLoadTime > 0) {
			System.out.println("Fourth line ***************");
			setMaxPageLoadTime(MaxPageLoadTime);
		}

//		return getDriver();
		return driver;
	}

	public static void implicitlywait(int timeInSeconds) throws Exception {
		if (!Browser.toLowerCase().contains("chrome_docker")) {
//			getDriver().manage().timeouts().implicitlyWait(timeInSeconds, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(timeInSeconds, TimeUnit.SECONDS);
		}
	}

	public static void setMaxPageLoadTime(int timeInSeconds) throws Exception {
		if (!Browser.toLowerCase().contains("chrome_docker")) {
//			getDriver().manage().timeouts().pageLoadTimeout(timeInSeconds, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(timeInSeconds, TimeUnit.SECONDS);
		}
	}

//	public static WebDriver getDriver() {
//		return webdriver.get();
//	}
//
//	static void setDriver(WebDriver driver) {
//		webdriver.set(driver);
//	}
//
//	public static void setDriver(ThreadLocal<RemoteWebDriver> remoteDriver) {
//		BrowserFactory1.driver = Remotedriver.get();
//
//	}

}
