package com.qa.democart.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.democart.utils.Constants;
import com.qa.democart.utils.ElementUtil;

public class AccountsPage {

	private WebDriver driver;

	private ElementUtil elementutil;

	private By accSections = By.cssSelector("div#content h2");

	private By Headertext = By.xpath("//a[normalize-space()='Your Store']");

	private By logoutlink = By.linkText("Logout");

	private By searchField = By.name("search");

	private By searchButton = By.xpath("//button[@class='btn btn-default btn-lg']");

	public AccountsPage(WebDriver driver)

	{
		this.driver = driver;

		elementutil = new ElementUtil(driver);

	}

	public String getAccPageTitle()

	{
		return elementutil.waitForTitleIs(Constants.ACCOUNT_PAGE_TITLE, 5);

	}

	public String getAccPageURL()

	{

		return elementutil.waitForUrlContains(Constants.ACCOUNT_PAGE_URL_FRACTION, 10);
	}
	
	
	public String getAccPageheader()
	
	{
		return elementutil.doGetText(Headertext);
	}
	
	
	
	public List<String> getAccSectionList()
	
	{
		List<String> accSecValueList =new ArrayList<String>();
		List<WebElement> accSecList = elementutil.getElements(accSections);
		for(WebElement e: accSecList)
		{
			accSecValueList.add(e.getText());
		}
		
		//Collections.sort(accSecValueList);
		
		return accSecValueList;
	}
	
	public boolean isLogoutLinkExists()
	
	{
		
		
		return elementutil.doIsDisplayed(logoutlink);
	}
	
	public ResultsPage doSearch(String productName)
	{
		System.out.println("Product name is:" + productName);
		elementutil.doSendKeys(searchField, productName);
		elementutil.doClick(searchButton);
		return new ResultsPage(driver);
	}

}
