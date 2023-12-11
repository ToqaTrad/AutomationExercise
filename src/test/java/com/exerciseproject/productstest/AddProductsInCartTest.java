package com.exerciseproject.productstest;

import java.time.Duration;

import org.testng.annotations.Test;

import com.exerciseproject.base.BaseTest;
import com.exerciseproject.productpage.AddProductsInCart;

public class AddProductsInCartTest extends BaseTest{
	
	private AddProductsInCart addProductsInCart;
	
	@Test()
	public void addToCartTest() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		addProductsInCart = new AddProductsInCart();
		addProductsInCart.addToCart();
	}
	

}
