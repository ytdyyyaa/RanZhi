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
		// 点击待办，点击日历中某一天，进入到批量添加待办的页面
		webtest.click("xpath=.//*[@id='mainNavbar']/div/ul[2]/li[1]/a");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//span[@class='text-muted icon-plus']");
		webtest.leaveFrame();
	}

	@Test
	public void OpenAddName() {
		// 选择项目类型
		webtest.enterFrame("iframe-dashboard");
		webtest.getSelect("xpath=.//*[@id='types0']").selectByVisibleText("项目任务");
		webtest.leaveFrame();
		// 名称的下拉表单操作失败
		// webtest.enterFrame("iframe-dashboard");
		// webtest.getSelect("xpath=.//*[@id='idvalues1_chosen']/a/div").selectByVisibleText("的
		// / 第二个任务");
		// webtest.leaveFrame();
	}

	@Test
	public void selectfirst() {
		// 选择优先级
		webtest.enterFrame("iframe-dashboard");
		webtest.getSelect("xpath=.//*[@id='pris0']").selectByVisibleText("最高");
		webtest.leaveFrame();
	}

	@Test
	public void selectwho() {
		// 选择指派给谁
		webtest.enterFrame("iframe-dashboard");
		webtest.getSelect("xpath=.//*[@id='assignedTo0']").selectByVisibleText("吴世勋");
		webtest.leaveFrame();
	}

	@Test
	public void typedescribe() {
		// 输入描述
		webtest.enterFrame("iframe-dashboard");
		webtest.type("xpath=.//*[@id='descs[0]']", "该项目指派给吴世勋");
		webtest.leaveFrame();
	}

	@Test
	public void selectdaiding() {
		// 选择待定单选框
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=.//*[@id='switchDate0']");
		webtest.leaveFrame();
	}

	@AfterTest
	public void clicksubmit() {
		// 点击保存按钮
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=.//*[@id='submit']");
		webtest.leaveFrame();
	}

}
