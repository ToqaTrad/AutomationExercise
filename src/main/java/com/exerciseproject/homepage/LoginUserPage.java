package com.exerciseproject.homepage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.exerciseproject.base.BasePage;

public class LoginUserPage extends BasePage{
	
	@FindBy(xpath = "//a[@href='/login']")
	private WebElement loginTab;
	
	@FindBy(xpath = "//input[@data-qa='login-email']")
	private WebElement emailAddressFiled;
	
	@FindBy(name = "password")
	private WebElement passwordFiled ;
	
	@FindBy(xpath="//a/b")
	private WebElement  loggedInAs ;
	
	@FindBy(xpath = "//button[@data-qa='login-button']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//a[@href='/logout']")
	private WebElement logout;
	
	@FindBy(xpath = "//p[normalize-space()='Your email or password is incorrect!']")
	private WebElement errorMessage;
	
	
	public void loginUserWithCorrectData() throws InterruptedException {
		
		action.click(loginTab);
		action.sendText(emailAddressFiled, prop.getProperty("email"));
		action.sendText(passwordFiled, prop.getProperty("password"));
		action.click(loginButton);
		String expectedResult = prop.getProperty("username");
		String actualResult = loggedInAs.getText();
		Thread.sleep(3000);
		action.click(logout);
		softAssert.assertEquals(actualResult, expectedResult);
		softAssert.assertAll();
	}
	
	public void loginUserWithIncorrectData() {
		action.click(loginTab);
		action.sendText(emailAddressFiled, prop.getProperty("email"));
		action.sendText(passwordFiled, "123456");
		action.click(loginButton);
		boolean actualResult = errorMessage.isDisplayed();
		softAssert.assertTrue(actualResult);
		softAssert.assertAll();
	}
	
	public void logoutAccount() {
		
		action.click(loginTab);
		action.sendText(emailAddressFiled, prop.getProperty("email"));
		action.sendText(passwordFiled, prop.getProperty("password"));
		action.click(loginButton);
		action.click(logout);
		String expectedResult = "Signup / Login";
		String actualResult = loginTab.getText();
		softAssert.assertEquals(actualResult, expectedResult);
		softAssert.assertAll();
	}

	

}
