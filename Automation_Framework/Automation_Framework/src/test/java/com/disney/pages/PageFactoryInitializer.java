package com.disney.pages;

import org.openqa.selenium.support.PageFactory;

import com.disney.wrappers.BaseMethod;

public class PageFactoryInitializer extends BaseMethod{
	
	public static LoginPage loginPage = null;
	public static HomePage homePage = null;
	
	public static void initializer() {
	
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		homePage = PageFactory.initElements(driver, HomePage.class);
		
	}
	 
	
}
