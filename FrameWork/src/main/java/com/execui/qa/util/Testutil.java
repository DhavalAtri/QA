package com.execui.qa.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Testutil {
	public static long PAGE_LOAD_TIMEOUT = 30; // Page Load time out which we
												// can change from here only
	public static long IMPLICIT_WAIT = 20; // Implicit wait

	/*
	 * Select the value from drop down
	 */
	public static void SelectDropDownValue(String Value, WebElement Locator) {
		Select authType = new Select(Locator);
		authType.selectByVisibleText(Value);
	}

}
