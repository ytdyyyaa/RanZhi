package com.user.waiting;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.user.loginModules.Login_Action;
import com.webtest.core.BaseTest;

public class WaitingtoWork extends BaseTest {
	Login_Action login = null;

	@BeforeClass
	public void startUp() {
		login = new Login_Action(webtest);
		login.loginByFront("dyc1", "123456");
	}
	
	@Test
	public void OpenAdd(){
		webtest.click("xpath=.//*[@id='mainNavbar']/div/ul[2]/li[1]/a");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=.//[@id='zui.calendar']/div[3]/div/table/tbody/tr[4]/td[2]/div/div[2]");
		webtest.leaveFrame();
	}
//	
//	@Test
//	public void OpenAddName(){
//		webtest.type(locator, value);
//	}

}
