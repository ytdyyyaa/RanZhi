package com.user.waiting;

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
	}

	@Test
	public void OpenAdd() {
		// ������죬���������ĳһ�죬���뵽������Ӵ����ҳ��
		webtest.click("xpath=.//*[@id='mainNavbar']/div/ul[2]/li[1]/a");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//span[@class='text-muted icon-plus']");
		webtest.leaveFrame();
	}

	@Test
	public void OpenAddName() {
		// ѡ����Ŀ����
		webtest.enterFrame("iframe-dashboard");
		webtest.getSelect("xpath=.//*[@id='types0']").selectByVisibleText("��Ŀ����");
		webtest.leaveFrame();
		// ���Ƶ�����������ʧ��
		// webtest.enterFrame("iframe-dashboard");
		// webtest.getSelect("xpath=.//*[@id='idvalues1_chosen']/a/div").selectByVisibleText("��
		// / �ڶ�������");
		// webtest.leaveFrame();
	}

	@Test
	public void selectfirst() {
		// ѡ�����ȼ�
		webtest.enterFrame("iframe-dashboard");
		webtest.getSelect("xpath=.//*[@id='pris0']").selectByVisibleText("���");
		webtest.leaveFrame();
	}

	@Test
	public void selectwho() {
		// ѡ��ָ�ɸ�˭
		webtest.enterFrame("iframe-dashboard");
		webtest.getSelect("xpath=.//*[@id='assignedTo0']").selectByVisibleText("����ѫ");
		webtest.leaveFrame();
	}

	@Test
	public void typedescribe() {
		// ��������
		webtest.enterFrame("iframe-dashboard");
		webtest.type("xpath=.//*[@id='descs[0]']", "����Ŀָ�ɸ�����ѫ");
		webtest.leaveFrame();
	}

	@Test
	public void selectdaiding() {
		// ѡ�������ѡ��
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=.//*[@id='switchDate0']");
		webtest.leaveFrame();
	}

	@AfterTest
	public void clicksubmit() {
		// ������水ť
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=.//*[@id='submit']");
		webtest.leaveFrame();
	}

}
