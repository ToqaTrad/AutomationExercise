package com.exerciseproject.productpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.exerciseproject.base.BasePage;

public class ViewAndCartBrandProducts extends BasePage{

	@FindBy(css = "[href='/products']")
	private WebElement productsTab;
	
	@FindBy(css = "[class='brands_products']")
	private WebElement brands;
	
	@FindBy(css = "[href='/brand_products/Madame']")
	private WebElement madame;
	
	@FindBy(css="[class='title text-center']")
	private WebElement title;
	
	@FindBy(css = "[href='/brand_products/Kookie Kids']")
	private WebElement kookie;
	
	
	public void viewAndCartBrand() throws InterruptedException {
		boolean actualResult1 = action.findElement(brands);
		softAssert.assertTrue(actualResult1);
		if (actualResult1)
			System.out.println("Brands are visible on left side bar");
		Thread.sleep(2000);
		action.click(madame);
		Thread.sleep(1000);
		String 	expectedResult = action.getText(madame).substring(4).toUpperCase();
		String actualResult = action.getText(title);
		if (actualResult.contains(expectedResult)) {
			System.out.println(actualResult+" Is Displayed Successfully");
			actualResult1 = true;
			}
		softAssert.assertTrue(actualResult1);
		Thread.sleep(1000);
		action.click(kookie);
		expectedResult = action.getText(kookie).substring(4).toUpperCase();
		actualResult = action.getText(title);
		if (actualResult.contains(expectedResult)) {
			System.out.println(actualResult+" Is Displayed Successfully");
			actualResult1 = true;

				}
		softAssert.assertTrue(actualResult1);
		softAssert.assertAll();
	}
	
}
