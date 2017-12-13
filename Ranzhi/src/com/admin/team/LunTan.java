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
		assertTrue(webtest.getHtmlSource().contains("ǩ��"));
	}

	@Test
	public void beforeLunTan() {
		// �鿴��̳�ڰ��
		// ����Ŷӣ������Ŷ�ҳ��
		webtest.click("xpath=.//*[@id='s-menu-6']/button");
		assertTrue(webtest.getHtmlSource().contains("��������"));
		// �����̳��ť,������̳��ҳ
		webtest.enterFrame("iframe-6");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[2]/a");
		webtest.leaveFrame();
	}

	@Test
	public void ChaKanTiezi() {
		// �鿴��̳������
		webtest.enterFrame("iframe-6");
		webtest.click("link=�Ӱ��1");
		webtest.click("xpath=html/body/div[1]/div/div[2]/div/table/tbody/tr[1]/td[2]/a");
		webtest.leaveFrame();
	}

	@Test
	public void BianJiTZ() {
		// �༭��̳����������
		webtest.enterFrame("iframe-6");
		webtest.click("xpath=html/body/div[1]/div/div[2]/div[1]/div[3]/div/a[3]");
		// �޸ı���
		webtest.type("xpath=.//*[@id='title']", "�±༭��ı���");
		// �޸�����
		webtest.tabPress();
		webtest.tabPress();
		webtest.actionSendKeys("�±༭�������");
		// ��Ӹ���
		webtest.type("xpath=.//*[@id='fileBox1']/tbody/tr/td[1]/div/input", "C:\\Users\\lenovo\\Desktop\\photo\\2.jpg");
		webtest.type("xpath=.//*[@id='fileBox1']/tbody/tr/td[2]/input", "���һ��ͼƬ��Ϊ����");
		webtest.click("xpath=.//*[@id='submit']");
		webtest.leaveFrame();
	}

	@Test
	public void HuiTie() {
		// ����
		webtest.enterFrame("iframe-6");
		webtest.click("xpath=html/body/div[1]/div/div[2]/div[1]/div[3]/div/a[4]");
		webtest.tabPress();
		webtest.actionSendKeys("�ظ����ӵ�����");
		webtest.click("xpath=.//*[@id='submit']");
		webtest.leaveFrame();
	}

	@Test
	public void BanKuaiZhiDing() {
		// ���ð��ȫ���ö�
		webtest.enterFrame("iframe-6");
		webtest.click("xpath=html/body/div[1]/div/div[2]/div[1]/div[3]/div/span/a");
		webtest.click("xpath=html/body/div[1]/div/div[2]/div[1]/div[3]/div/span/ul/li[3]/a");
		webtest.leaveFrame();
	}

	@Test
	public void DeleteHuiTie() {
		// ɾ������
		webtest.enterFrame("iframe-6");
		webtest.click("xpath=.//*[@class='col-md-10']/div[3]/div[3]/div/a[1]");
		webtest.alertAccept();
		webtest.leaveFrame();
	}

}
