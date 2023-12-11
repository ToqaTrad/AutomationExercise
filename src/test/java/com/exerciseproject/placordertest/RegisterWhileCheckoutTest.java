package com.exerciseproject.placordertest;

import java.time.Duration;

import org.testng.annotations.Test;

import com.exerciseproject.base.BaseTest;
import com.exerciseproject.placeorderpage.RegisterWhileCheckout;

public class RegisterWhileCheckoutTest extends BaseTest{
	private RegisterWhileCheckout registerWhileCheckout;
	
	
	@Test()
	public void registerWhileCheckoutTest() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		registerWhileCheckout = new RegisterWhileCheckout();
		registerWhileCheckout.registerWhileCheckout();
	}

}
