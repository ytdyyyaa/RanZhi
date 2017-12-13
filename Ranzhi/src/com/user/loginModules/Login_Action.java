package com.user.loginModules;

import com.admin.PageObject.LoginPage;
import com.webtest.core.WebDriverEngine;

public class Login_Action {
	WebDriverEngine webtest = null;
	LoginPage login = null;

	public Login_Action(WebDriverEngine webtest) {
		this.webtest = webtest;

	}

	public void loginByFront(String username, String password) {
		webtest.open("http://127.0.0.1/ranzhi/sys/user-login.html");
		webtest.type("name=account", "admin");
		webtest.type("name=password", "123456");
		webtest.click("xpath=.//*[@id='submit']");
	}
}
