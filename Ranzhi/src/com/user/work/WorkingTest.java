package com.user.work;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.user.loginModules.Login_Action;
import com.webtest.core.BaseTest;

public class WorkingTest extends BaseTest {
	Login_Action login = null;

	@BeforeClass
	public void startUp() {
		login = new Login_Action(webtest);
		login.loginByFront("dyc1", "123456");
	}

	@Test(priority = 0)
	public void clickworkbutton() {
		// 查看任务界面
		webtest.click("xpath=.//*[@id='mainNavbar']/div/ul[2]/li[2]/a");
		webtest.enterFrame("iframe-dashboard");
		assertTrue(webtest.getHtmlSource().contains("由我创建"));
		webtest.leaveFrame();
	}

	@Test(priority = 1)
	public void clickbianhaobutton1() {
		// 按编号大小排列任务顺序
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=.//*[@id='taskList']/thead/tr/th[1]/div/a");
		webtest.leaveFrame();
	}

	@Test(priority = 2)
	public void clickbianhaobutton2() {
		// 按编号大小排列任务顺序
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=.//*[@id='taskList']/thead/tr/th[1]/div/a");
		webtest.leaveFrame();
	}

	@Test(priority = 3)
	public void clickPbutton1() {
		// 按任务优先级排列任务顺序
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=.//*[@id='taskList']/thead/tr/th[2]/div/a");
		webtest.leaveFrame();
	}

	@Test(priority = 4)
	public void clickPbutton2() {
		// 按任务优先级排列任务顺序
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=.//*[@id='taskList']/thead/tr/th[2]/div/a");
		webtest.leaveFrame();
	}

	@Test(priority = 5)
	public void clickNamebutton1() {
		// 按名称排列任务顺序
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=.//*[@id='taskList']/thead/tr/th[3]/div/a");
		webtest.leaveFrame();
	}

	@Test(priority = 6)
	public void clickNamebutton2() {
		// 按名称排列任务顺序
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=.//*[@id='taskList']/thead/tr/th[3]/div/a");
		webtest.leaveFrame();
	}

}
