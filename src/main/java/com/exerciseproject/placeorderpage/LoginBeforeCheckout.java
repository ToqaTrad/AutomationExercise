package com.exerciseproject.placeorderpage;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.exerciseproject.base.BasePage;

public class LoginBeforeCheckout extends BasePage{
	
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
	
	@FindBy(xpath = "//div[@class='productinfo text-center']//a[@data-product-id='35']")
	private WebElement   addToCartFirstProduct;
	
	@FindBy(xpath="//p/a[@href='/view_cart']")
	private WebElement viewCart;
	
	@FindBy(xpath="//ol/li[@class='active']")
	private WebElement  shoppingCart ;
	
	@FindBy(css="[class='btn btn-default check_out']")
	private WebElement proceedToCheckout;
	@FindBy(xpath = "//table[@class = 'table table-condensed']/tbody/tr")
	private List<WebElement>   cartList;
	
	@FindBy(xpath = "//div[@class=\"col-md-4\"]//div[@class='form-row']//input")
	private List<WebElement>   cardPayment;
	
	@FindBy(name = "message")
	private WebElement  message;
	@FindBy(xpath = "//div/a[@href=\"/payment\"]")
	private WebElement  placeOrder;
	
	@FindBy(css = "[data-qa='pay-button']")
	private WebElement  payAndConfirm;
	
	
	@FindBy(xpath="//div[@class='col-sm-9 col-sm-offset-1']//p")
	private WebElement alert1;
	
	@FindBy(xpath="//div[@class='container']//h2[@data-qa='account-deleted']")
	private WebElement  deleteAccountConfirmation ;
	
	
	@FindBy(xpath="//a[@data-qa='continue-button']")
	private WebElement continueButton;
	
	@FindBy(xpath="//a[@href='/delete_account']")
	private WebElement  deleteAccount ;
	
	
	
	public void loginbeforeCheckout() throws InterruptedException {
		action.click(loginTab);
		action.sendText(emailAddressFiled, prop.getProperty("email"));
		action.sendText(passwordFiled, prop.getProperty("password"));
		action.click(loginButton);
		String expectedResult = prop.getProperty("username");
		String actualResult = loggedInAs.getText();
		Thread.sleep(3000);
		softAssert.assertEquals(actualResult, expectedResult);
		softAssert.assertAll();
		System.out.println("Verify You Logged In Successfully");
		action.scrollByVisibilityOfElement(driver, addToCartFirstProduct);
		action.click(addToCartFirstProduct);
		String strNumber = addToCartFirstProduct.getAttribute("data-product-id");
		Thread.sleep(2000);
		action.click(viewCart);
		softAssert.assertTrue(action.findElement(shoppingCart));
		System.out.println("Cart page is displayed");
		action.click(proceedToCheckout);
		Thread.sleep(2000);
		boolean actualResult1;
		Thread.sleep(2000);
		for(int i = 0 ; i<cartList.size();i++) {
			String item = cartList.get(i).getAttribute("id");
			if(item.contains(strNumber)) {
				actualResult1 = true;
				softAssert.assertTrue(actualResult1);
				softAssert.assertAll();
				System.out.println("Verify Your Order is Correct");
	 }
}	
		Thread.sleep(1000);				
		action.scrollByVisibilityOfElement(driver, placeOrder);
		action.sendText(message, "Great");
		action.click(placeOrder);
		String nameOnCard = loggedInAs.getText();
		action.scrollByVisibilityOfElement(driver, cardPayment.get(1));
		cardPayment.get(0).sendKeys(nameOnCard);
		cardPayment.get(1).sendKeys("1234567890");
		cardPayment.get(2).sendKeys("123");
		cardPayment.get(3).sendKeys("11");
		cardPayment.get(4).sendKeys("2024");
		Thread.sleep(2000);
		action.click(payAndConfirm);
		Thread.sleep(3000);
		actualResult1 = action.findElement(alert1);
		softAssert.assertTrue(actualResult1);
		softAssert.assertAll();
		System.out.println("Verify Your order has been placed successfully");
		action.click(logout);
		 expectedResult = "Signup / Login";
		 actualResult = loginTab.getText();
		softAssert.assertEquals(actualResult, expectedResult);
		softAssert.assertAll();
		System.out.println("Verify You Logged Out Successfully");

	}
	

}
