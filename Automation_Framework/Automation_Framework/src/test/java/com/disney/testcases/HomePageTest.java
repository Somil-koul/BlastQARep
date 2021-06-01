package com.disney.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.disney.pages.PageFactoryInitializer;
import com.disney.utils.CustomAssert;

public class HomePageTest extends PageFactoryInitializer{
	
	CustomAssert customAssert;
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initializer();
		customAssert = new CustomAssert();
		homePage = loginPage.login();
	}
	
	@Test
	public void verifySalesCloudTest()
	{
		Boolean flag = homePage.verifySalesCloud();
		customAssert.assertTrue(flag);
	}
	
	
	
	
	

}
