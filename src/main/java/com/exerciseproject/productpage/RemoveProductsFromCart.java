package com.exerciseproject.productpage;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.exerciseproject.base.BasePage;

public class RemoveProductsFromCart extends BasePage {

	@FindBy(xpath = "//div[@class='productinfo text-center']//a[@data-product-id='35']")
	private WebElement addToCartFirstProduct;

	@FindBy(xpath = "//div[@class='productinfo text-center']//a[@data-product-id='4']")
	private WebElement addToCartSecondProduct;

	@FindBy(xpath = "//div[@class='productinfo text-center']//a[@data-product-id='13']")
	private WebElement addToCartThirdProduct;

	@FindBy(xpath = "//div[@class='modal-body']//a[@href=\"/view_cart\"]")
	private WebElement viewCart;

	@FindBy(xpath = "//ol/li[@class='active']")
	private WebElement shoppingCart;

	@FindBy(className = "cart_quantity_delete")
	private List<WebElement> deleteFromCart;

	@FindBy(xpath = "//table[@class = 'table table-condensed']/tbody/tr")
	private List<WebElement> cartList;

	@FindBy(css = "[class = 'btn btn-success close-modal btn-block']")
	private WebElement continueShopping;

	public void removeProductsFromCart() throws InterruptedException {

		action.click(addToCartFirstProduct);
		String strNumber = addToCartFirstProduct.getAttribute("data-product-id");
		Thread.sleep(1000);
		action.click(continueShopping);
		action.click(addToCartSecondProduct);
		Thread.sleep(1000);
		action.click(continueShopping);
		action.click(addToCartThirdProduct);
		Thread.sleep(1000);
		action.click(viewCart);
		softAssert.assertTrue(action.findElement(shoppingCart));
		System.out.println("Cart page is displayed");
		boolean actualResult;

		for (int i = 0; i < cartList.size(); i++) {
			String item = cartList.get(i).getAttribute("id");
			if (item.contains(strNumber)) {
				action.click(deleteFromCart.get(i));
				System.out.println("The item has been deleted ");
			}
		}
		for (int j = 0; j < cartList.size(); j++) {
			String item = cartList.get(j).getAttribute("id");
			if (item.contains(strNumber)) {
				actualResult = false;
				System.out.println("The item not deleted successfully");

			} else  {
				actualResult = true;
				System.out.println("The item has been deleted successfully");
				}
			softAssert.assertTrue(actualResult);
			softAssert.assertAll();

		}
		
	}
}
