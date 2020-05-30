package com.generic.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Actions;


import com.config.BaseConfig;
import com.page.object.model.PropertyPage;
import com.util.Highlighter;
import com.util.ScreenShot;
import com.util.ExplicitWait;

public class PropertySelectionPage extends BaseLogin {

	public static void selectProperty() throws Throwable {

		getLogin();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PropertyPage propertypf = new PropertyPage(driver);

		PropertyPage pf = new PropertyPage(driver);// 2
		pf.getLocationName().sendKeys(BaseConfig.getconfig("LocationName"));
		
		ScreenShot.captureScreenShot(driver, "Search City");		
		propertypf.getSearchSubmit().click();
		
		String [] price;
		List<Integer> intPrice = new ArrayList<>();
		for(int i=0; i<propertypf.getHousePrices().size();i++) {		
			price = propertypf.getHousePrices().get(i).getText().split(" ");			
			intPrice.add(Integer.parseInt(price[0].replace("£","").replace(",","").trim()));
		}
		System.out.println("House Prices: "+intPrice);
		Collections.sort(intPrice);
		System.out.println("House Prices Sorted Asc: "+intPrice);
		Collections.reverse(intPrice);
		System.out.println("House Prices Sorted Desc: "+intPrice);
		
		
		new ExplicitWait().getExplicitWaitVisible(driver,propertypf.getHousePrices().get(4)); 
		System.out.println("Home Price is: "+propertypf.getHousePrices().get(4).getText());
		propertypf.getHousePrices().get(4).click(); 
		
	
		if(propertypf.getPropertyLogo().isDisplayed()) {
			System.out.println("Logo is present");
		} else {
			System.out.println("Logo is not present");
		}
		
		System.out.println("Agent Name is: "+propertypf.getAgentName().getText());
		System.out.println("Agent Phone#: "+propertypf.getAgentNumber().getText());
		ScreenShot.captureScreenShot(driver, "Agent Info");
		
		
		Actions signOut = new Actions(driver);
		signOut.moveToElement(propertypf.getMyZooplaBtn()).build().perform();
		Highlighter.getcolor(driver,propertypf.getMyZooplaBtn(),"red");
		signOut.moveToElement(propertypf.getSignOutBtn()).build().perform();
		Highlighter.getcolor(driver, propertypf.getSignOutBtn(), "yellow");
		ScreenShot.captureScreenShot(driver, "Sign Out");
		propertypf.getSignOutBtn().click();
		
		driver.quit();
		
		
		
	}

}
