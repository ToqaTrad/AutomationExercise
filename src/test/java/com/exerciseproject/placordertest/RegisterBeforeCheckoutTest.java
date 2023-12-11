package com.exerciseproject.placordertest;

import java.time.Duration;
import org.testng.annotations.Test;
import com.exerciseproject.base.BaseTest;
import com.exerciseproject.placeorderpage.RegisterBeforeCheckout;

public class RegisterBeforeCheckoutTest extends BaseTest{
	private RegisterBeforeCheckout registerBeforeCheckout;
	
	
	@Test()
	public void registerBeforeCheckoutTest() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		registerBeforeCheckout = new RegisterBeforeCheckout();
		registerBeforeCheckout.RegistrationWithValidData();;
	}

}
