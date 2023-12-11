package com.exerciseproject.homepage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.exerciseproject.base.BasePage;

public class SubscriptionInFooter extends BasePage{
	
	@FindBy(id="susbscribe_email")
	private WebElement subscrptionFiled;
	
	@FindBy(id="subscribe")
	private WebElement subscrptionButton;
	
	@FindBy(css="[class='alert-success alert']")
	private WebElement alert;
	
	
	public void subscrption() throws InterruptedException {
		action.sendText(subscrptionFiled, prop.getProperty("email"));
		Thread.sleep(3000);
		action.click(subscrptionButton);
		boolean actualResult = action.findElement(alert);
		softAssert.assertTrue(actualResult);
		softAssert.assertAll();
	}
	

}
