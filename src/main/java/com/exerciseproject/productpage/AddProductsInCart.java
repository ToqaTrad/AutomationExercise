package com.exerciseproject.productpage;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.exerciseproject.base.BasePage;

public class AddProductsInCart extends BasePage{
	
	@FindBy(css = "[href='/products']")
	private WebElement productsTab;
	
	@FindBy(xpath = "//div[@class='productinfo text-center']//a[@data-product-id='1']")
	private WebElement   addToCartFirstButton;
	
//	@FindBy(id = "product-1")
//	private WebElement   firstProduct;
//	
//	@FindBy(id = "product-2")
//	private WebElement   secondProduct;
	
	@FindBy(xpath = "//div[@class='productinfo text-center']//a[@data-product-id='2']")
	private WebElement   addToCartSecondButton;
	
	@FindBy(css = "[class = 'btn btn-success close-modal btn-block']")
	private WebElement   continueShopping;
	
	@FindBy(xpath = "//div[@class='modal-body']//a[@href=\"/view_cart\"]")
	private WebElement   viewCart;
	
	@FindBy(xpath = "//div[@class='col-sm-4']//div[@class='productinfo text-center']/p")
	private List<WebElement>   productsList;
	
	@FindBy(xpath = "//table[@id = 'cart_info_table']/tbody/tr")
	private List<WebElement>   cartList;
	
	

	
	
	

	public void addToCart() throws InterruptedException {
		action.click(productsTab);
		Thread.sleep(2000);
		action.scrollByVisibilityOfElement(driver, addToCartFirstButton);
		String[] expectedResult = new String[productsList.size()];
			for (int i = 0 ;i<productsList.size();i++) {
				expectedResult[i] = productsList.get(i).getText();
			}
		action.click(addToCartFirstButton);
		Thread.sleep(2000);
		action.click(continueShopping);
		action.click(addToCartSecondButton);
		Thread.sleep(3000);
		action.click(viewCart);
		boolean actualResult;
		Thread.sleep(3000);
		for(int i = 0 ; i<cartList.size();i++) {
			String item = action.getText(cartList.get(i));
			if(item.contains(expectedResult[i])) {
				actualResult = true;
				softAssert.assertTrue(actualResult);
				softAssert.assertAll();
	 }
}
}
	
	
	
	}