package com.seleniumdemo.test.login;

import com.seleniumdemo.test.common.AppCommon;

public class FlipkartLoginCommon extends AppCommon{

	public void loginToFlipkart(String userName, String password) {
		popupHandle();
		click(FlipkartLoginLocator.loginLink);
		typeText(FlipkartLoginLocator.emailField, userName);
		typeText(FlipkartLoginLocator.passwordField, password);
		pause(2000);
		mouseMove();
		click(FlipkartLoginLocator.loginButton);
	}
	
	public String getInvalidLoginMessage() {
		return getText(FlipkartLoginLocator.invalidLoginMsg);
	}
}
