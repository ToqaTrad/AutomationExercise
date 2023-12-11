package com.exerciseproject.productstest;

import java.time.Duration;

import org.testng.annotations.Test;

import com.exerciseproject.base.BaseTest;
import com.exerciseproject.productpage.AddReviewOnProduct;

public class AddReviewOnProductTest extends BaseTest{
	private AddReviewOnProduct addReviewOnProduct;
	
	@Test()
	public void AddReviewTest() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		addReviewOnProduct = new AddReviewOnProduct();
		addReviewOnProduct.addReview();;
		
	}

}
