package com.w2a;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
	
	public static WebDriver driver;
	
	@BeforeMethod
	public void setUp(){
		
        System.setProperty("webdriver.gecko.driver","C:\\Users\\Dell Laptop\\Downloads\\geckodriver-v0.19.1-win64\\geckodriver.exe");
    	
    	driver = new FirefoxDriver();
    	driver.get("http://shop.thetestingworld.com/");
	
	}
	
	@AfterMethod
	public void afterMet(){
		System.out.println("Test Executed successfully");
		
	}
	
   @Test
   public void testCase_01() throws InterruptedException {
	   
	   driver.findElement(By.name("search")).sendKeys("phone");
	   driver.findElement(By.xpath("//button[@type='button']/i")).click();
	   driver.findElement(By.xpath("//span[contains(.,'Add to Cart')]")).click();	
   }
   


   }
