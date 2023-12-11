package com.exerciseproject.signuppage;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.exerciseproject.base.BasePage;

public class RegistrationPage extends BasePage{
	
	@FindBy(xpath = "//a[@href='/login']")
	private WebElement signupTab;

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

	@FindBy(id="newsletter")
	private WebElement  newsletterCheckbox ;
	
	@FindBy(id="optin")
	private WebElement  optinCheckbox ;
	
	@FindBy(xpath="//p[normalize-space()='Email Address already exist!']")
	private WebElement  errorMessage ;
	
	
	String randomEmail = "abc"+rand.nextInt()+"@gmail.com";
	String randomUsername= "abc"+rand.nextInt();
	
	
	public void registrationWithValidData() throws InterruptedException {
		//SignupPage
		action.click(signupTab);
		action.sendText(usernameFiled, randomUsername);
		action.sendText(emailFiled, randomEmail);
		action.click(signupButton);
		Thread.sleep(2000);
		//ENTER ACCOUNT INFORMATION
		action.click(femaleGender);
		action.sendText(password, "1234");
		action.selectByValue(days, "18");
		action.selectByValue(months, "11");
		action.selectByValue(years, "1995");	
		action.click(optinCheckbox);
		action.click(newsletterCheckbox);
		//ADDRESS INFORMATION
		action.sendText(firstName, prop.getProperty("firstname"));
		action.sendText(lastName, prop.getProperty("lastname"));
		action.sendText(company, "Automation");
		action.sendText(address1,"Amman,Jordan" );
		action.selectByValue(country, "Australia");
		action.sendText(state, "Amman");
		action.sendText(city, "Amman");
		action.sendText(zipCode, "0000");
		action.sendText(mobileNumber, "0791234");
		Thread.sleep(5000);
		action.click(createAccountButton);
		Thread.sleep(3000);
	//	action.implicitWait(driver, 10000);
		action.click(continueButton);
		String expectedResult = randomUsername;
		String actualResult = loggedInAs.getText();
		Thread.sleep(3000);
		action.click(deleteAccount);
		action.implicitWait(driver, 3000);
		action.click(continueButton);
		softAssert.assertEquals(actualResult, expectedResult);
		softAssert.assertAll();

	}
	public void registrationWithExistingEmail(){
		action.click(signupTab);
		action.sendText(usernameFiled, randomUsername);
		action.sendText(emailFiled, prop.getProperty("email"));
		action.click(signupButton);
		boolean actualResult = errorMessage.isDisplayed();
		softAssert.assertTrue(actualResult);
		softAssert.assertAll();
	}
	
	public void registration() throws InterruptedException {
		//SignupPage
		action.click(signupTab);
		action.sendText(usernameFiled, randomUsername);
		action.sendText(emailFiled, randomEmail);
		action.click(signupButton);
		Thread.sleep(2000);
		//ENTER ACCOUNT INFORMATION
		action.click(femaleGender);
		action.sendText(password, "1234");
		action.selectByValue(days, "18");
		action.selectByValue(months, "11");
		action.selectByValue(years, "1995");	
		action.click(optinCheckbox);
		action.click(newsletterCheckbox);
		//ADDRESS INFORMATION
		action.sendText(firstName, prop.getProperty("firstname"));
		action.sendText(lastName, prop.getProperty("lastname"));
		action.sendText(company, "Automation");
		action.sendText(address1,prop.getProperty("address") );
		action.selectByValue(country, "Australia");
		action.sendText(state, "Amman");
		action.sendText(city, "Amman");
		action.sendText(zipCode, "0000");
		action.sendText(mobileNumber, "0791234");
		Thread.sleep(5000);
		action.click(createAccountButton);
		Thread.sleep(3000);
	//	action.implicitWait(driver, 10000);
		action.click(continueButton);
		String expectedResult = randomUsername;
		String actualResult = loggedInAs.getText();
		softAssert.assertEquals(actualResult, expectedResult);
		softAssert.assertAll();

	}
}
