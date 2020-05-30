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
	
	
	

	@FindBy(xpath = "//*[@id='search-input-location']")
	private WebElement LocationName;

	@FindBy(xpath = "//*[@id='search-submit']") 
	private WebElement SearchSubmit;

	@FindBy(xpath = "//*[@class='listing-results-price text-price']")
	private List<WebElement> HousePrices;

	@FindBy(xpath = "// *[@class='js-lazy-loaded']")
	private WebElement PropertyLogo;
	
	@FindBy(xpath = "//*[@class='ui-agent__name']")
	private WebElement AgentName;
	
	@FindBy(xpath = "(//*[@class='ui-link'])[4]")
	private WebElement AgentNumber;
	
	@FindBy(xpath = "//*[@id='header-account-panel__signed-in-link']")
	private WebElement MyZooplaBtn;
	
	@FindBy(xpath = "//*[contains(text(),'Sign out')]")
	private WebElement SignOutBtn;
	
	public WebElement getLocationName() {
		return LocationName;
	}
	public WebElement getSearchSubmit() {
		return SearchSubmit;
	}
	
	public List<WebElement> getHousePrices() {
		return HousePrices;
	}
	
	public WebElement getPropertyLogo() {
		return PropertyLogo;
	}
	
	
	
	public WebElement getAgentName() {
		return AgentName;
	}
	public WebElement getAgentNumber() {
		return AgentNumber;
	}

	public WebElement getMyZooplaBtn() {
		return MyZooplaBtn;
	}

	public WebElement getSignOutBtn() {
		return SignOutBtn;
	}

}
