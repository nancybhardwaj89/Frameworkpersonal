package com.qa.democart.tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistrationPageTests extends BaseTest {

	@BeforeClass

	public void regSetup()

	{

		regpage = loginpage.navigateToRegisterPage();
	}

	
	public String getRandomEmail()
	
	{
		Random random = new Random();
		
		String email = "testautomation"+ random.nextInt(5000)+"@gmail.com";
		
		System.out.println("Random generated emails are:" +email);
		
		return email;
	}
	
	
	@DataProvider
	
	

//	public Object[][] getRegTestData()
//
//	{
//
//		return new Object[][] {
//
//				{ "Nagdfgftest", "bgfgftest", "123456789", "ABCabc@123", "yes" },
//				{ "Johna", "Leeaod","435435454", "dfdgg@fdfdg", "no" },
//				{ "Marmn,y", "Leetest",  "123456789", "ABCabc@123", "yes" } };
//
//	}

	@Test(dataProvider="getRegTestData")

	public void doRegistrationTest(String firstname, String lastname, String tele,String password, String subscribe)

	{
		Assert.assertTrue(regpage.accountRegister(firstname, lastname, getRandomEmail(), tele,password, subscribe));
	}
}
