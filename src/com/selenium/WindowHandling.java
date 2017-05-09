package com.selenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowHandling {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://toolsqa.wpengine.com/automation-practice-switch-windows/");
		
		WebElement clickElement = driver.findElement(By.id("button1")); 

		for(int i = 0; i < 1; i++)
		{
			clickElement.click();
			Thread.sleep(3000);
		}
		
		
		String parentWindowHandle = driver.getWindowHandle();
		System.out.println("Parent window's handle -> " + parentWindowHandle);
		
		Set<String> allWindowHandles = driver.getWindowHandles();
		//String lastWindowHandle = "";
		
		for(String handle : allWindowHandles)
		{
			System.out.println("Switching to window - > " + handle);
			//System.out.println("Navigating to google.com");
			driver.switchTo().window(handle); //Switch to the desired window first and then execute commands using driver
			driver.get("http://google.com");
			//lastWindowHandle = handle;
		}

		driver.switchTo().window(parentWindowHandle);
		System.out.println(driver.getCurrentUrl());
		
		driver.switchTo().window(parentWindowHandle);
		
		driver.close();
		
		//driver.switchTo().window(lastWindowHandle);
		//driver.get("http://toolsqa.wpengine.com");
	}
	
	}

 

	


