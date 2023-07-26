package com.actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskListPage {

	@FindBy(xpath="//div[text()='Add New']")
	private WebElement addNewBtn;
	
	@FindBy(xpath="//div[text()='+ New Customer']")
	private WebElement newCustomerBtn;
	
	@FindBy(xpath="(//input[@placeholder='Enter Customer Name'])[2]")
	private WebElement enterCustNameTbx;
	
	@FindBy(xpath="//textarea[@placeholder='Enter Customer Description']")
	private WebElement enterCustDespTbx;
	
	@FindBy(xpath="(//div[text()='- Select Customer -'])[1]")
	private WebElement selectCustDD;
	
	@FindBy(xpath="//div[text()='Big Bang Company' and @class='itemRow cpItemRow ']")
	private WebElement bigBangCompany;
	
	@FindBy(xpath="//div[text()='Create Customer']")
	private WebElement createCustomerBtn;
	
	@FindBy(xpath="//div[@class='titleEditButtonContainer']/div[@class='title']")
	private WebElement actualCustomerFld;
	
	
	public TaskListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement getAddNewBtn() {
		return addNewBtn;
	}
	public WebElement getNewCustomerBtn() {
		return newCustomerBtn;
	}
	public WebElement getEnterCustNameTbx() {
		return enterCustNameTbx;
	}
	public WebElement getEnterCustDespTbx() {
		return enterCustDespTbx;
	}
	public WebElement getSelectCustDD() {
		return selectCustDD;
	}
	public WebElement getBigBangCompany() {
		return bigBangCompany;
	}
	public WebElement getCreateCustomerBtn() {
		return createCustomerBtn;
	}
	public WebElement getActualCustomerFld() {
		return actualCustomerFld;
	}
	
	
}
