package com.qa.democart.tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.democart.pages.AccountsPage;
import com.qa.democart.utils.Constants;
import com.qa.democart.utils.Errors;

public class LoginPageTest extends BaseTest {
	@Test(priority = 1)
	public void verfiyLoginPageTitle()

	{
		String title = loginpage.getLoginPagetitle();

		System.out.println("Page Title is:" + title);

		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE, Errors.TITLE_ERROR_MESSAGE);

	}

	@Test(priority = 2)

	public void verfiyLoginPageHeader()

	{

		String pageheader = loginpage.getPageHeaderText();

		System.out.println("Login page header is:" + pageheader);

		Assert.assertEquals(pageheader, Constants.PAGE_HEADER, Errors.LOGIN_PAGE_HEADER_ERROR_MESSAGE);

	}

	@Test(priority = 3)

	public void verfiyForgotPwdLink()

	{

		Assert.assertTrue(loginpage.isForgortPwdLinkExists(), Errors.FORGOT_PASSWORD_LINK_ERROR_MESSAGE);

	}

	@Test(priority = 4)

	public void loginTest()

	{

		AccountsPage accPage = loginpage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Assert.assertTrue(accPage.isLogoutLinkExists());
	}

}
