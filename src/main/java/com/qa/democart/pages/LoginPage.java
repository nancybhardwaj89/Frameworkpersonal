package com.qa.democart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.democart.utils.Constants;
import com.qa.democart.utils.ElementUtil;

public class LoginPage {
	
	private WebDriver driver;
	
	private ElementUtil elementutil;
	
	//Private Locators
	
	private By EmailID = By.id("input-email");
	
	private By Password = By.id("input-password");
	
	private By LoginButton = By.xpath("//input[@type='submit']");
	
	private By ForgotPasswordLink = By.xpath("//div[@class='form-group']//a[normalize-space()='Forgotten Password']");
	
	private By Headertext = By.xpath("//a[normalize-space()='Your Store']");
	
	private By RegisterLink = By.linkText("Register");
	
	
	
	
	//Constructor
	
	public LoginPage(WebDriver driver)
	
	{
		this.driver = driver;
		
		elementutil = new ElementUtil(driver);
		
		
	}
	
	//Page Methods and no assesrations
	
	
	public String getLoginPagetitle()
	
	{
		return elementutil.waitForTitleIs(Constants.LOGIN_PAGE_TITLE, 5);
		
		
	}
	
	public String getPageHeaderText()
	{
		
		return elementutil.doGetText(Headertext);
	}
	
	
	
	
   public boolean isForgortPwdLinkExists( ) {
	   
   return elementutil.doIsDisplayed(ForgotPasswordLink);

    //return driver.findElement(ForgotPasswordLink).isDisplayed();
	
   }
   
   
   public AccountsPage doLogin(String un, String pwd)
   {
	   
	   elementutil.doSendKeys(EmailID, un);
	   
	   elementutil.doSendKeys(Password, pwd);
	   
	   elementutil.doClick(LoginButton);
	   
	   return new AccountsPage(driver);
	   
	   
	   //driver.findElement(EmailID).sendKeys(un);
	   
	   //driver.findElement(Password).sendKeys(pwd);
	   
	   //driver.findElement(LoginButton).click();
   }
   
	
   public RegistrationPage navigateToRegisterPage()
   
   {
	   elementutil.doClick(RegisterLink);
	   
	   return new RegistrationPage(driver);
   }
   
   
   
   
}
