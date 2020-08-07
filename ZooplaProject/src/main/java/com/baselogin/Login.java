package com.baselogin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		// Initialize browserecho
		//interface 
		WebDriver driver=new ChromeDriver();//upcasting polymorphism
		// Maximize browser
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//implicit wait ==>HTML DOM page(slow down automation)
		
		driver.get("https://www.zoopla.co.uk/");
		//driver.getTitle();
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//*[@class='ui-button-primary ui-cookie-accept-all-medium-large']")).click();
		
		driver.findElement(By.xpath("[text()='Sign in'])[1]")).click();
		driver.findElement(By.xpath("//*[@type='email']")).sendKeys("shafranshurid@gmail.com");
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys("Shafran9124730");
		driver.findElement(By.xpath("//*[@id='signin_submit']")).click();
		System.out.println(driver.getTitle());
		
		//driver.quit();
		
		
		
		
	}

}
