package com.w2a.testcases;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class HomePage extends TestBase{
	
	
	@Test
	public void verifyDepartmentsMenu() throws InterruptedException{
		
		WebElement deptElement = driver.findElement(By.xpath(OR.getProperty("navDepartments")));
		
		Actions action = new Actions(driver);
		
		action.moveToElement(deptElement).build().perform();
		
		Thread.sleep(2000);
		
		List <WebElement> depts = driver.findElements(By.xpath(OR.getProperty("alldepts")));
		
	//	Iterator<WebElement> itr = depts.iterator();
		
				
		/*
		Prime Video
		Amazon Music
		Appstore for Android
		Echo & Alexa
		Fire Tablets
		Fire TV
		Kindle E-readers & Books
		Books & Audible
		Movies, Music & Games
		Electronics, Computers & Office
		Home, Garden, Pets & Tools
		Food & Grocery
		Beauty & Health
		Toys, Kids & Baby
		Clothing, Shoes & Jewelry
		Handmade
		Sports & Outdoors
		Automotive & Industrial
		Home Services
		Credit & Payment Products*/

		if(depts.get(0).getText().contains("Prime Video")){
		    	log.info("Department Prime Video is displayed");	 
		    			    	
		    }else{
		    	log.info("Prime video is Not displayed");
		}
		    
		if(depts.get(1).getText().contains("Amazon Music")){
			log.info("Department Amazon Music is displayed");
		}else {
			log.info("Department Amazon Music is Not displayed");
		}
		    
		 if(depts.get(2).getText().contains("Appstore for Android")){
			 
			 log.info("Department Appstore for Android is dispalyed");
		 }else {
		    	
			 log.info("Department Appstore for Android is Not displayed");
		 }
		    
		 if(depts.get(3).getText().contains("Echo & Alexa")){
			 
			 log.info("Department Echo & Alexa is displayed");
		 }else {
			 log.info("Department Echo & Alexa is Not displayed");
		 }
		    
		
		/*while(itr.hasNext()){
			WebElement deptprimevideo = itr.next();
			
		}*/
		WebElement deptprimevideo = depts.get(0);	
		action.moveToElement(deptprimevideo).build().perform();
		
		List <WebElement> navs = driver.findElements(By.cssSelector(OR.getProperty("navheader")));
		
		log.info("The size of the first column Headers is " + navs.size());
		
		Iterator <WebElement> allnavs = navs.iterator();
		
		log.info("The Headers Under Prime video are  displayed ");
		while(allnavs.hasNext()){		
			
			log.info(allnavs.next().getText());
		}
		
	   List <WebElement> navs2=driver.findElements(By.cssSelector(OR.getProperty("navheaderprimevideosecondcolumn")));
	   
	   Iterator <WebElement> allnavs2 = navs2.iterator();
	   log.info("The Headers Under More To Explore are displayed");
	   while(allnavs2.hasNext()){
		   
		   log.info(allnavs2.next().getText());
	   }
	 //  Assert.assertTrue(condition, message);
	 
			
	}

}
