package com.qa.democart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.democart.utils.Constants;

public class AccountsPageTest extends BaseTest

{

	@BeforeClass

	public void accPageSetup()

	{
		accpage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority=1)
	public void accPageTitleTest()

	{
		String title = accpage.getAccPageTitle();

		System.out.println("Account Page Title is:" + title);

		Assert.assertEquals(title, Constants.ACCOUNT_PAGE_TITLE);
	}

	@Test(priority=2)
	public void accPageHeaderTest()

	{
		String header = accpage.getAccPageheader();

		System.out.println("Account page header is:" + header);

		Assert.assertEquals(header, Constants.PAGE_HEADER);

	}
	
	
	@Test(priority=3)
	
	public void accSectionListTest()
	
	{
		
		List<String> acctsecList = accpage.getAccSectionList();
		
		System.out.println("Actual Section List under Accounts is:" + acctsecList);
		
		Assert.assertEquals(acctsecList, Constants.EXPECTED_ACC__SEC_LIST);
	}
	
	@Test(priority=4)
	public void isLogoutLinkExistsTest()
	
	{
		
		
		Assert.assertTrue(accpage.isLogoutLinkExists());
	
	}
	
	@DataProvider
	
	public Object[][] getSearchData()
	
	{
		
		
		return new Object[][] {
			{"Macbook Pro"}, 
			{"Macbook Air"}, 
			{"Apple"}
			};
	}
	
	@Test(priority=5, dataProvider = "getSearchData")
	public void searchTest(String productName)
	{
		resultspage = accpage.doSearch(productName);
		
		String resultheader = resultspage.getSearchPageheader();
		
		System.out.println("Result page header is: " +resultheader);
		
		Assert.assertTrue(resultheader.contains(productName));
	}

	
	@DataProvider
	
	public Object[][] getProductSelectData()
	
	{
		return new Object[][] {
				
				{"Macbook" , "MacBook Air"},
				{"Macbook" , "MacBook Pro"},
				{"Apple", "Apple Cinema 30\""}
		};
	}
	
	@Test(priority=6, dataProvider="getProductSelectData")
	
	public void selectProductTest(String productName, String mainproductName)
	
	{
		
		resultspage = accpage.doSearch(productName);
		
		productinfopage = resultspage.selectProduct(mainproductName);
		
		String header = productinfopage.getProductHeaderText();
		
		System.out.println("Product header is:" +header);
		
		
		Assert.assertEquals(header, mainproductName);
	}
	
	
	
	
	
	
	
}
