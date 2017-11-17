package com.user.loginModules;



import com.webtest.core.WebDriverEngine;

public class Login_Action {
	WebDriverEngine webtest = null;

	public Login_Action(WebDriverEngine webtest) {
		this.webtest = webtest;
		// TODO Auto-generated constructor stub
	}

	public void loginByFront(String username, String password) {
		webtest.open("http://127.0.0.1/ranzhi/sys/user-login.html");
		webtest.type("name=account", username);
		webtest.type("name=password", password);
		webtest.click("xpath=.//*[@id='submit']");
	}
}
