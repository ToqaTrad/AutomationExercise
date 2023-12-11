package com.exerciseproject.homepagetest;

import java.time.Duration;

import org.testng.annotations.Test;

import com.exerciseproject.base.BaseTest;
import com.exerciseproject.homepage.TestCasesPage;

public class TestCasesTest extends BaseTest{
	
	private TestCasesPage testCasesPage;
	
	@Test()
	public void testCasesTabTest() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		testCasesPage = new TestCasesPage();
		testCasesPage.testCases();
	}

}
