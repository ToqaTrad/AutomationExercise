package com.exerciseproject.homepagetest;

import java.time.Duration;

import org.testng.annotations.Test;

import com.exerciseproject.base.BaseTest;
import com.exerciseproject.homepage.ContactUsPage;

public class ContactUsTest extends BaseTest{
	
	private ContactUsPage contactUsPage;
	
	@Test()
	public void contactUsTest() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 contactUsPage = new ContactUsPage();
		 contactUsPage.contactUsPage();

	}

}
