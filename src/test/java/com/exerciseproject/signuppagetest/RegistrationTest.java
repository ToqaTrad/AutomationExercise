package com.exerciseproject.signuppagetest;

import org.testng.annotations.Test;
import java.time.Duration;
import com.exerciseproject.base.BaseTest;
import com.exerciseproject.signuppage.RegistrationPage;

public class RegistrationTest extends BaseTest {
	RegistrationPage registrationPage;

	@Test()
	public void RegisterWithValidDataTest() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		registrationPage = new RegistrationPage();
		registrationPage.registrationWithValidData();
	}

	@Test()
	public void RegistrationWithExistingEmail() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		registrationPage = new RegistrationPage();
		registrationPage.registrationWithExistingEmail();
	}

}
