package com.exerciseproject.homepage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.exerciseproject.base.BasePage;

public class ViewCategoryProducts extends BasePage{
	
	@FindBy(xpath="//div[@class='left-sidebar']/h2")
	private WebElement category;
	
	@FindBy(css="[href='#Women']")
	private WebElement women;
	
	@FindBy(css="[href='/category_products/1']")
	private WebElement dress;
	
	@FindBy(css="[class='title text-center']")
	private WebElement title;
	
	@FindBy(css="[href='#Men']")
	private WebElement men;
	
	@FindBy(css="[href='/category_products/6']")
	private WebElement jeans;
	
	public void viewCategory() throws InterruptedException {
		boolean actualResult1 = action.findElement(category);
		softAssert.assertTrue(actualResult1);
		if (actualResult1)
			System.out.println("Categories are visible on left side bar");
		action.scrollByVisibilityOfElement(driver, women);
		action.click(women);
		Thread.sleep(2000);
		action.click(dress);
		Thread.sleep(1000);
		String expectedResult = dress.getAttribute("text").toUpperCase();
		String actualResult = action.getText(title);
		if (actualResult.contains(expectedResult)) {
			System.out.println(actualResult+" category page is displayed successfully");
			actualResult1 = true;
			}
		softAssert.assertTrue(actualResult1);
		action.scrollByVisibilityOfElement(driver, men);
		Thread.sleep(2000);
		action.click(men);
		Thread.sleep(1000);
		action.click(jeans);
		expectedResult = jeans.getAttribute("text").toUpperCase();
		actualResult = action.getText(title);
		if (actualResult.contains(expectedResult)) {
			System.out.println(actualResult+" category page is displayed successfully");
			actualResult1 = true;

				}
		softAssert.assertTrue(actualResult1);
		softAssert.assertAll();
		
	}

}
