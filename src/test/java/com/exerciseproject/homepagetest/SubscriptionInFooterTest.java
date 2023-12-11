package com.exerciseproject.homepagetest;

import java.time.Duration;

import org.testng.annotations.Test;

import com.exerciseproject.base.BaseTest;
import com.exerciseproject.homepage.SubscriptionInFooter;

public class SubscriptionInFooterTest extends BaseTest{
	
private SubscriptionInFooter subscriptionInFooter;

@Test()
public void subscriptionTest() throws InterruptedException {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	subscriptionInFooter = new SubscriptionInFooter();
	subscriptionInFooter.subscrption();
}

}
