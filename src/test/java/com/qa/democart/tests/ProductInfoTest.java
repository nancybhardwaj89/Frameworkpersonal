package com.qa.democart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductInfoTest extends BaseTest {
	
	
	@BeforeClass
	
	public void ProductInfoPageSetup()
	
	{
		accpage = loginpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test
	public void productImagesTest()
	
	{
		resultspage = accpage.doSearch("iMac");
		
		productinfopage = resultspage.selectProduct("iMac");
		
		Assert.assertEquals(productinfopage.getProductImagesCount(),3);
		
	}
	
	@Test
	
	public void prodcutInfoTest()
	
	{
		resultspage = accpage.doSearch("Macbook");
		
		productinfopage = resultspage.selectProduct("MacBook Pro");
		
		Map<String, String> actProdcutInfoMap = productinfopage.getProductInfo();
		
		Assert.assertEquals(actProdcutInfoMap.get("name"), "MacBook Pro");
		
		Assert.assertEquals(actProdcutInfoMap.get("Brand"), "Apple");
		
		Assert.assertEquals(actProdcutInfoMap.get("Product Code"), "Product 18");
		
		//Assert.assertEquals(actProdcutInfoMap.get("price"), "$2,000.00");
		
	}
	
	
	
	
	

}
