package com.user.work;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.user.loginModules.Login_Action;
import com.webtest.core.BaseTest;

public class WorkingTest extends BaseTest {
	Login_Action login = null;

	@BeforeClass
	public void startUp() {
		login = new Login_Action(webtest);
		login.loginByFront("dyc1", "123456");
		assertTrue(webtest.getHtmlSource().contains("ǩ��"));
	}

	@Test
	public void clickworkbutton() {
		// �鿴�������
		webtest.click("xpath=.//*[@id='mainNavbar']/div/ul[2]/li[2]/a");
		webtest.enterFrame("iframe-dashboard");
		assertTrue(webtest.getHtmlSource().contains("���Ҵ���"));
		webtest.leaveFrame();
	}

	@Test
	public void clickbianhaobutton1() {
		// ����Ŵ�С��������˳��
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=.//*[@id='taskList']/thead/tr/th[1]/div/a");
		webtest.leaveFrame();
	}

	@Test
	public void clickbianhaobutton2() {
		// ����Ŵ�С��������˳��
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=.//*[@id='taskList']/thead/tr/th[1]/div/a");
		webtest.leaveFrame();
	}

	@Test
	public void clickPbutton1() {
		// ���������ȼ���������˳��
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=.//*[@id='taskList']/thead/tr/th[2]/div/a");
		webtest.leaveFrame();
	}

	@Test
	public void clickPbutton2() {
		// ���������ȼ���������˳��
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=.//*[@id='taskList']/thead/tr/th[2]/div/a");
		webtest.leaveFrame();
	}

	@Test
	public void clickNamebutton1() {
		// ��������������˳��
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=.//*[@id='taskList']/thead/tr/th[3]/div/a");
		webtest.leaveFrame();
	}

	@Test
	public void clickNamebutton2() {
		// ��������������˳��
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=.//*[@id='taskList']/thead/tr/th[3]/div/a");
		webtest.leaveFrame();
	}

	@Test
	public void clickQuanxbutton() {
		// ���ȫѡ��ť
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=.//*[@id='allchecker']");
		// �����ѡ��ť
		webtest.click("xpath=.//*[@id='reversechecker']");
		webtest.leaveFrame();
	}

}
