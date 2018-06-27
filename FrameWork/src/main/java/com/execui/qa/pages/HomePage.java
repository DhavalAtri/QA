package com.execui.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.execui.qa.base.TestBase;
import com.execui.qa.util.Testutil;

public class HomePage extends TestBase {

	@FindBy(className = "info_title")
	WebElement infoTitle;
					 //*[@id="api_info"]/div[3]
	@FindBy(xpath = "//*[@id='api_info']/div[3]")
	WebElement Description;

	@FindBy(id = "select_baseUrl")
	WebElement selectBaseUrlDropdown;

	// Initializing the page Objects :
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyContenttitle() {
		return infoTitle.getText();
		
	}

	public String verifyContentDesc() {
		return Description.getText();
		
	}

	
	// Navigating to Unit info and initializing the all Webobjects of Unit info page
	public UnitInfoPage selectUnitInfo() {
		Testutil.SelectDropDownValue("UnitInfo (/v2/api-docs?group=UnitInfo)", selectBaseUrlDropdown);
		return new UnitInfoPage();
	}

	
	
	

}
