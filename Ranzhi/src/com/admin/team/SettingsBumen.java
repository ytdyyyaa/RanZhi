package com.admin.team;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.user.loginModules.Login_Action;
import com.webtest.core.BaseTest;

import Data.Children;

public class SettingsBumen extends BaseTest {
	Login_Action login = null;

	@BeforeClass
	public void startUp() {
		login = new Login_Action(webtest);
		login.loginByFront("admin", "123456");
		assertTrue(webtest.getHtmlSource().contains("签退"));
	}

	@Test(priority = 0)
	public void before() {
		// 点击团队，进入团队页面
		webtest.click("xpath=.//*[@id='s-menu-6']/button");
		assertTrue(webtest.getHtmlSource().contains("最新帖子"));
		// 点击设置按钮
		webtest.enterFrame("iframe-6");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[6]/a");
		assertTrue(webtest.getHtmlSource().contains("论坛版块"));
		webtest.leaveFrame();
		// 点击维护部门，进入到编辑部门信息页面
		webtest.enterFrame("iframe-6");
		webtest.click("link=维护部门");
		webtest.leaveFrame();
	}

	@Test(priority = 1,dependsOnMethods="before")
	public void clickteambutton() {
		// 编辑销售部
		webtest.enterFrame("iframe-6");
		webtest.click("xpath=.//*[@id='treeMenuBox']/ul/li[2]/a[1]");
		webtest.click("xpath=.//*[@id='parent_chosen']/a/div");
		webtest.click("xpath=.//*[@id='parent_chosen']/div/ul/li[9]");
		webtest.click("xpath=.//*[@id='moderators_chosen']/a/div");
		webtest.click("xpath=.//*[@id='moderators_chosen']/div/ul/li[4]");
		webtest.click("xpath=.//*[@id='submit']");
		webtest.leaveFrame();
	}

	@Test(priority = 2, dataProvider = "children", dataProviderClass = Children.class,dependsOnMethods="before")
	public void ZiBumen(String children1, String children2, String children3, String children4) {
		// 使用数据驱动添加子部门
		webtest.enterFrame("iframe-6");
		webtest.click("xpath=.//*[@id='treeMenuBox']/ul/li[2]/a[2]");
		webtest.type("name=children[1]", children1);
		webtest.type("name=children[2]", children2);
		webtest.type("name=children[3]", children3);
		webtest.type("name=children[4]", children4);
		webtest.click("xpath=.//*[@id='submit']");
		webtest.leaveFrame();
	}

	@Test(priority = 3,dependsOnMethods="before")
	public void DeleteBumen() {
		// 删除技术部下第一个子部门
		webtest.enterFrame("iframe-6");
		webtest.click("xpath=.//*[@id='treeMenuBox']/ul/li[1]/ul/li[1]/a[3]");
		assertEquals(webtest.getAlertTest(), "您确定要执行删除操作吗？");
		webtest.alertAccept();
		webtest.leaveFrame();
	}
	
	@Test(priority = 4,dependsOnMethods="before")
	public void AddBumen() {
		// 添加部门
		webtest.enterFrame("iframe-6");
		webtest.type("name=children[42]", "广告部");
		webtest.click("xpath=.//*[@id='submit']");
		webtest.leaveFrame();
	}

}
