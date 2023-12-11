package com.exerciseproject.productpage;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.exerciseproject.base.BasePage;

public class SearchProductsAndVerifyCartAfterLogin extends BasePage{
	@FindBy(css = "[href='/products']")
	private WebElement productsTab;
	
	@FindBy(css="[class='title text-center']")
	private WebElement title;
	
	
	@FindBy(id = "search_product")
	private WebElement searchProduct;
	
	@FindBy(id = "submit_search")
	private WebElement submitSearch;
	
	
	@FindBy(xpath = "//div[@class='features_items']/div[@class='col-sm-4']")
	private List<WebElement> resultProducts;
	
	@FindBy(xpath = "//div[@class='productinfo text-center']//a[@class='btn btn-default add-to-cart']")
	private List<WebElement> addProducts;
	
	@FindBy(css = "[class = 'btn btn-success close-modal btn-block']")
	private WebElement   continueShopping;
	
	@FindBy(xpath = "//div[@class='shop-menu pull-right']//a[@href='/view_cart']")
	private WebElement   viewCart;
	
	@FindBy(xpath = "//a[@href='/login']")
	private WebElement loginTab;
	
	@FindBy(xpath = "//input[@data-qa='login-email']")
	private WebElement emailAddressFiled;
	
	@FindBy(name = "password")
	private WebElement passwordFiled ;
	
	@FindBy(xpath = "//button[@data-qa='login-button']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//table[@id = 'cart_info_table']/tbody/tr")
	private List<WebElement>   cartList;
	
	
	public void searchProductsAndVerifyCart() throws InterruptedException {
		action.click(productsTab);
		boolean actualResult = action.findElement(title);
		softAssert.assertTrue(actualResult);
		if (actualResult) 
			System.out.println(title.getText()+" Page Is Displayed Successfully");
	
		String expectedResult = "Jeans";
		action.sendText(searchProduct, expectedResult);
		action.click(submitSearch);
		Thread.sleep(2000);
		 actualResult = action.findElement(title);
		if(actualResult)
			System.out.println(title.getText()+" Page Is Displayed Successfully");

		softAssert.assertTrue(actualResult);
		Thread.sleep(2000);

		String [] newList = new String [resultProducts.size()];

		for(int i = 0;i<resultProducts.size();i++) {
			String item = action.getText(resultProducts.get(i));

			if(item.contains(expectedResult)) {
				newList[i]=action.getText(resultProducts.get(i));
				actualResult = true;
				action.scrollByVisibilityOfElement(driver, addProducts.get(i));
				action.click(addProducts.get(i));
				Thread.sleep(2000);
				action.click(continueShopping);			
				System.out.println("Product Related To Search Is Visible Successfully");
				softAssert.assertTrue(actualResult);

			}
		}
		
		Thread.sleep(2000);
		action.click(viewCart);
		
		for(int i = 0;i<cartList.size();i++) {
			String item = action.getText(cartList.get(i)).substring(0, 18);
			if(newList[i].contains(item)) {
				newList[i]=action.getText(cartList.get(i));
				actualResult = true;
				System.out.println("Added Product Is Visible In Cart Successfully");
				softAssert.assertTrue(actualResult);

			}
			
		}
		
		action.click(loginTab);
		action.sendText(emailAddressFiled, prop.getProperty("email"));
		action.sendText(passwordFiled, prop.getProperty("password"));
		action.click(loginButton);
		action.click(viewCart);
		for(int i = 0;i<cartList.size();i++) {
			String item = action.getText(cartList.get(i)).substring(0, 18);
			if(newList[i].contains(item)) {
				actualResult = true;
				System.out.println("Added Products Is Visible In Cart After Login Successfully");
				softAssert.assertTrue(actualResult);
				softAssert.assertAll();
				}
			}
		}
	}
