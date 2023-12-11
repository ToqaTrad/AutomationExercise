package com.exerciseproject.productstest;

import java.time.Duration;

import org.testng.annotations.Test;

import com.exerciseproject.base.BaseTest;
import com.exerciseproject.productpage.AddProductWithQuantity;

public class AddProductWithQuantityTest extends BaseTest{
	AddProductWithQuantity addProductWithQuantity;
	
	@Test()
	public void addProductTest() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		addProductWithQuantity = new AddProductWithQuantity();
		addProductWithQuantity.addProduct();

		
	}

}
