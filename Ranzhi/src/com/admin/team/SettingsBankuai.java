package com.admin.team;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.user.loginModules.Login_Action;
import com.webtest.core.BaseTest;

import Data.SettingZiBank;
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

	@Test
	public void beforeSettingsBankuai() {
		// 点击团队，进入团队页面
		System.out.println("num1");
		webtest.click("xpath=.//*[@id='s-menu-6']/button");
		assertTrue(webtest.getHtmlSource().contains("最新帖子"));
		// 点击设置按钮
		System.out.println("num2");
		webtest.enterFrame("iframe-6");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[6]/a");
		assertTrue(webtest.getHtmlSource().contains("论坛版块"));
		// 点击论坛版块
		webtest.click("xpath=html/body/nav[2]/ul/li[1]/a");
		webtest.leaveFrame();
	}

	@Test(dataProvider = "Bankuai", dataProviderClass = Bankuai.class)
	public void AddBankuai(String bk1, String bk2, String bk3) {
		// 使用数据驱动的方式，添加论坛板块
		webtest.enterFrame("iframe-6");
		webtest.type("name=children[83]", bk1);
		webtest.type("name=children[84]", bk2);
		webtest.type("name=children[85]", bk3);
		webtest.click("xpath=.//*[@id='submit']");
		webtest.leaveFrame();
	}

	@Test
	public void BianjiZibank() {
		// 编辑子版块1
		webtest.enterFrame("iframe-6");
		webtest.click("xpath=.//*[@id='treeMenuBox']/ul/li[1]/ul/li/a[1]");
		// 选择版主
		webtest.click("xpath=.//*[@id='moderators_chosen']/ul");
		webtest.click("xpath=.//*[@id='moderators_chosen']/div/ul/li[3]");
		// 选择授权用户
		webtest.click("xpath=.//*[@id='users_chosen']/ul");
		webtest.click("xpath=.//*[@id='users_chosen']/div/ul/li[4]");
		// 选择授权分组
		webtest.click("xpath=.//*[@id='rights1']");
		webtest.click("xpath=.//*[@id='rights2']");
		webtest.click("xpath=.//*[@id='submit']");
		webtest.leaveFrame();
	}

	@Test( dataProvider = "apple", dataProviderClass = SettingZiBank.class)
	public void AddZiBank(String apple1, String apple2, String apple3) {
		webtest.enterFrame("iframe-6");
		// 添加子版块,点击子版块按钮
		webtest.click("xpath=.//*[@id='treeMenuBox']/ul/li[1]/a[2]");
		// 添加子版块
		webtest.type("name=children[40]", apple1);
		webtest.type("name=children[41]", apple2);
		webtest.type("name=children[42]", apple3);
		webtest.click("xpath=.//*[@id='submit']");
		webtest.leaveFrame();
	}

}
