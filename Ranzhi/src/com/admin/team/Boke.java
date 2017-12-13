package com.admin.team;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.user.loginModules.Login_Action;
import com.webtest.core.BaseTest;

public class Boke extends BaseTest {
	Login_Action login = null;

	@BeforeClass
	public void startUp() {
		login = new Login_Action(webtest);
		login.loginByFront("admin", "123456");
		assertTrue(webtest.getHtmlSource().contains("签退"));
	}

	@Test
	public void beforeBoke() {
		// 点击团队，进入团队页面
		webtest.click("xpath=.//*[@id='s-menu-6']/button");
		assertTrue(webtest.getHtmlSource().contains("最新帖子"));
		// 点击博客按钮
		webtest.enterFrame("iframe-6");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[3]/a");
		assertTrue(webtest.getHtmlSource().contains("添加博客"));
		webtest.leaveFrame();
	}

	@Test
	public void AddBoke() {
		// 进入添加博客页面
		webtest.enterFrame("iframe-6");
		webtest.click("link=添加博客");
		// 选择类目
		webtest.click("xpath=.//*[@id='categories_chosen']/ul");
		webtest.click("xpath=.//*[@id='categories_chosen']/div/ul/li[1]");
		// 选择授权用户
		webtest.click("xpath=.//*[@id='users_chosen']/ul");
		webtest.click("xpath=.//*[@id='users_chosen']/div/ul/li[2]");
		// 选择授权分组
		webtest.click("xpath=.//*[@id='groups1']");
		// 输入标题
		webtest.type("xpath=.//*[@id='title']", "新加博客标题");
		// 输入关键字
		webtest.type("xpath=.//*[@id='keywords']", "关键字");
		// 输入内容
		webtest.tabPress();
		webtest.actionSendKeys("博客内容");
		// webtest.tabPress();
		// webtest.enter();
		webtest.click("xpath=.//*[@id='submit']");
		webtest.leaveFrame();
	}

	@Test
	public void Check() {
		// 查看饺子类目下的博客
		webtest.enterFrame("iframe-6");
		webtest.click("xpath=.//*[@id='category12']");
		webtest.leaveFrame();
	}

	@Test
	public void FindBoke() {
		// 在搜索框中输入博客名称或者关键字，搜索符合条件的博客
		webtest.enterFrame("iframe-6");
		webtest.type("xpath=.//*[@id='searchInput']", "博客");
		webtest.click("xpath=.//*[@id='searchButton']/i");
		assertFalse(webtest.getHtmlSource().contains("789456"));
		webtest.leaveFrame();
	}

}
