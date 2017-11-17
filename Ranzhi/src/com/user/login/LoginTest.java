package com.user.login;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.user.loginModules.Login_Action;
import com.webtest.core.BaseTest;

public class LoginTest extends BaseTest{
	
	Login_Action login = null;

	@BeforeClass
	public void startUp() {
		login = new Login_Action(webtest);
	}
	@Test
	public void LoginSuccess() {
		login.loginByFront("dyc1", "123456");
		assertTrue(webtest.getHtmlSource().contains("ǩ��"));
	}

	@Test
	public void LoginFail() {
		// �ж�ҳ���ǲ������˳�
		boolean flag = webtest.isElementPresent("link=ǩ��");
		if (flag) {
			webtest.click("linkText=ǩ��");
		}
		login.loginByFront("dyc1", "1234560");
		assertTrue(webtest.getHtmlSource().contains("��¼ʧ��"));

	}
}
