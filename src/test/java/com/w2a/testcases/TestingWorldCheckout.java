package com.w2a.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import com.w2a.base.TestBase;

  
 public class TestingWorldCheckout extends TestBase{
	
	//Checking Assertion that if the Continue Button is present when User comes from checkout from homepage
	 
	 @Test
	 public void verifyCheckoutPage() throws InterruptedException{
		
		 		 
		driver.findElement(By.xpath("//a[contains(.,'Phones & PDAs')]")).click();
		log.debug("Phone menu clicked");
		
		Thread.sleep(2000);
		//clicking on Phone add to cart
		
		List <WebElement> list = driver.findElements(By.xpath("//span[contains(.,'Add to Cart')]"));
		
		WebElement addtocartBtnforphone = list.get(0);
		
		addtocartBtnforphone.click();
		
		log.debug("Item added to the cart");
		
		//will comment out the Thread.sleep to add webdriver wait
	//	Thread.sleep(3000);
		
	//	WebDriverWait wait = new WebDriverWait(driver, 30);
	//    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OR.getProperty("chkoutbtnhomepg"))));
		
		Wait<WebDriver> wait = new FluentWait<WebDriver> (driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5,TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class)
				.withMessage("User defined message");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("chkoutbtnhomepg"))));
		
		driver.findElement(By.xpath(OR.getProperty("chkoutbtnhomepg"))).click();	
		
		log.debug("Clicked on the Checkout cart successfully");		
	
		
		driver.findElement(By.xpath(OR.getProperty("chkoutbtn"))).click();
		
		log.debug("The Checkout page is displayed successfully");
		
		Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("continuebtn"))), "Continue  Button Not Found");
		
		log.debug("Successful run"); 
		
	}	
	 
	
	

}
