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
		assertTrue(webtest.getHtmlSource().contains("ǩ��"));
	}

	@Test(priority = 0)
	public void before() {
		// ����Ŷӣ������Ŷ�ҳ��
		webtest.click("xpath=.//*[@id='s-menu-6']/button");
		assertTrue(webtest.getHtmlSource().contains("��������"));
		// ������ð�ť
		webtest.enterFrame("iframe-6");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[6]/a");
		assertTrue(webtest.getHtmlSource().contains("��̳���"));
		webtest.leaveFrame();
		// ���������Ŀ��ť
		webtest.enterFrame("iframe-6");
		webtest.click("xpath=html/body/nav[2]/ul/li[2]/a");
		assertTrue(webtest.getHtmlSource().contains("����Ŀ"));
		webtest.leaveFrame();
	}

	@Test(priority = 1, dependsOnMethods = "before")
	public void addLeimu() {
		// ��Ӳ�����Ŀ
		webtest.enterFrame("iframe-6");
		webtest.type("name=children[14]", "��Ŀ14");
		webtest.type("name=children[15]", "��Ŀ15");
		webtest.type("name=children[16]", "��Ŀ16");
		webtest.type("name=children[17]", "��Ŀ17");
		webtest.click("xpath=.//*[@id='submit']");
		webtest.leaveFrame();
	}

	@Test(priority = 1, dependsOnMethods = "before")
	public void BianjiBoke() {
		// �༭�����ӡ�������Ŀ
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
	
	@Test(priority = 2, dependsOnMethods = "before")
	public void AddZileimu() {
		// ��ӡ����ӡ�������Ŀ
		webtest.enterFrame("iframe-6");
		webtest.click("xpath=.//*[@id='treeMenuBox']/ul/li[2]/a[2]");
		webtest.type("name=children[1]", "����Ŀ1");
		webtest.type("name=children[2]", "����Ŀ2");
		webtest.type("name=children[3]", "����Ŀ3");
		webtest.click("xpath=.//*[@id='submit']");
		webtest.leaveFrame();
	}

}
