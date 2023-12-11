package com.exerciseproject.placordertest;

import java.time.Duration;

import org.testng.annotations.Test;

import com.exerciseproject.base.BaseTest;
import com.exerciseproject.placeorderpage.LoginBeforeCheckout;

public class LoginBeforeCheckoutTest extends BaseTest{
	private LoginBeforeCheckout loginBeforeCheckout;
	
	@Test()
	public void loginBeforeChecout() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		loginBeforeCheckout = new LoginBeforeCheckout();
		loginBeforeCheckout.loginbeforeCheckout();
		
		
	}
	

}
