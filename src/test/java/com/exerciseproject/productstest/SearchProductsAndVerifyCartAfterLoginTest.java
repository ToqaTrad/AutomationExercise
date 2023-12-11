package com.exerciseproject.productstest;

import java.time.Duration;

import org.testng.annotations.Test;

import com.exerciseproject.base.BaseTest;
import com.exerciseproject.productpage.SearchProductsAndVerifyCartAfterLogin;

public class SearchProductsAndVerifyCartAfterLoginTest extends BaseTest{
	private SearchProductsAndVerifyCartAfterLogin searchProductsAndVerifyCartAfterLogin;
	
	@Test()
	public void searchProductsAndVerifyCartTest() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		searchProductsAndVerifyCartAfterLogin = new SearchProductsAndVerifyCartAfterLogin();
		searchProductsAndVerifyCartAfterLogin.searchProductsAndVerifyCart();;
		
	}

}
