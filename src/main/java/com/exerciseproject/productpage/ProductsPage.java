package com.exerciseproject.productpage;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.exerciseproject.base.BasePage;

public class ProductsPage extends BasePage{

	@FindBy(css = "[href='/products']")
	private WebElement productsTab;
	
	@FindBy(css = "[class = 'features_items']")
	private WebElement allProductsList;
	
	@FindBy(css = "[href=\'/product_details/1\']")
	private WebElement viewProductButton;
	
	@FindBy(css = "[class = 'product-information']")
	private WebElement productInformation;
	
	@FindBy(id = "search_product")
	private WebElement searchProduct;
	
	@FindBy(id = "submit_search")
	private WebElement submitSearch;
	
//	@FindBy(className = "product-image-wrapper")
//	private WebElement resultText;
	
	@FindBy(css = "[class = 'title text-center']")
	private WebElement searchedProducts;
	
	@FindBy(xpath = "//div[@class='features_items']/div")
	private List<WebElement> resultProducts;
	
	public void productsPage() {
		action.click(productsTab);
		boolean actualResult = action.findElement(allProductsList);
		softAssert.assertTrue(actualResult);
		action.click(viewProductButton);
		action.getCurrentURL(driver);
		boolean actualResult2 = action.findElement(productInformation);
		softAssert.assertTrue(actualResult2);
		softAssert.assertAll();

		
	}
	
	public void searchProduct() throws InterruptedException {
		String expectedResult = "Top";
		action.click(productsTab);
		action.getCurrentURL(driver);
		action.sendText(searchProduct, expectedResult);
		action.click(submitSearch);
		Thread.sleep(2000);
		boolean actual = action.findElement(searchedProducts);
		softAssert.assertTrue(actual);
		boolean actualResult;		
		for(WebElement product:resultProducts) {
			String item = action.getText(product);
			if(item.contains(expectedResult)) {
				actualResult = true;
				softAssert.assertTrue(actualResult);
				softAssert.assertAll();
			}
		}

	}
	
}
