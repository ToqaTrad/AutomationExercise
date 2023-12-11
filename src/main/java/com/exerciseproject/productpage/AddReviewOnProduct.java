package com.exerciseproject.productpage;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.exerciseproject.base.BasePage;

public class AddReviewOnProduct extends BasePage{
	@FindBy(css = "[href='/products']")
	private WebElement productsTab;
	
	@FindBy(css="[class='title text-center']")
	private WebElement title;
	
	@FindBy(css = "[href='/product_details/1']")
	private WebElement viewProduct;
	
	@FindBy(css = "[href='#reviews']")
	private WebElement writeYourReview;
	
	@FindBy(xpath = "//form[@id='review-form']//input")
	private List<WebElement> details;
	
	@FindBy(id = "button-review")
	private WebElement buttonReview;
	
	@FindBy(xpath = "//form/textarea")
	private WebElement review;
	
	@FindBy(xpath = "//div[@class='col-md-12 form-group']/div[@class='alert-success alert']")
	private WebElement alert;
	
	public void addReview() {
		action.click(productsTab);
		boolean actualResult = action.findElement(title);
		softAssert.assertTrue(actualResult);
		if (actualResult) 
			System.out.println(title.getText()+" Page Is Displayed Successfully");
		action.scrollByVisibilityOfElement(driver, viewProduct);
		action.click(viewProduct);
		
		actualResult = action.findElement(writeYourReview);
		softAssert.assertTrue(actualResult);
		if (actualResult) 
			System.out.println(writeYourReview.getText()+" Is Displayed Successfully");
		
		action.scrollByVisibilityOfElement(driver, details.get(0));
		action.sendText(details.get(0), prop.getProperty("firstname"));
		action.sendText(details.get(1), prop.getProperty("email"));
		action.sendText(review, "Great product");
		action.scrollByVisibilityOfElement(driver, buttonReview);
		action.click(buttonReview);
		actualResult=action.findElement(alert);
		if (actualResult) 
			System.out.println(alert.getText()+" Is Displayed Successfully");
		softAssert.assertTrue(actualResult);
		softAssert.assertAll();
	
	}
}
