package com.generic.code;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.config.BaseConfig;
import com.page.object.model.LoginPage;
import com.util.Highlighter;
import com.util.ScreenShot;
import com.util.ExplicitWait;

public class BaseLogin {

	
protected static WebDriver driver;
	
	public static void getLogin() throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		driver = new ChromeDriver();//upcasting
		
		driver.manage().window().maximize();//maximum or full size
		driver.manage().deleteAllCookies();
		driver.get(BaseConfig.getconfig("URL"));
		LoginPage login =new LoginPage(driver);
		System.out.println(driver.getTitle());
		login.getClickAllcookies().click();
		login.getLogin().click();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		
		new ExplicitWait().getExplicitWait(driver, login.getEmail());
		new Highlighter().getcolor(driver, login.getEmail(), "yellow");
		login.getEmail().sendKeys(BaseConfig.getconfig("email"));
		
		
		new Highlighter().getcolor(driver, login.getPass(),"black");
		login.getPass().sendKeys(BaseConfig.getconfig("password"));
		//Thread.sleep(3000);

		login.getSubmit().click();
		ScreenShot.captureScreenShot(driver, "Login success");
		System.out.println(driver.getTitle());
		
		
	}

}