package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Basics {

	public void launch() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.snapdeal.com");
		System.out.println("Successfully opened sd");
		Thread.sleep(10);
		driver.quit();
	}

	// .........................................................................................................//
	public void Launchcrome() {
		// String exePath =
		// "C:\\Users\\apathak\\Downloads\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\apathak\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in");
	}

	// .....................................................................................................//
	public void launchIe() {
		System.setProperty("webdriver.ie.driver",
				"C:\\Users\\apathak\\Downloads\\IEDriverServer_x64_2.53.1\\IEDriverServer.exe");
		InternetExplorerDriver driver = new InternetExplorerDriver();
		driver.get("http://yahoo.com");
	}

	// ........................................................................................................//
	public void Signup() {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://github.com");
		driver.findElement(By.name("user[login]")).sendKeys("anujpathak");
		driver.findElement(By.xpath(".//*[@id='user[email]']")).sendKeys(
				"anujpathak999@gmail.com");
		driver.findElement(By.xpath(".//*[@id='user[password]']")).sendKeys(
				"*AbCdEf123#");
	}

	// .....................................................................................................//

	public void dropdown() {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.facebook.com");

		WebElement dropdown = driver.findElement(By.xpath(".//*[@id='day']"));
		Select oSelect = new Select(dropdown);
		oSelect.selectByVisibleText("19");

		WebElement dropdown2 = driver
				.findElement(By.xpath(".//*[@id='month']"));
		Select oSel = new Select(dropdown2);
		oSel.selectByIndex(9);

		Select Select = new Select(driver.findElement(By.id("year")));
		Select.selectByValue("1993");

	}

	// ..............................................................................................................//

	public void mousehover() {

		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.snapdeal.com");
		WebElement element = driver
				.findElement(By
						.xpath(".//*[@id='leftNavMenuRevamp']/div[1]/div[2]/ul/li[2]/a/span[2]"));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		WebElement subElement = driver.findElement(By
				.xpath(".//*[@id='category2Data']/div[1]/div/div/p[8]/a/span"));
		action.moveToElement(subElement);
		action.click();
		action.perform();
		// dropdownBY part bellow
		WebElement dragElementFrom = driver
				.findElement(By
						.xpath(".//*[@id='content_wrapper']/div[9]/div[1]/div/div[1]/div[2]/div[3]/div[3]/div/div[1]/a[1]"));
		System.out.println(dragElementFrom.getLocation());
		new Actions(driver).dragAndDropBy(dragElementFrom, -90, 0).build()
				.perform();
		System.out.println(dragElementFrom.getLocation());
	}

	// ............................................................................................................//
	public void iframes() {

		WebDriver driver = new FirefoxDriver();
		driver.get("http://toolsqa.wpengine.com/iframe-practice-page/");
		// List<WebElement>iframeElements=driver.findElements(By.tagName("iframe1"));
		driver.switchTo().frame(driver.findElement(By.id("IF1")));
		driver.findElement(By.xpath(".//*[@id='sex-0']")).click();

		driver.switchTo().defaultContent();

		driver.switchTo().frame(driver.findElement(By.id("IF2")));
		/*
		 * driver.findElement(By.id("IF2")); driver.switchTo().frame(2);
		 */
		driver.findElement(
				By.xpath(".//*[@id='post-9']/div/div[1]/div/p[1]/a/img"))
				.click();
		driver.switchTo().frame(2);

	}

	public static void main(String[] args) {
		Basics obj = new Basics();
		// obj.launch();
		// obj.Launchcrome();
		// obj.Signup();
		// obj.launchIe();
		// obj.dropdown();
		// obj.mousehover();Fobj.iframes();
	}
}
