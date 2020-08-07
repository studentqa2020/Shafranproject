package com.smoke.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTesting {
public static void main(String[] args) {
	
	 System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
//	ChromeOptions chromeOptions = new ChromeOptions();
//	chromeOptions.addArguments("--headless");
	WebDriver driver = new ChromeDriver();// upcasting
	
	driver.manage().window().maximize();//all the time
	driver.get("https://www.google.com/");
	System.out.println("Title of my current page :: "+driver.getTitle());
	System.out.println("URL of my Current Page :: "+driver.getCurrentUrl());
	
	
	driver.get("https://www.instagram.com/?hl=en");
	//implicit wait
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	System.out.println("Title of my current page :: "+driver.getTitle());
	System.out.println("URL of my Current Page :: "+driver.getCurrentUrl());

	
//	driver.manage().deleteAllCookies();
//	
	JavascriptExecutor js = (JavascriptExecutor)driver;//type casting
//
//	
//	TakesScreenshot ts = (TakesScreenshot)driver ;//type casting
//	ts.getScreenshotAs(OutputType.FILE);
//	
	WebElement email= driver.findElement(By.xpath("//*[@name=\"username\"]"));
//............	List<WebElement> email2= driver.findElements(By.xpath("//*[@id='email']"));
	
	//explicit wait ===> WebDriverEWait
	WebDriverWait obj = new WebDriverWait(driver, 30);
	obj.until(ExpectedConditions.visibilityOf(email));
	
	
	js.executeScript("arguments[0].setAttribute('style', 'background: lightgreen; border: 4px solid red;');", email);
	
	email.sendKeys("shafranshurid@gmail.com");
	
	WebElement password= driver.findElement(By.xpath("//*[@name=\"password\"]"));

	password.sendKeys("shafran9124730");
	
	WebElement loginBtn= driver.findElement(By.xpath("//*[@class='                    Igw0E     IwRSH      eGOV_         _4EzTm                                                                                                              ']"));
loginBtn.click();
	
	driver.quit();
	
	
}
	
}
