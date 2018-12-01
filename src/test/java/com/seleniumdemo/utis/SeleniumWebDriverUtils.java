package com.seleniumdemo.utis;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumWebDriverUtils {

	public static WebDriver driver;
	private static String chromeDriverProperty = "webdriver.chrome.driver";
	private static String chromeDriverPath = "C:\\Dhan-Code\\SeleniumFramework\\src\\test\\resources\\Drivers\\chromedriver.exe";
	
	private static String firefoxDriverProperty = "webdriver.gecko.driver";
	private static String firefoxDriverPath = "C:\\Dhan-Code\\SeleniumFramework\\src\\test\\resources\\Drivers\\geckodriver.exe";
	
	public static void loadBrowser(String browser) {
		if(browser.equals("CHROME")) {
			System.setProperty(chromeDriverProperty, chromeDriverPath);
			driver = new ChromeDriver();
		}else if(browser.equals("FF")){
			System.setProperty(firefoxDriverProperty, firefoxDriverPath);
			driver = new ChromeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}
	
	public static void openApplicationURL(String URL) {
		driver.get(URL);
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void click(By locator) {
		getElement(locator).click();
	}
	
	public static String getText(By locator) {
		return getElement(locator).getText();
	}
	
	public static void typeText(By locator, String text) {
		getElement(locator).sendKeys(text);
	}
	
	public static void clickByJS(By locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].click();", getElement(locator));
	}
	
	public static void closeBrowser() {
		driver.close();
		driver.quit();
	}
	
	public static void pause(int miliseconds) {
		try {
			Thread.sleep(miliseconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void mouseMove() {
		Actions act = new Actions(driver);
		act.moveByOffset(500, 700);
	}
	
	public static void getscreenshot(String fileName) throws IOException
	{
		TakesScreenshot scr = ((TakesScreenshot)driver);
		File src = scr.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Dhan-Code\\SeleniumFramework\\MyScreenShot\\"+fileName);
		FileUtils.copyFile(src, dest);
		
	}
}
