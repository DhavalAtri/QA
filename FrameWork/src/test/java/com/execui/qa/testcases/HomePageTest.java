package com.execui.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.execui.qa.base.TestBase;
import com.execui.qa.pages.HomePage;
import com.execui.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	
	public HomePageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		// To reach at home Page we have to do Login for that we have created the Login page class objects 
		loginpage = new LoginPage();
		homepage= loginpage.Login(prop.getProperty("username"), prop.getProperty("password"),
				prop.getProperty("clientid"), prop.getProperty("secret"));
	}
	
	
	@Test
	public void verifyHomePageMainLable(){
		String cotentTitle =homepage.verifyContenttitle();
		Assert.assertEquals(cotentTitle, "Solumina REST API","Home Page Content Title not Matched");
		
	}
	
	
	@Test 
	public void verifyHomePageContentDesc(){
		String contentDesc = homepage.verifyContentDesc();
		Assert.assertEquals(contentDesc ,"Created by iBASEt" , "Home Page description not matched"); 
	}
	
	@AfterMethod
	public void testDown() {
		driver.quit();
	}
	
	
}
