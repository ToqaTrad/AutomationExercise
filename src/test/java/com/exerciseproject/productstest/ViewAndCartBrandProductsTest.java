package com.exerciseproject.productstest;

import java.time.Duration;

import org.testng.annotations.Test;
import com.exerciseproject.base.BaseTest;
import com.exerciseproject.productpage.ViewAndCartBrandProducts;

public class ViewAndCartBrandProductsTest extends BaseTest{
	ViewAndCartBrandProducts viewAndCartBrandProducts;
	
	
	@Test()
	public void viewAndCartBrandTest() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		viewAndCartBrandProducts = new ViewAndCartBrandProducts();
		viewAndCartBrandProducts.viewAndCartBrand();;
	}

	
}
