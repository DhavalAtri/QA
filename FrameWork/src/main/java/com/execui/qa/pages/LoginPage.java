package com.execui.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.execui.qa.base.TestBase;
import com.execui.qa.util.Testutil;

// Extending the Page class from base class to utilize the methods from testbase class 
public class LoginPage extends TestBase {
	// Page factory - Object Repository - OR
	
	
	@FindBy(className = "authorize__btn")
	WebElement Authorizebtn;
	
	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(name = "client-authentication-type")
	WebElement AuthType;

	@FindBy(name = "client-id")
	WebElement clientid;

	@FindBy(name = "client-secret")
	WebElement clientSecret;

	@FindBy(xpath = "//*[@id=\"swagger-ui-container\"]/div[3]/div[1]/div[2]/div/div/div/div[1]/div/div/div/div/ul/li/input")
	WebElement SoluminaAdminCheckmark;

	@FindBy(xpath = "//*[@id=\"swagger-ui-container\"]/div[3]/div[1]/div[2]/div/div/div/div[2]/button")
	WebElement Loginbtn;

	@FindBy(className = "logo__title")
	WebElement Logo;

	// Initializing the page objects :
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Below are the Actions :
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateIbaseTlogo() {
		return Logo.isDisplayed();
	}

	public void selectAuthType() {
		Select authType = new Select(AuthType);
		authType.selectByVisibleText("Basic auth");
	}

	public HomePage Login(String uname, String pass, String Client, String Secret) {
		Authorizebtn.click();
		username.sendKeys(uname);
		password.sendKeys(pass);
		// Using the common method from the utility class TestUtil.java
		Testutil.SelectDropDownValue("Basic auth", AuthType); 
		clientid.sendKeys(Client);
		clientSecret.sendKeys(Secret);
		SoluminaAdminCheckmark.click();
		Loginbtn.click();
		/*
		 *Returning HomePage because Login Page have home page as lending page so from
		 *below line of code we are indirectly initializing the Web-objects of HomePag 
		 */
		return new HomePage();

	}

}
