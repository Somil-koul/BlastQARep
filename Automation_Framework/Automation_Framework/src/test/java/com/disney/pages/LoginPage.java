package com.disney.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.internal.BaseTestMethod;

import com.disney.browsermanager.BrowserFactory;
import com.disney.browsermanager.InitMethod;
import com.disney.common.Constants;
import com.disney.utils.Common;
import com.disney.wrappers.BaseMethod;

public class LoginPage extends BaseMethod{
	
	//Object repository for login page
	
	@FindBy(id = "logo")
	private WebElement logo;
	
	@FindBy(name = "username") 
	public WebElement usernamefield;
	
	@FindBy(id = "password")
	public WebElement passwordfield;
	
	@FindBy(id = "Login")
	private  WebElement loginBtn;
	
	@FindBy(xpath = "//h2[text()='Verify Your Identity']")
	private WebElement verificationHeading;
	
	@FindBy(id = "emc")
	private WebElement verificationCodeField;
	
	@FindBy(id = "save")
	private WebElement verifyBtn;
	
	@FindBy(xpath = "//span[text()='Quarterly Performance']")
	private WebElement verifyGraphical;
	
	
	
//	public LoginPage() {
//		this.driver = driver;
//		PageFactory.initElements(driver, this);
//	}
	
	public WebElement getVerifyGraphical() {
		return verifyGraphical;
	}

	public String verifyPageTitle()
	{
		return getTitleByJS(driver);
	}
	
	public Boolean verifyLogo()
	{
		return isDisplayed(logo);
	}
	
	public HomePage login() throws InterruptedException
	{

//		usernamefield.sendKeys(UserName);
//		passwordfield.sendKeys(Password);
//		loginBtn.click();	
		sendKeys(usernamefield, UserName);
		sendKeys(passwordfield, Password);
		click(loginBtn);
		isDisplayed(verificationHeading);
		Thread.sleep(Constants.XXLARGE_PAUSE_MILLISECONDS);
		click(verifyBtn);
		return new HomePage();
		
		
	}


}
