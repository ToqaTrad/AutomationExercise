package com.exerciseproject.productstest;

import java.time.Duration;

import org.testng.annotations.Test;

import com.exerciseproject.base.BaseTest;
import com.exerciseproject.productpage.RemoveProductsFromCart;

public class RemoveProductsFromCartTest extends BaseTest{
	private RemoveProductsFromCart removeProductsFromCart;
	
	
	@Test()
	public void removeProductsFromCartTest() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		removeProductsFromCart = new RemoveProductsFromCart();
		removeProductsFromCart.removeProductsFromCart();
		
	}

}
