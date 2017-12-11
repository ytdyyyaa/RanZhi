package com.user.loginModules;

import com.admin.PageObject.LoginPage;
import com.webtest.core.WebDriverEngine;

public class Login_PageObject {
	WebDriverEngine webtest = null;
	LoginPage login = null;

	public Login_PageObject(WebDriverEngine webtest) {
		this.webtest = webtest;
		login = new LoginPage(this.webtest.driver);
		// TODO Auto-generated constructor stub
	}

	public void loginByFront(String username, String password) {
		webtest.open("http://127.0.0.1/ranzhi/sys/user-login.html");
		login.userName.sendKeys(username);
		login.passWord.sendKeys(password);
		login.btnLogin.click();
	}

}
