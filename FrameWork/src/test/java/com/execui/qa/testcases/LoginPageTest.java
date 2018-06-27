package com.execui.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.execui.qa.base.TestBase;
import com.execui.qa.pages.HomePage;
import com.execui.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	// initializing the object at class level so we can utilize thoughout the
	// class
	LoginPage loginpage;
	HomePage homepage;

	public LoginPageTest() {
		// calling the parent class constructor because properties file
		// initialization are in super class constructor
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
	}

	@Test (priority = 1)
	public void loginPageTitleTest() {
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "Solumina API");
	}

	@Test(priority = 2)
	public void swggerLogoImageTest() {
		boolean result = loginpage.validateIbaseTlogo();
		Assert.assertTrue(result);
	}

	@Test(priority = 3)
	public void loginTest() {
		homepage = loginpage.Login(prop.getProperty("username"), prop.getProperty("password"),
				prop.getProperty("clientid"), prop.getProperty("secret"));
	}

	@AfterMethod
	public void testDown() {
		driver.quit();
	}

}
