package com.admin.team;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.user.loginModules.Login_Action;
import com.webtest.core.BaseTest;

public class SettingsRole extends BaseTest {
	Login_Action login = null;

	@BeforeClass
	public void startUp() {
		login = new Login_Action(webtest);
		login.loginByFront("admin", "123456");
		// assertTrue(webtest.getHtmlSource().contains("ǩ��"));
	}

	@Test(priority = 0)
	public void before() throws InterruptedException {
		// ����Ŷӣ������Ŷ�ҳ��
		webtest.click("xpath=.//*[@id='s-menu-6']/button");
		Thread.sleep(4000);
		assertTrue(webtest.getHtmlSource().contains("��������"));
		// ������ð�ť
		webtest.enterFrame("iframe-6");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[6]/a");
		assertTrue(webtest.getHtmlSource().contains("��̳���"));
		webtest.leaveFrame();
		// ���ά����ɫ
		webtest.enterFrame("iframe-6");
		webtest.click("link=ά����ɫ");
		webtest.leaveFrame();
	}

	@Test(priority = 1, dependsOnMethods = "before")
	public void addRole() throws InterruptedException {
		webtest.enterFrame("iframe-6");
		webtest.click("xpath=.//*[@id='ajaxForm']/div/table/tbody/tr[2]/td[3]/a");
		webtest.type("xpath=.//*[@id='ajaxForm']/div/table/tbody/tr[3]/td[1]/input[1]", "BL1");
		webtest.type("xpath=.//*[@id='ajaxForm']/div/table/tbody/tr[3]/td[2]/div/input", "aaaa");
		Thread.sleep(4000);
		webtest.click("xpath=.//*[@id='submit']");
		webtest.leaveFrame();
	}

	@Test(priority = 2, dependsOnMethods = "before")
	public void changeRole() {
		webtest.enterFrame("iframe-6");
		webtest.type("xpath=.//*[@id='values[]']", "�з�yanfa");
		webtest.click("xpath=.//*[@id='submit']");
		webtest.leaveFrame();
	}

}
