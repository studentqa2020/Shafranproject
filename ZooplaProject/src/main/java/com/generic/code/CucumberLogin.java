package com.generic.code;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import com.config.BaseConfig;
import com.page.object.model.LoginPage;
import com.util.ExplicitWait;
import com.util.Highlighter;
import com.util.ScreenShot;

public class CucumberLogin {
	
		
	
	//protected static WebDriver driver;
	protected static LoginPage login;
	
	public static WebDriver setup() throws Throwable {
	System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
	System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
	Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
	WebDriver driver = new ChromeDriver();//upcasting
	
	driver.manage().window().maximize();//maximum or full size
	driver.manage().deleteAllCookies();
	return driver;
		
	}

	public static void getUrl(WebDriver driver) throws Throwable {
		driver.get(BaseConfig.getconfig("URL"));
	}
	
	public static void acceptCookies(WebDriver driver) {
		login =new LoginPage(driver);
		System.out.println(driver.getTitle());
		login.getClickAllcookies().click();
	}
	
	public static void clickSignIn(WebDriver driver) {
		login.getLogin().click();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
	}
	public static void enterCredentials(WebDriver driver) throws Throwable {
		new ExplicitWait().getExplicitWait(driver, login.getEmail());
		new Highlighter().getcolor(driver, login.getEmail(), "yellow");
		login.getEmail().sendKeys(BaseConfig.getconfig("email"));
		
		new Highlighter().getcolor(driver, login.getPass(),"black");
		login.getPass().sendKeys(BaseConfig.getconfig("password"));
	}
	public static void clickLogin(WebDriver driver) {
		login.getSubmit().click();
		ScreenShot.captureScreenShot(driver, "Login success");
		System.out.println(driver.getTitle());
	}
	public static void userLogIn(WebDriver driver) {
		System.out.println(driver.getTitle());
	}
	
}

