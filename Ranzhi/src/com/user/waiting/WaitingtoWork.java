package com.user.waiting;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.user.loginModules.Login_Action;
import com.webtest.core.BaseTest;

public class WaitingtoWork extends BaseTest {
	Login_Action login = null;

	@BeforeClass
	public void startUp() {
		login = new Login_Action(webtest);
		login.loginByFront("dyc1", "123456");
		assertTrue(webtest.getHtmlSource().contains("ǩ��"));
		webtest.click("xpath=.//*[@id='mainNavbar']/div/ul[2]/li[1]/a");
	}

	@Test(priority = 0)
	public void OpenAddName() {
		// ���������ĳһ�죬���뵽������Ӵ����ҳ��
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//span[@class='text-muted icon-plus']");
		// ѡ����Ŀ����
		webtest.getSelect("xpath=.//*[@id='types0']").selectByVisibleText("��Ŀ����");
		// ѡ�����ȼ�
		webtest.getSelect("xpath=.//*[@id='pris0']").selectByVisibleText("���");
		// ѡ��ָ�ɸ�˭
		webtest.getSelect("xpath=.//*[@id='assignedTo0']").selectByVisibleText("����ѫ");
		// ��������
		webtest.type("xpath=.//*[@id='descs[0]']", "����Ŀָ�ɸ�����ѫ");
		// ѡ�������ѡ��
		webtest.click("xpath=.//*[@id='switchDate0']");
		// ������水ť
		webtest.click("xpath=.//*[@id='submit']");
		webtest.leaveFrame();
	}

	@Test(priority = 1)
	public void unfinishedWork() {
		webtest.enterFrame("iframe-dashboard");
		// ������죬���������ҳ
		webtest.click("link=����");
		// �鿴δ��ɵ�����
		webtest.click("link=��ͻ�ȡ����ϵ");
		// ����༭δ�������İ�ť
		webtest.click("link=�༭");
		// �޸����ȼ�
		webtest.selectByValue("name=pri", "3");
		// ѡ��״̬
		webtest.selectByIndex("name=status", 0);
		// ѡ����ֹʱ��
		webtest.selectByIndex("id=begin", 5);
		webtest.selectByIndex("id=end", 7);
		webtest.click("xpath=.//*[@id='submit']");
		webtest.leaveFrame();
	}

	@Test(priority = 2)
	public void all() {
		webtest.enterFrame("iframe-dashboard");
		// ������죬���������ҳ
		webtest.click("link=����");
		// �鿴���д�����Ŀ
		webtest.click("link=����");
		webtest.leaveFrame();
	}

	@Test(dependsOnMethods = "all")
	public void zhipai() {
		// ������ָ�ɸ�ĳ��
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=.//*[@id='todoList']/tbody/tr[2]/td[10]/a[3]");
		webtest.click("xpath=.//*[@id='assignedTo_chosen']/a");
		webtest.click("xpath=.//*[@id='assignedTo_chosen']/div/ul/li[3]");
		webtest.click("xpath=.//*[@id='submit']");
		webtest.leaveFrame();
	}

	@Test(priority = 3)
	public void others() {
		webtest.enterFrame("iframe-dashboard");
		// ������죬���������ҳ
		webtest.click("link=����");
		// �鿴ָ�����˴�����Ŀ
		webtest.click("link=ָ������");
		webtest.leaveFrame();
	}

	@Test(priority = 4)
	public void me() {
		webtest.enterFrame("iframe-dashboard");
		// ������죬���������ҳ
		webtest.click("link=����");
		// �鿴ָ�ɸ��Ҵ�����Ŀ
		webtest.click("link=ָ�ɸ���");
		webtest.leaveFrame();
	}

	@Test(priority = 5)
	public void unfinished() {
		webtest.enterFrame("iframe-dashboard");
		// ������죬���������ҳ
		webtest.click("link=����");
		// �鿴δ��ɴ�����Ŀ
		webtest.click("link=δ���");
		webtest.leaveFrame();
	}

	@Test(priority = 6)
	public void daiding() {
		webtest.enterFrame("iframe-dashboard");
		// ������죬���������ҳ
		webtest.click("link=����");
		// �鿴����������Ŀ
		webtest.click("link=����");
		webtest.leaveFrame();
	}

	@Test(priority = 7)
	public void changeFinish() {
		// ������״̬�޸�Ϊ���
		webtest.enterFrame("iframe-dashboard");
		// ������죬���������ҳ
		webtest.click("link=����");
		webtest.click("link=����");
		webtest.click("xpath=.//*[@id='todoList']/tbody/tr[5]/td[10]/a[2]");
		webtest.leaveFrame();
	}

	@Test(priority = 8)
	public void changeOpen() {
		// ��������ɵ�����
		webtest.enterFrame("iframe-dashboard");
		// ������죬���������ҳ
		webtest.click("link=����");
		webtest.click("link=����");
		webtest.click("xpath=.//*[@id='todoList']/tbody/tr[6]/td[10]/a[4]");
		webtest.leaveFrame();
	}

}
