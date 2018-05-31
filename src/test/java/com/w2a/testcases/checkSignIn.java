package com.w2a.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class checkSignIn extends TestBase {
	
	@Test
	public void signInAutomationPractice(){
		
		
		log.debug("Home page is loaded");
		
		click("signinbtnhmpg_css");
		
		log.info("Clicked the Signin button");
		
		type("emailBtn_css","teacherqa6@gmail.com");		
				
		type("passwordBtn_css","wrongpassword");
		
		click("signinbtn_xpath");
		
		if(driver.findElement(By.xpath(OR.getProperty("authenticationerror"))).isDisplayed()){
			log.debug("We got the authentication error");
			Reporter.log("The User failed to Login giving authentication error");			
			Assert.fail("The authentication failed");
		}else{
		    Reporter.log("Clicking on Signout page");
		    click("signoutbtnMyAcctpage_css");
		}
		//forcefully failing the testcase
	    //Assert.fail("The login did not pass");
		
	}

}
