package com.exerciseproject.homepagetest;

import org.testng.annotations.Test;
import java.time.Duration;
import com.exerciseproject.base.BaseTest;
import com.exerciseproject.homepage.LoginUserPage;

public class LoginUserTest extends BaseTest{
	
	private LoginUserPage loginUserPage;

	
	@Test()
	public void LoginUserWithCorrectDataTest() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		loginUserPage = new LoginUserPage();
		loginUserPage.loginUserWithCorrectData();
	}
	
	@Test()
	public void loginUserWithIncorrectDataTest() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		loginUserPage = new LoginUserPage();
		loginUserPage.loginUserWithIncorrectData();
	} 
	@Test()
	public void logoutAccountTest() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		loginUserPage = new LoginUserPage();
		loginUserPage.logoutAccount();
	}

}
