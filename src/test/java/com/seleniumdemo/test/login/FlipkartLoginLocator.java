package com.seleniumdemo.test.login;

import org.openqa.selenium.By;

import com.seleniumdemo.test.common.CommonLocators;

public class FlipkartLoginLocator extends CommonLocators{

	public static By loginLink = By.xpath("//a[.='Login & Signup']");
	public static By emailField = By.xpath("//span[.='Enter Email/Mobile number']/../../input");
	public static By passwordField = By.xpath("//input[@type='password']");
	public static By loginButton = By.xpath("//span[.='Login']/../../button");
	public static By invalidLoginMsg = By.xpath("//div[@class='_39M2dM undefined']/span[@class='ZAtlA-']");
}
