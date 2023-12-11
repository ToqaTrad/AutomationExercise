package com.exerciseproject.homepagetest;

import java.time.Duration;

import org.testng.annotations.Test;

import com.exerciseproject.base.BaseTest;
import com.exerciseproject.homepage.CartPage;

public class CartTest extends BaseTest{
	
	private CartPage cartPage;
	
	@Test()
	public void cartSubscrptionTest() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		cartPage = new CartPage();
		cartPage.cartSubscrption();
	}

}
