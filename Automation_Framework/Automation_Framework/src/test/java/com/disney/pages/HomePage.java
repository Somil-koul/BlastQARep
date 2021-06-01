package com.disney.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.disney.wrappers.BaseMethod;

public class HomePage extends BaseMethod{
	
	@FindBy(xpath = "//span[@title='Sales']")
	private WebElement salesCloud;
	
	@FindBy(xpath = "//div[@role='navigation']/one-app-launcher-header/button/div[@class='slds-icon-waffle']")
	private WebElement applauncher;
	
	@FindBy(xpath = "//p[text()='Sales']")
	private WebElement selectSalesCloud;
	
	@FindBy(xpath = "//span[text()='Accounts']")
	private WebElement accountsTab;
	
	@FindBy(xpath = "//li/span[text()='Accounts']")
	private WebElement verifyAccountsPage;
	
	@FindBy(xpath = "//div[@title='New']")
	private WebElement newBtn;
	
	@FindBy(xpath = "//h2[text()='New Account']")
	private WebElement newAccountHeading;
	
	@FindBy(name = "Name")
	private WebElement enterAccountName;
	
	@FindBy(name = "SaveEdit")
	private WebElement saveBtn;
	
	public boolean verifySalesCloud()
	{
		return isDisplayed(salesCloud);
	}
	
	public void addNewAccount()
	{
		click(accountsTab);
		if(isDisplayed(verifyAccountsPage))
		{
			click(newBtn);
			switchtoWindow();
			if(isDisplayed(newAccountHeading))
			{
				sendKeys(enterAccountName, "DisneyDemo");
				click(saveBtn);
				
			}
		}

	}
	
	

}
