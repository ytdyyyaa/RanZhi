package com.admin.team;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.user.loginModules.Login_Action;
import com.webtest.core.BaseTest;

import Data.Bankuai;
import Data.Children;

public class SettingsBankuai extends BaseTest {
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

	 @Test(dataProvider = "Bankuai", priority = 2, dataProviderClass =
	 Bankuai.class)
	 public void dataAddBankuai(String bk1, String bk2, String bk3) {
	 // 使用数据驱动的方式，添加板块
	 webtest.enterFrame("iframe-6");
	 webtest.type("name=children[38]", bk1);
	 webtest.type("name=children[39]", bk2);
	 webtest.type("name=children[40]", bk3);
	 webtest.click("xpath=.//*[@id='submit']");
	 webtest.leaveFrame();
	
	 }

	// @Test( priority = 2)
	// public void dataAddBankuai() {
	// //不使用数据驱动的方式，添加板块
	// webtest.enterFrame("iframe-6");
	// webtest.type("name=children[38]", "bk1");
	// webtest.type("name=children[39]", "bk2");
	// webtest.type("name=children[40]", "bk3");
	// webtest.leaveFrame();
	// }

}
