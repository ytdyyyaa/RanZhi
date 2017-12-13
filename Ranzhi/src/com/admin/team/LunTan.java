package com.admin.team;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.user.loginModules.Login_Action;
import com.webtest.core.BaseTest;

public class LunTan extends BaseTest {
	Login_Action login = null;

	@BeforeClass
	public void startUp() {
		login = new Login_Action(webtest);
		login.loginByFront("admin", "123456");
		assertTrue(webtest.getHtmlSource().contains("签退"));
	}

	@Test
	public void beforeLunTan() {
		// 查看论坛内版块
		// 点击团队，进入团队页面
		webtest.click("xpath=.//*[@id='s-menu-6']/button");
		assertTrue(webtest.getHtmlSource().contains("最新帖子"));
		// 点击论坛按钮,进入论坛首页
		webtest.enterFrame("iframe-6");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[2]/a");
		webtest.leaveFrame();
	}

	@Test
	public void ChaKanTiezi() {
		// 查看论坛内帖子
		webtest.enterFrame("iframe-6");
		webtest.click("link=子版块1");
		webtest.click("xpath=html/body/div[1]/div/div[2]/div/table/tbody/tr[1]/td[2]/a");
		webtest.leaveFrame();
	}

	@Test
	public void BianJiTZ() {
		// 编辑论坛内帖子内容
		webtest.enterFrame("iframe-6");
		webtest.click("xpath=html/body/div[1]/div/div[2]/div[1]/div[3]/div/a[3]");
		// 修改标题
		webtest.type("xpath=.//*[@id='title']", "新编辑后的标题");
		// 修改内容
		webtest.tabPress();
		webtest.tabPress();
		webtest.actionSendKeys("新编辑后的内容");
		// 添加附件
		webtest.type("xpath=.//*[@id='fileBox1']/tbody/tr/td[1]/div/input", "C:\\Users\\lenovo\\Desktop\\photo\\2.jpg");
		webtest.type("xpath=.//*[@id='fileBox1']/tbody/tr/td[2]/input", "添加一张图片作为附件");
		webtest.click("xpath=.//*[@id='submit']");
		webtest.leaveFrame();
	}

	@Test
	public void HuiTie() {
		// 回帖
		webtest.enterFrame("iframe-6");
		webtest.click("xpath=html/body/div[1]/div/div[2]/div[1]/div[3]/div/a[4]");
		webtest.tabPress();
		webtest.actionSendKeys("回复帖子的内容");
		webtest.click("xpath=.//*[@id='submit']");
		webtest.leaveFrame();
	}

	@Test
	public void BanKuaiZhiDing() {
		// 设置版块全局置顶
		webtest.enterFrame("iframe-6");
		webtest.click("xpath=html/body/div[1]/div/div[2]/div[1]/div[3]/div/span/a");
		webtest.click("xpath=html/body/div[1]/div/div[2]/div[1]/div[3]/div/span/ul/li[3]/a");
		webtest.leaveFrame();
	}

	@Test
	public void DeleteHuiTie() {
		// 删除回帖
		webtest.enterFrame("iframe-6");
		webtest.click("xpath=.//*[@class='col-md-10']/div[3]/div[3]/div/a[1]");
		webtest.alertAccept();
		webtest.leaveFrame();
	}

}
