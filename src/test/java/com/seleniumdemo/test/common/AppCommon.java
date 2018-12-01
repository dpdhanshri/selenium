package com.seleniumdemo.test.common;

import com.seleniumdemo.utis.SeleniumWebDriverUtils;

public class AppCommon extends SeleniumWebDriverUtils{

	public void popupHandle() {
		click(CommonLocators.closeLoginDialog);
	}
}
