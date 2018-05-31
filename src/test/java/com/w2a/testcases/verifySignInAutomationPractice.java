package com.w2a.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class verifySignInAutomationPractice extends TestBase{
	
	
	@Test(dataProvider="getData")
	public void SignIn(String email,String pwd){
					 
				 
	//	driver.findElement(By.cssSelector(OR.getProperty("signinbtnhmpg"))).click();
		click("signinbtnhmpg_css");
		log.info("Clicked the Signin button");
		
	//	driver.findElement(By.cssSelector(OR.getProperty("emailBtn"))).sendKeys(email);;
		
		type("emailBtn_css",email);		
				
	//	driver.findElement(By.cssSelector(OR.getProperty("passwordBtn"))).sendKeys(pwd);
		type("passwordBtn_css",pwd);
		
	//	driver.findElement(By.xpath(OR.getProperty("signinbtn"))).click();
	     click("signinbtn_xpath");
	     
		log.info("The User " + email+ " Signed in Successfully");
		
	//	driver.findElement(By.cssSelector(OR.getProperty("signoutbtnMyAcctpage"))).click();
		
		click("signoutbtnMyAcctpage_css");
		
		click("homepglogo");
		
		Reporter.log("Test completed with success");
		
	}
	
	@DataProvider
	public Object[][] getData(){
		
		String sheetName = "verifySignInAutomationPractice";
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		
		Object[][] data = new Object[rows - 1][cols];
		
		for(int rowNum = 2; rowNum <= rows; rowNum++){
			
			for(int colNum = 0; colNum < cols ; colNum++){
					
					data[rowNum - 2 ][colNum] = excel.getCellData(sheetName, colNum, rowNum);
			}
		}
	    
		return data;	
		
		
	}	
	

}
