package com.exerciseproject.productpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.exerciseproject.base.BasePage;

public class AddProductWithQuantity extends BasePage{
	@FindBy(css = "[href='/products']")
	private WebElement productsTab;
	
	@FindBy(css = "[href='/product_details/1']")
	private WebElement viewProductButton;
	
	@FindBy(id = "quantity")
	private WebElement quantity;
	
	@FindBy(css = "[type='button']")
	private WebElement addToCart;
	
	@FindBy(xpath = "//p[@class='text-center']/a[@href='/view_cart']")
	private WebElement viewCart;
	
	@FindBy(css = "[class='disabled']")
	private  WebElement actualQuantity;
	
	
	public void addProduct() throws InterruptedException{
		String expectedResult = "4";
		action.click(productsTab);
		Thread.sleep(2000);
		action.click(viewProductButton);
		action.sendText(quantity, expectedResult);
		action.click(addToCart);
		Thread.sleep(2000);
		action.click(viewCart);
		Thread.sleep(2000);
		String actualResult = actualQuantity.getText();
				softAssert.assertEquals(actualResult, expectedResult);
				softAssert.assertAll();
	 
}
		
		
	}
	
	
	

