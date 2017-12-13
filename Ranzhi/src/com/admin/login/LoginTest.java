package com.admin.login;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.user.loginModules.Login_PageObject;
import com.webtest.core.BaseTest;

public class LoginTest extends BaseTest {
	Login_PageObject login = null;

	@BeforeClass
	public void startUp() {
		login = new Login_PageObject(webtest);
	}

	@Test(dependsOnMethods="LoginFail")
	public void LoginSuccess() throws InterruptedException {
		login.loginByFront("admin", "123456");
		assertTrue(webtest.getHtmlSource().contains("Ç©ÍË"));
	}

	@Test
	public void LoginFail() throws InterruptedException {
		// ÅÐ¶ÏÒ³ÃæÊÇ²»ÊÇÓÐÍË³ö
		boolean flag = webtest.isElementPresent("link=Ç©ÍË");
		if (flag) {
			webtest.click("linkText=Ç©ÍË");
		}
		login.loginByFront("admin", "123");
//		assertTrue(webtest.getHtmlSource().contains("µÇÂ¼Ê§°Ü"));
		 assertTrue(webtest.getHtmlSource().contains("µÇÂ¼³É¹¦"));

	}

	@Test(dependsOnMethods="LoginSuccess")
	public void Loginout() {
		// µÇÂ¼ºóÇ©ÍË
		webtest.click("link=Ç©ÍË");
		assertTrue(webtest.getHtmlSource().contains("ÓÃ»§Ãû"));

	}

}
