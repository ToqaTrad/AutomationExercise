package com.exerciseproject.homepage;


import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.exerciseproject.base.BasePage;

public class ContactUsPage extends BasePage {

	@FindBy(xpath = "//a[@href='/contact_us']")
	private WebElement contactUsTab;

	@FindBy(name = "name")
	private WebElement nameFiled;

	@FindBy(name = "email")
	private WebElement emailFiled;

	@FindBy(name = "subject")
	private WebElement subjectFiled;

	@FindBy(name = "message")
	private WebElement messageFiled;

	@FindBy(name = "upload_file")
	private WebElement uploadFileButton;
	
	@FindBy(name="submit")
	private WebElement submitButton;
	

	@FindBy(css="[class='btn btn-success']")
	private WebElement homeButton;
	
	
	

	public void contactUsPage() throws InterruptedException {

		String expectedResult = "25.jpeg";
		action.click(contactUsTab);
		action.sendText(nameFiled, prop.getProperty("firstname") + " " + prop.getProperty("lastname"));
		action.sendText(emailFiled, prop.getProperty("email"));
		action.sendText(subjectFiled, "Hello");
		action.sendText(messageFiled, "Test");
		String path = System.getProperty("user.dir");
		action.sendText(uploadFileButton, path + "/UploadFile/25.jpeg");
		String actualResult = uploadFileButton.getAttribute("value").substring(12);
		System.out.println(actualResult);
		softAssert.assertEquals(actualResult, expectedResult);
		softAssert.assertAll();
		Thread.sleep(3000);
		action.click(submitButton);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		action.AlertAccept(driver);
		action.click(homeButton);
		
		

	}
}