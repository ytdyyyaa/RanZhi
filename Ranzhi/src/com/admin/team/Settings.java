package com.admin.team;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.user.loginModules.Login_Action;
import com.webtest.core.BaseTest;

import Data.Bankuai;

public class Settings extends BaseTest {
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
		webtest.click("xpath=.//*[@id='s-menu-6']/button");
	}

	@Test(priority = 1)
	public void clicksettingbutton() {
		// ������ð�ť
		webtest.enterFrame("iframe-6");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[6]/a");
		webtest.leaveFrame();
	}

	@Test(dataProvider = "Bankuai", priority = 2, dataProviderClass = Bankuai.class)
	public void dataAddBankuai(String bk1, String bk2, String bk3) {
		// ʹ�����������ķ�ʽ����Ӱ��
		webtest.enterFrame("iframe-6");
		webtest.type("name=children[38]", bk1);
		webtest.type("name=children[39]", bk2);
		webtest.type("name=children[40]", bk3);
		webtest.leaveFrame();

	}

	// @Test( priority = 2)
	// public void dataAddBankuai() {
	// //��ʹ�����������ķ�ʽ����Ӱ��
	// webtest.enterFrame("iframe-6");
	// webtest.type("name=children[38]", "bk1");
	// webtest.type("name=children[39]", "bk2");
	// webtest.type("name=children[40]", "bk3");
	// webtest.leaveFrame();
	// }

//	 @Test
//	 public void deleteBumen() {
//	 // ɾ������
//		 webtest.enterFrame("iframe-6");
//	 webtest.click("xpath=html/body/nav[2]/ul/li[3]/a");
//	 webtest.leaveFrame();
//	 }

}
