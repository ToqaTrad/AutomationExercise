package com.exerciseproject.placeorderpage;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.exerciseproject.base.BasePage;

public class RegisterWhileCheckout extends BasePage{

	@FindBy(xpath = "//div[@class='productinfo text-center']//a[@data-product-id='35']")
	private WebElement   addToCartFirstProduct;
	
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li/a[@href=\"/view_cart\"]")
	private WebElement cartTab;
	
	@FindBy(xpath="//p/a[@href='/view_cart']")
	private WebElement viewCart;
	
	@FindBy(css="[class='btn btn-default check_out']")
	private WebElement proceedToCheckout;
	
	@FindBy(xpath="//p[@class=\"text-center\"]//a[@href=\"/login\"]")
	private WebElement registerLogin;
	
	@FindBy(name = "name")
	private WebElement usernameFiled;
	
	@FindBy(xpath = "//input[@data-qa='signup-email']")
	private WebElement emailFiled;
	
	@FindBy(xpath = "//button[@data-qa='signup-button']")
	private WebElement signupButton;
	
	@FindBy(id = "id_gender1")
	private WebElement maleGender;
	
	@FindBy(id = "id_gender2")
	private WebElement femaleGender;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="days")
	private WebElement days;
	
	@FindBy(id="months")
	private WebElement months;
	
	@FindBy(id="years")
	private WebElement years;
	
	@FindBy(id="first_name")
	private WebElement firstName;
	
	@FindBy(id="last_name")
	private WebElement lastName;
	
	@FindBy(id="company")
	private WebElement company;
	
	@FindBy(id="address1")
	private WebElement address1;
	
	@FindBy(id="country")
	private WebElement country;
	
	@FindBy(id="state")
	private WebElement state;
	
	@FindBy(id="city")
	private WebElement city;
	
	@FindBy(id="zipcode")
	private WebElement zipCode;
	
	@FindBy(id="mobile_number")
	private WebElement mobileNumber;
	
	@FindBy(xpath="//button[@data-qa='create-account']")
	private WebElement createAccountButton;
	
	@FindBy(xpath="//a[@data-qa='continue-button']")
	private WebElement continueButton;
	
	@FindBy(xpath="//a/b")
	private WebElement  loggedInAs ;
	
	@FindBy(xpath="//a[@href='/delete_account']")
	private WebElement  deleteAccount ;
	
	@FindBy(xpath="//div[@class='container']//h2[@data-qa='account-deleted']")
	private WebElement  deleteAccountConfirmation ;

	@FindBy(id="newsletter")
	private WebElement  newsletterCheckbox ;
	
	@FindBy(id="optin")
	private WebElement  optinCheckbox ;
	
	@FindBy(xpath="//p[normalize-space()='Email Address already exist!']")
	private WebElement  errorMessage ;
		
	@FindBy(xpath = "//table[@class = 'table table-condensed']/tbody/tr")
	private List<WebElement>   cartList;
	
	@FindBy(xpath = "//div[@class=\"col-md-4\"]//div[@class='form-row']//input")
	private List<WebElement>   cardPayment;
	
	@FindBy(id="success_message")
	private WebElement alert;
	
	@FindBy(xpath="//div[@class='col-sm-9 col-sm-offset-1']//p")
	private WebElement alert1;
	
	@FindBy(name = "message")
	private WebElement  message;
	@FindBy(xpath = "//div/a[@href=\"/payment\"]")
	private WebElement  placeOrder;
	
	@FindBy(css = "[data-qa='pay-button']")
	private WebElement  payAndConfirm;
	
	
	String randomEmail = "abc"+rand.nextInt()+"@gmail.com";
	String randomUsername= "abc"+rand.nextInt();
	
	public void registerWhileCheckout() throws InterruptedException {
		action.click(addToCartFirstProduct);
		String strNumber = addToCartFirstProduct.getAttribute("data-product-id");		
		action.click(viewCart);
		action.click(proceedToCheckout);
		Thread.sleep(2000);
		action.click(registerLogin);
		//SignupPage
				action.sendText(usernameFiled, randomUsername);
				action.sendText(emailFiled, randomEmail);
				action.click(signupButton);
				Thread.sleep(2000);
				//ENTER ACCOUNT INFORMATION
				action.click(femaleGender);
				action.scrollByVisibilityOfElement(driver, newsletterCheckbox);
				action.sendText(password, "1234");
				action.selectByValue(days, "18");
				action.selectByValue(months, "11");
				action.selectByValue(years, "1995");	
				action.click(optinCheckbox);
				action.click(newsletterCheckbox);
				//ADDRESS INFORMATION
				action.scrollByVisibilityOfElement(driver, company);
				action.sendText(firstName, prop.getProperty("firstname"));
				action.sendText(lastName, prop.getProperty("lastname"));
				action.sendText(company, "Automation");
				action.sendText(address1,"Amman,Jordan" );
				action.selectByValue(country, "Australia");
				action.sendText(state, "Amman");
				action.sendText(city, "Amman");
				action.sendText(zipCode, "0000");
				action.scrollByVisibilityOfElement(driver, mobileNumber);
				action.sendText(mobileNumber, "0791234");
				Thread.sleep(3000);
				action.click(createAccountButton);
				Thread.sleep(2000);
			//	action.implicitWait(driver, 10000);
				action.click(continueButton);
				String expectedResult = randomUsername;
				String actualResult1 = loggedInAs.getText();
				Thread.sleep(2000);
				softAssert.assertEquals(actualResult1, expectedResult);
				softAssert.assertAll();
				System.out.println("Verify You Logged In Successfully");
				action.click(cartTab);
				action.click(proceedToCheckout);
				Thread.sleep(2000);
				boolean actualResult;
				Thread.sleep(2000);
				for(int i = 0 ; i<cartList.size();i++) {
					String item = cartList.get(i).getAttribute("id");
					if(item.contains(strNumber)) {
						actualResult = true;
						softAssert.assertTrue(actualResult);
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
				actualResult = action.findElement(alert1);
				softAssert.assertTrue(actualResult);
				softAssert.assertAll();
				System.out.println("Verify Your order has been placed successfully");
				Thread.sleep(3000);
				action.click(deleteAccount);
				action.implicitWait(driver, 3000);
				actualResult = action.findElement(deleteAccountConfirmation);
				softAssert.assertTrue(actualResult);
				softAssert.assertAll();
				System.out.println("Verify account has been deleted successfully");
				action.click(continueButton);

		
	}
	

}
