package com.qa.democart.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.democart.factory.DriverFactory;
import com.qa.democart.pages.AccountsPage;
import com.qa.democart.pages.LoginPage;
import com.qa.democart.pages.ProductInfoPage;
import com.qa.democart.pages.RegistrationPage;
import com.qa.democart.pages.ResultsPage;

public class BaseTest {
	
	WebDriver driver;
	
	DriverFactory df;
	
	Properties prop;
	
	LoginPage loginpage;
	
	AccountsPage accpage;
	
	ResultsPage resultspage;
	
	ProductInfoPage productinfopage;
	
	RegistrationPage regpage;
	
	
	
	
	@BeforeTest
	public void setUp()
	
	{
		
		df= new DriverFactory();
		prop = df.initProperties();
		
		
		
		driver= df.initDriver(prop);
		
		loginpage = new LoginPage(driver);
		
		//accpage = new AccountsPage(driver);
		
		
		
	}

	
	@AfterTest
	
	public void tearDown()
	
	{
		
		
		driver.quit();
		
	}
}
