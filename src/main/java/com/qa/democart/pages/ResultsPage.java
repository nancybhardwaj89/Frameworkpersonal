package com.qa.democart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.democart.utils.ElementUtil;

public class ResultsPage {
	
	private WebDriver driver;
	
	private ElementUtil elementutil;
	
	private By searchheader = By.cssSelector("div#content h1");
	
	private By productResults =  By.cssSelector("div.caption a");
	
	public ResultsPage(WebDriver driver)
	
	{
		
		this.driver = driver;
		
		elementutil = new ElementUtil(driver);
		
	}
	
	public String getSearchPageheader()
	
	{
		return elementutil.doGetText(searchheader);
	}
	
	public int getSearchProductListsCount()
	
	{
		return elementutil.getElements(productResults).size();
	}
	
	
	public ProductInfoPage selectProduct(String mainproducName) 
	{
		
		List<WebElement> searchList = elementutil.getElements(productResults);
		
		for(WebElement e : searchList)
			
		{
			if(e.getText().trim().equals(mainproducName))
			{
				e.click();
				
				break;
			}
		}
		
		return new ProductInfoPage(driver);
	}

}
