package com.exerciseproject.homepage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.exerciseproject.base.BasePage;

public class AddToCartFromRecommendedItems extends BasePage{
	@FindBy(xpath="//div[@class='recommended_items']/h2")
	private WebElement title;
	
	@FindBy(xpath="//div[@id='recommended-item-carousel']//a[@data-product-id='4']")
	private WebElement addToCart;
	
	@FindBy(xpath = "//div[@class='modal-body']//a[@href='/view_cart']")
	private WebElement   viewCart;
	
	@FindBy(css = "[id='product-4']")
	private WebElement   cartList;
	
	
	
	public void addRecommendedItems() throws InterruptedException {
		action.scrollByVisibilityOfElement(driver, title);
		boolean actualResult;
		actualResult = action.findElement(title);
		softAssert.assertTrue(actualResult);
		if (actualResult) 
			System.out.println(title.getText()+" Is Displayed Successfully");
		String expected = addToCart.getAttribute("data-product-id");
		action.click(addToCart);
		Thread.sleep(1000);
		action.click(viewCart);
		String actual = cartList.getAttribute("id");
		if(actual.contains(expected))
			actualResult = true;
		softAssert.assertTrue(actualResult);
		softAssert.assertAll();
		
	}

}
