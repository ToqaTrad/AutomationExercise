package com.exerciseproject.homepage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.exerciseproject.base.BasePage;

public class CartPage extends BasePage{

	@FindBy(id="susbscribe_email")
	private WebElement subscrptionFiled;
	
	@FindBy(id="subscribe")
	private WebElement subscrptionButton;
	
	@FindBy(css="[class='alert-success alert']")
	private WebElement alert;
	
	@FindBy(xpath="//li/a[@href='/view_cart']")
	private WebElement cartTab;
	
	
	
	
	
	public void cartSubscrption() throws InterruptedException {
		action.click(cartTab);
		Thread.sleep(2000);
		action.sendText(subscrptionFiled, prop.getProperty("email"));
		Thread.sleep(2000);
		action.click(subscrptionButton);
		boolean actualResult = action.findElement(alert);
		softAssert.assertTrue(actualResult);
		softAssert.assertAll();
	}

}
