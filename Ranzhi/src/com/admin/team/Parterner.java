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
		assertTrue(webtest.getHtmlSource().contains("ǩ��"));
	}

	@Test
	public void ChakanPartener() {
		// ����Ŷӣ������Ŷ�ҳ��
		webtest.click("xpath=.//*[@id='s-menu-6']/button");
		assertTrue(webtest.getHtmlSource().contains("��������"));
		// �鿴�Ŷ�ͬ��
		webtest.enterFrame("iframe-6");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[4]/a");
		webtest.leaveFrame();
	}

	@Test
	public void ChakanERwm() throws InterruptedException {
		// �鿴�Ŷ���ĳ��ͬ�µĶ�ά��
		webtest.enterFrame("iframe-6");
		webtest.mouseoverElement("xpath=html/body/div[1]/div[2]/div/div/div[2]/div[3]/div/div[1]/div[4]/a/i");
		webtest.leaveFrame();
	}

	@Test
	public void ChakanRenshi() {
		// �鿴���²��ŵ�ͬ��
		webtest.click("xpath=.//*[@id='s-menu-6']/button");
		webtest.enterFrame("iframe-6");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[4]/a");
		webtest.click("link=���²�");
		webtest.leaveFrame();
	}

	@Test
	public void SousuoPartener() {
		// �������²���ĳ��ͬ��
		webtest.enterFrame("iframe-6");
		webtest.type("xpath=.//*[@id='query']", "������");
		webtest.click("xpath=.//*[@id='submit']");
		assertTrue(webtest.getHtmlSource().contains("123@qq.com"));
		webtest.leaveFrame();
	}

}
