package com.disney.testcases;

import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.disney.pages.HomePage;
import com.disney.pages.LoginPage;
import com.disney.pages.PageFactoryInitializer;
import com.disney.wrappers.BaseMethod;
import com.disney.utils.CustomAssert;

public class LoginPageTest extends PageFactoryInitializer{
	
	CustomAssert customAssert;
	
//	@BeforeSuite
//	@Override
//	public void beforeSuite() {
//		super.beforeSuite();
//	}
//	
//	@BeforeClass
//	@Override
//	public synchronized void beforeMethod() {
//		super.beforeMethod();
//	}
	
	@BeforeMethod
	public void setUp() throws Exception
	{
		initializer();
		customAssert = new CustomAssert();
	}
	
//	@Test(priority = 1)
//	public void verifyPageTitleTest()
//	{
//		String title = loginPage.verifyPageTitle();
//		customAssert.assertEquals(title,"Login | Salesforce");
//	}
//	
//	@Test(priority = 2)
//	public void verifyLogoTest()	{
//		Boolean flag = loginPage.verifyLogo();
//		customAssert.assertTrue(flag); 
//	}

	@Test(priority = 3)
	public void loginTest() throws InterruptedException
	{
		homePage = loginPage.login();
		customAssert.assertEquals(getTitleByJS(driver), "Home | Salesforce");
		boolean flag = isDisplayed(loginPage.getVerifyGraphical());
		customAssert.assertTrue(flag);
		
	}

//	@AfterMethod
//	@Override
//	public synchronized void afterMethod(ITestResult result) {
//		super.afterMethod(result);
//	}
	
//	@AfterClass
//	@Override
//	public synchronized void closeBrowser() {
//		super.closeBrowser();
//	}
	
}
