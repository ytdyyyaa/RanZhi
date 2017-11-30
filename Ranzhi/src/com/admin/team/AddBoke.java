package com.admin.team;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.user.loginModules.Login_Action;
import com.webtest.core.BaseTest;

public class AddBoke extends BaseTest {
	Login_Action login = null;

	@BeforeClass
	public void startUp() {
		login = new Login_Action(webtest);
		login.loginByFront("admin", "123456");
		assertTrue(webtest.getHtmlSource().contains("签退"));
	}

	@Test(priority = 0)
	public void openAddBoke() {
		//进入添加博客页面
		webtest.click("xpath=.//*[@id='s-menu-6']/button");
		webtest.enterFrame("iframe-6");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[3]/a");
		webtest.click("xpath=html/body/div[1]/div/div[1]/div[1]/a");
		webtest.leaveFrame();
	}
	@Test(priority=1)
	public void addBoke(){
		//输入添加博客的信息
		//无法进入iframe
		webtest.enterFrame("iframe-6");
		webtest.click("xpath=.//*[@id='categories_chosen']/ul");
		webtest.click("xpath=.//*[@id='categories_chosen']/div/ul/li[1]");
		webtest.click("xpath=.//*[@id='users_chosen']/ul");
		webtest.click("xpath=.//*[@id='users_chosen']/div/ul/li[4]");
		webtest.click("xpapth=.//*[@id='groups1']");
		webtest.type("xpath=.//*[@id='title']", "添加的第一条博客");
		webtest.type("xpath=.//*[@id='keywords']", "第一条");
		webtest.tabPress();
		webtest.type("tag=html", "新添加的博客的内容新添加的博客的内容新添加的博客的内容新添加的博客的内容");
		webtest.leaveFrame();
	}
}
