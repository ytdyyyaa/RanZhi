package com.admin.team;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.user.loginModules.Login_Action;
import com.webtest.core.BaseTest;

public class Parterner extends BaseTest {
	Login_Action login = null;
	// Actions action = new Actions();

	@BeforeClass
	public void startUp() {
		login = new Login_Action(webtest);
		login.loginByFront("admin", "123456");
		assertTrue(webtest.getHtmlSource().contains("签退"));
	}

	@Test
	public void ChakanPartener() {
		// 点击团队，进入团队页面
		webtest.click("xpath=.//*[@id='s-menu-6']/button");
		assertTrue(webtest.getHtmlSource().contains("最新帖子"));
		// 查看团队同事
		webtest.enterFrame("iframe-6");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[4]/a");
		webtest.leaveFrame();
	}

	@Test
	public void ChakanERwm() throws InterruptedException {
		// 查看团队内某个同事的二维码
		webtest.enterFrame("iframe-6");
		webtest.mouseoverElement("xpath=html/body/div[1]/div[2]/div/div/div[2]/div[3]/div/div[1]/div[4]/a/i");
		webtest.leaveFrame();
	}

	@Test
	public void ChakanRenshi() {
		// 查看人事部门的同事
		webtest.click("xpath=.//*[@id='s-menu-6']/button");
		webtest.enterFrame("iframe-6");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[4]/a");
		webtest.click("link=人事部");
		webtest.leaveFrame();
	}

	@Test
	public void SousuoPartener() {
		// 搜索人事部内某个同事
		webtest.enterFrame("iframe-6");
		webtest.type("xpath=.//*[@id='query']", "冀晋文");
		webtest.click("xpath=.//*[@id='submit']");
		assertTrue(webtest.getHtmlSource().contains("123@qq.com"));
		webtest.leaveFrame();
	}

}
