package com.admin.team;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.user.loginModules.Login_Action;
import com.webtest.core.BaseTest;

import Data.Children;

public class SettingsBoke extends BaseTest {
	Login_Action login = null;

	@BeforeClass
	public void startUp() {
		login = new Login_Action(webtest);
		login.loginByFront("admin", "123456");
		assertTrue(webtest.getHtmlSource().contains("签退"));
	}

	@Test(priority = 0)
	public void clickteambutton() {
		// 点击团队，进入团队页面
		System.out.println("num1");
		webtest.click("xpath=.//*[@id='s-menu-6']/button");
		assertTrue(webtest.getHtmlSource().contains("最新帖子"));
	}

	@Test(priority = 1)
	public void clicksettingbutton() {
		// 点击设置按钮
		System.out.println("num2");
		webtest.enterFrame("iframe-6");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[6]/a");
		assertTrue(webtest.getHtmlSource().contains("论坛版块"));
		webtest.leaveFrame();
	}
	
	@Test(priority = 2)
	public void ClickBoke() {
		// 点击博客类目按钮
		System.out.println("num3");
		webtest.enterFrame("iframe-6");
		webtest.click("xpath=html/body/nav[2]/ul/li[2]/a");
		assertTrue(webtest.getHtmlSource().contains("子类目"));
		webtest.leaveFrame();
	}
	
	@Test(priority = 3)
	public void BianjiBoke(){
		//编辑博客类目
		System.out.println("num4");
		webtest.enterFrame("iframe-6");
		webtest.click("xpath=.//*[@id='treeMenuBox']/ul/li[1]/a[1]");
		webtest.click("xpath=.//*[@id='parent_chosen']/a/div");
		webtest.click("xpath=.//*[@id='parent_chosen']/div/ul/li[2]");
		//博客类目描述输入不进去
//		webtest.tabPress();
//		webtest.tabPress();
//		webtest.type("tag=html", "博客类目的描述");
		webtest.click("xpath=.//*[@id='users_chosen']/ul");
		webtest.click("xpath=.//*[@id='users_chosen']/div/ul/li[2]");
		webtest.click("xpath=.//*[@id='rights1']");
		webtest.click("xpath=.//*[@id='rights3']");
		webtest.click("xpath=.//*[@id='rights10']");
		webtest.click("xpath=.//*[@id='submit']");
		webtest.leaveFrame();
	}

}
