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
		assertTrue(webtest.getHtmlSource().contains("ǩ��"));
	}

	@Test(priority = 0)
	public void clickteambutton() {
		// ����Ŷӣ������Ŷ�ҳ��
		System.out.println("num1");
		webtest.click("xpath=.//*[@id='s-menu-6']/button");
		assertTrue(webtest.getHtmlSource().contains("��������"));
	}

	@Test(priority = 1)
	public void clicksettingbutton() {
		// ������ð�ť
		System.out.println("num2");
		webtest.enterFrame("iframe-6");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[6]/a");
		assertTrue(webtest.getHtmlSource().contains("��̳���"));
		webtest.leaveFrame();
	}

	@Test(priority = 2)
	public void clickBumen() {
		// ���ά�����ţ����뵽�༭������Ϣҳ��
		System.out.println("num3");
		webtest.enterFrame("iframe-6");
		webtest.click("link=ά������");
		webtest.click("xpath=.//*[@id='treeMenuBox']/ul/li[2]/a[1]");
		webtest.leaveFrame();
	}

	@Test(priority = 3)
	public void BianjiBumen() {
		// �༭���۲�
		webtest.enterFrame("iframe-6");
		webtest.click("xpath=.//*[@id='parent_chosen']/a/div");
		webtest.click("xpath=.//*[@id='parent_chosen']/div/ul/li[9]");
		webtest.click("xpath=.//*[@id='moderators_chosen']/a/div");
		webtest.click("xpath=.//*[@id='moderators_chosen']/div/ul/li[4]");
		webtest.click("xpath=.//*[@id='submit']");
		webtest.leaveFrame();
	}

	 @Test(priority = 4)
	 public void BianjiBumen1() {
	 // �༭���۲�������
	 webtest.enterFrame("iframe-6");
	 webtest.tabPress();
	 webtest.type("xpath=html/body", "");
	 webtest.tabPress();
	 webtest.type("xpath=html/body", "���۲��Ĳ�������");
	 webtest.leaveFrame();
	 }

	@Test(priority = 5, dataProvider = "children", dataProviderClass = Children.class)
	public void ZiBumen(String children1, String children2, String children3, String children4) {
		// ����Ӳ���
		webtest.enterFrame("iframe-6");
		webtest.click("xpath=.//*[@id='treeMenuBox']/ul/li[2]/a[2]");
		webtest.type("name=children[1]", "children1");
		webtest.type("name=children[2]", "children2");
		webtest.type("name=children[3]", "children3");
		webtest.type("name=children[4]", "children4");
		webtest.click("xpath=.//*[@id='submit']");
		webtest.leaveFrame();
	}

	 @Test(priority = 6)
	 public void DeleteBumen() {
	 // ɾ���������µ�һ���Ӳ���
	 webtest.enterFrame("iframe-6");
	 webtest.click("xpath=.//*[@id='treeMenuBox']/ul/li[1]/ul/li[1]/a[3]");
	 webtest.leaveFrame();
	 webtest.getAlert();
	 assertEquals(webtest.getAlertTest(),"��ȷ��Ҫִ��ɾ��������");
	 webtest.alertAccept();
	 webtest.leaveFrame();
	 }

}
