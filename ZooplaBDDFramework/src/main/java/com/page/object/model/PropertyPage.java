package com.page.object.model;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PropertyPage {
	
	public PropertyPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='search-input-location']")
	private WebElement searchlocation;

	@FindBy(xpath="//*[@id='search-submit']")
	private WebElement searchbutton;
	
	@FindBy(xpath="//*[@class='listing-results-price text-price']")
	private List<WebElement> houseprices;
	
	@FindBy(xpath="//*[@class='js-lazy-loaded']")
	private WebElement propertylogo;
	
	@FindBy(xpath="(//*[@class='ui-agent__name'])[1]")
	private WebElement agentname;
	
	//@FindBy(xpath="(//*[@href='tel:01780673972'])[1]")
	@FindBy(xpath="(//*[@class='ui-link'])[4]")
	private WebElement agentphonenumber;
	
	//@FindBy(xpath="//*[@class='ui-button-tertiary ui-button-tertiary--inverse ui-button-small js-open-flyout']")
	@FindBy(xpath="(//*[text()='My Zoopla'])[1]")
	private WebElement myzooplabtn;
	
	//@FindBy(xpath="//span[contains(text(),'Sign out')]")
	@FindBy(xpath="(//div[@content='Sign out'])[1]")
	private WebElement signoutbtn;
	
	
	public WebElement getPropertylogo() {
		return propertylogo;
	}

	public WebElement getAgentname() {
		return agentname;
	}

	public WebElement getAgentphonenumber() {
		return agentphonenumber;
	}

	public WebElement getMyzooplabtn() {
		return myzooplabtn;
	}

	public WebElement getSignoutbtn() {
		return signoutbtn;
	}

	public List<WebElement> getHouseprices() {
		return houseprices;
	}

	public WebElement getSearchbutton() {
		return searchbutton;
	}

	public WebElement getSearchlocation() {
		return searchlocation;
	}	
}