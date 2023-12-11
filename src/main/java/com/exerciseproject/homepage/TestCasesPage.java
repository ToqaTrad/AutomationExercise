package com.exerciseproject.homepage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.exerciseproject.base.BasePage;

public class TestCasesPage extends BasePage{
	
	@FindBy(xpath="//ul/li/a[@href='/test_cases']")
	private WebElement testCasesTab;
	
	
	
	public void testCases() {
		
		String expectedResult = "https://automationexercise.com/test_cases";
		action.click(testCasesTab);
		String actualResult = action.getCurrentURL(driver);
		softAssert.assertEquals(actualResult, expectedResult);
		softAssert.assertAll();
		
	}

}
