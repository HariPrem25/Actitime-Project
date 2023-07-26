package com.actitime.testscript;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generic.BaseClass;
import com.actitime.generic.FileLib;
import com.actitime.pom.HomePage;
import com.actitime.pom.TaskListPage;

@Listeners(com.actitime.generic.ListenerImplementation.class)
public class CustomerModule extends BaseClass{

	@Test
	public void testCreateCustomer() throws InterruptedException, EncryptedDocumentException, IOException {
		
		Reporter.log("CreateCustomer",true);
		
		FileLib f=new FileLib();
		String custName = f.getExcelData("Sheet1", 1, 3);
		String custDescription = f.getExcelData("Sheet1", 1, 4);
		
		HomePage h=new HomePage(driver);
		h.setTasksTab();
		
		TaskListPage t=new TaskListPage(driver);
		Thread.sleep(2000);
		t.getAddNewBtn().click();
		Thread.sleep(2000);
		t.getNewCustomerBtn().click();
		Thread.sleep(2000);
		t.getEnterCustNameTbx().sendKeys(custName);
		Thread.sleep(2000);
		t.getEnterCustDespTbx().sendKeys(custDescription);
		Thread.sleep(2000);
		t.getSelectCustDD().click();
		Thread.sleep(2000);
		t.getBigBangCompany().click();
		Thread.sleep(2000);
		t.getCreateCustomerBtn().click();
		Thread.sleep(2000);
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		try 
		{
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();
		}
		catch(NoAlertPresentException e) {
			
		}
		
		wait.until(ExpectedConditions.textToBePresentInElement(t.getActualCustomerFld(), custName));
		
		String actualText = t.getActualCustomerFld().getText();
		
		Assert.assertEquals(actualText, custName);
	}
	
}







