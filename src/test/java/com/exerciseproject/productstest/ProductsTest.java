package com.exerciseproject.productstest;

import java.time.Duration;

import org.testng.annotations.Test;

import com.exerciseproject.base.BaseTest;
import com.exerciseproject.productpage.ProductsPage;

public class ProductsTest extends BaseTest{
	
	private ProductsPage productsPage;
	
	@Test()
	public void productsTabTest(){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		productsPage= new ProductsPage();
		productsPage.productsPage();
		
	}
	
	@Test()
	public void productsSearchTest() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		productsPage= new ProductsPage();
		productsPage.searchProduct();
		
	}

}
