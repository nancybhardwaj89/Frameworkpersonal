package com.qa.democart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.democart.utils.Constants;
import com.qa.democart.utils.ElementUtil;

public class RegistrationPage {
	
	private WebDriver driver;
	
	private ElementUtil elementutil;
	
	
	private By FirstName = By.id("input-firstname");
	
	private By LastName = By.id("input-lastname");
	
	private By Email = By.id("input-email");
	
	private By Telephone = By.id("input-telephone");
	
	private By Password = By.id("input-password");
	
	private By ConfirmPassword = By.id("input-confirm");
	
	private By SubsriberYes = By.xpath("//label[normalize-space()='Yes']");
	
	private By SubsriberNo = By.xpath("//input[@value='0']");
	
	private By AgreePrivacy = By.xpath("//input[@name='agree']");
	
	private By ContinueButton = By.xpath("//input[@value='Continue']");
	
	private By SuccessMsg = By.cssSelector("div#content h1");
	
	private By LogoutLink = By.linkText("Logout");
	
	private By RegisterLink = By.linkText("Register");
	
	
	public 
	
	RegistrationPage(WebDriver driver)
	{
		this.driver =  driver;
		
		elementutil = new ElementUtil(driver);
	}
	
	
	
	public boolean accountRegister(String firstname, String lastname, String email, String tele,String password, String subscribe)
	
	{
		elementutil.doSendKeys(FirstName, firstname);
		
		elementutil.doSendKeys(LastName, lastname);
		
		elementutil.doSendKeys(Email, email);
		
		elementutil.doSendKeys(Telephone, tele);
		
		elementutil.doSendKeys(Password, password);
		
		elementutil.doSendKeys(ConfirmPassword, password);
		
		if(subscribe.equalsIgnoreCase("yes"))
			
		{
			elementutil.doClick(SubsriberYes);
		}
		
		else
		{
			elementutil.doClick(SubsriberNo);
		}
		
		elementutil.doClick(AgreePrivacy);
		
		elementutil.doClick(ContinueButton);
		
		String message = elementutil.waitForElementPresence(SuccessMsg, Constants.DEFAULT_TIME_OUT).getText();
		
		System.out.println("Registration page sucess message is:" +message);
		
		if(message.contains(Constants.REGISTER_PAGE_SUCCESS_MSG))
		{
			elementutil.doClick(LogoutLink);
			elementutil.doClick(RegisterLink);
			return true;
		}
		
		return false;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
