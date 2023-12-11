package com.exerciseproject.signuppage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.exerciseproject.base.BasePage;
import com.exerciseproject.productpage.AddProductsInCart;

public class VerifyAddressDetailsInCheckoutPage extends BasePage{
	private RegistrationPage registrationPage;
	private AddProductsInCart addProductsInCart;
	
	@FindBy(css="[class='btn btn-default check_out']")
	private WebElement proceedToCheckout;
	
	@FindBy(id="address_delivery")
	private WebElement addressDelivery;
 
 
 
 public void verifyAddressDetails() throws InterruptedException {
	 registrationPage = new RegistrationPage();
	 addProductsInCart = new AddProductsInCart();
	 registrationPage.registration();
	 addProductsInCart.addToCart();
	 action.click(proceedToCheckout);
	 
 }
}
