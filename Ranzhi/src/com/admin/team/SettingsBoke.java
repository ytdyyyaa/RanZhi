package com.admin.team;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.user.loginModules.Login_Action;
import com.webtest.core.BaseTest;

import Data.Children;
import Data.LeiMu;
import Data.SettingZiBank;

public class SettingsBoke extends BaseTest {
	Login_Action login = null;

	@BeforeClass
	public void startUp() {
		login = new Login_Action(webtest);
		login.loginByFront("admin", "123456");
		assertTrue(webtest.getHtmlSource().contains("签退"));
	}

	@Test
	public void beforeSettingsBoke() {
		// 点击团队，进入团队页面
		webtest.click("xpath=.//*[@id='s-menu-6']/button");
		assertTrue(webtest.getHtmlSource().contains("最新帖子"));
		// 点击设置按钮
		webtest.enterFrame("iframe-6");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[6]/a");
		assertTrue(webtest.getHtmlSource().contains("论坛版块"));
		webtest.leaveFrame();
		// 点击博客类目按钮
		webtest.enterFrame("iframe-6");
		webtest.click("xpath=html/body/nav[2]/ul/li[2]/a");
		assertTrue(webtest.getHtmlSource().contains("子类目"));
		webtest.leaveFrame();
	}

	@Test( dataProvider = "leimu", dataProviderClass = LeiMu.class)
	public void addLeimu(String l14,String l15,String l16,String l17) {
		// 使用数据驱动，添加博客类目
		webtest.enterFrame("iframe-6");
		webtest.type("name=children[14]", l14);
		webtest.type("name=children[15]", l15);
		webtest.type("name=children[16]", l16);
		webtest.type("name=children[17]", l17);
		webtest.click("xpath=.//*[@id='submit']");
		webtest.leaveFrame();
	}

	@Test
	public void BianjiBoke() {
		// 编辑“包子”博客类目
		webtest.enterFrame("iframe-6");
		webtest.click("xpath=.//*[@id='treeMenuBox']/ul/li[1]/a[1]");
		webtest.click("xpath=.//*[@id='parent_chosen']/a/div");
		webtest.click("xpath=.//*[@id='parent_chosen']/div/ul/li[2]");
		webtest.click("xpath=.//*[@id='users_chosen']/ul");
		webtest.click("xpath=.//*[@id='users_chosen']/div/ul/li[2]");
		webtest.click("xpath=.//*[@id='rights1']");
		webtest.click("xpath=.//*[@id='rights3']");
		webtest.click("xpath=.//*[@id='rights10']");
		webtest.click("xpath=.//*[@id='submit']");
		webtest.leaveFrame();
	}

	@Test
	public void AddZileimu() {
		// 添加“饺子”的子类目
		webtest.enterFrame("iframe-6");
		webtest.click("xpath=.//*[@id='treeMenuBox']/ul/li[2]/a[2]");
		webtest.type("name=children[1]", "子类目1");
		webtest.type("name=children[2]", "子类目2");
		webtest.type("name=children[3]", "子类目3");
		webtest.click("xpath=.//*[@id='submit']");
		webtest.leaveFrame();
	}

}
