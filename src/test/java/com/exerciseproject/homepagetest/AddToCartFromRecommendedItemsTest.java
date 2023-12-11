package com.exerciseproject.homepagetest;

import java.time.Duration;

import org.testng.annotations.Test;

import com.exerciseproject.base.BaseTest;
import com.exerciseproject.homepage.AddToCartFromRecommendedItems;

public class AddToCartFromRecommendedItemsTest extends BaseTest{
	private AddToCartFromRecommendedItems addToCartFromRecommendedItems;
	
	@Test()
	public void addRecommendedItemsTest() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		addToCartFromRecommendedItems = new AddToCartFromRecommendedItems();
		addToCartFromRecommendedItems.addRecommendedItems();;
	}

}
