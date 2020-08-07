package com.baselogin;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandle {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();// upcasting
		driver.get("http://demo.guru99.com/popup.php");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();
		driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();
		driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();

		String ParentWindow = driver.getWindowHandle();//1st window or parent
		System.out.println("Parent woindow ="+driver.getWindowHandle());
		// To handle all new opened window.
		Set<String> allWindows = driver.getWindowHandles();//All windows
		
		System.out.println("Total window before loop ="+allWindows.size());
		int i=0;
		for(String each: allWindows) {
			
			System.out.println("Window number  ="+ i +" window value = "+each);
			
			if(!each.equals(ParentWindow) && i==3) {// will get only 3nd child window ==> 4th window
				
				System.out.println("Found my child window..........");
				driver.switchTo().window(each);
				System.out.println("Child Title ="+driver.getTitle());
				System.out.println("Child URL = "+driver.getCurrentUrl());
				driver.findElement(By.xpath("//*[@name='emailid']")).sendKeys("sarowerny@gmail.com");
				driver.findElement(By.xpath("//*[@name='btnLogin']")).click();
				Thread.sleep(3000);
				driver.close(); //only current window tear down
				//driver.quit();// All windows tear down
			}
	
			i++;
		}
		allWindows = driver.getWindowHandles();
		System.out.println("Total window after loop ="+allWindows.size());
		//out side of loop then move back to parent again
		driver.switchTo().window(ParentWindow);
		driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();
		driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();
		driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();
		allWindows = driver.getWindowHandles();
		System.out.println("Total window after loop and after click 3 times ="+allWindows.size());

	
	}
	
	
	
	

}
