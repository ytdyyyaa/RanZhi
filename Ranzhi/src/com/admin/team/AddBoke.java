package com.admin.team;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.user.loginModules.Login_Action;
import com.webtest.core.BaseTest;

public class AddBoke extends BaseTest {
	Login_Action login = null;
	AddBoke add = null;

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
		// ������Ͱ�ť
		webtest.enterFrame("iframe-6");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[3]/a");
		webtest.leaveFrame();
	}

	@Test(priority = 1, dependsOnMethods = "before")
	public void openAddBoke() {
		// ������Ӳ���ҳ��
		webtest.enterFrame("iframe-6");
		webtest.click("link=��Ӳ���");
		// ѡ����Ŀ
		webtest.click("xpath=.//*[@id='categories_chosen']/ul");
		webtest.click("xpath=.//*[@id='categories_chosen']/div/ul/li[1]");
		// ѡ����Ȩ�û�
		webtest.click("xpath=.//*[@id='users_chosen']/ul");
		webtest.click("xpath=.//*[@id='users_chosen']/div/ul/li[2]");
		// ѡ����Ȩ����
		webtest.click("xpath=.//*[@id='groups1']");
		// �������
		webtest.type("xpath=.//*[@id='title']", "�¼Ӳ��ͱ���");
		// ����ؼ���
		webtest.type("xpath=.//*[@id='keywords']", "�ؼ���");
		// ��������
		webtest.tabPress();
		webtest.actionSendKeys("��������");
		webtest.tabPress();
		webtest.enter();
		webtest.leaveFrame();
	}

	@Test(priority = 2)
	public void Check() {
		// if(webtest.getHtmlSource().contains("��������")){
		// return;
		// }else{
		// before();
		// }
		// �鿴������Ŀ�µĲ���
		webtest.enterFrame("iframe-6");
		webtest.click("xpath=.//*[@id='category12']");
		webtest.leaveFrame();
	}

}
