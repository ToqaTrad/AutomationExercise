package com.exerciseproject.homepagetest;

import java.time.Duration;
import org.testng.annotations.Test;
import com.exerciseproject.base.BaseTest;
import com.exerciseproject.homepage.ViewCategoryProducts;

public class ViewCategoryProductsTest extends BaseTest{
	private ViewCategoryProducts viewCategoryProducts;
	
	@Test()
	public void viewCategoryTest() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		viewCategoryProducts = new ViewCategoryProducts();
		viewCategoryProducts.viewCategory();
	}

}
