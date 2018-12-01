package com.seleniumdemo.test.login;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.seleniumdemo.utis.SeleniumWebDriverUtils;


public class TestLoginFlipkart extends FlipkartLoginCommon{
	String URL = "https://www.flipkart.com/";
	String invalidUsername = "1234567890";
	String invalidPassword = "password12345";
	
	@BeforeClass
	public void setup() {
		SeleniumWebDriverUtils.loadBrowser("CHROME");
		SeleniumWebDriverUtils.openApplicationURL(URL);
	}
	
	@Test
	public void testInvalidLogin() {
		loginToFlipkart(invalidUsername, invalidPassword);
		Assert.assertEquals(getInvalidLoginMessage(), "Please enter valid Email ID/Mobile number");
		
	}
	
	
	@AfterMethod
	public void afterMethod() throws IOException {
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		try {
			date = df.parse(date.toString());
		} catch (ParseException e) {
		}

		
		String fileName = getClass().getSimpleName()+date.toString().replaceAll(":", "");
		SeleniumWebDriverUtils.getscreenshot(fileName);
	}
	
	@AfterClass
	public void tearDown() {
		closeBrowser();
	}
}
