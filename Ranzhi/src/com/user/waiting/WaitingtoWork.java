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
		assertTrue(webtest.getHtmlSource().contains("签退"));
		webtest.click("xpath=.//*[@id='mainNavbar']/div/ul[2]/li[1]/a");
	}

	@Test(priority = 0)
	public void OpenAddName() {
		// 点击日历中某一天，进入到批量添加待办的页面
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//span[@class='text-muted icon-plus']");
		// 选择项目类型
		webtest.getSelect("xpath=.//*[@id='types0']").selectByVisibleText("项目任务");
		// 选择优先级
		webtest.getSelect("xpath=.//*[@id='pris0']").selectByVisibleText("最高");
		// 选择指派给谁
		webtest.getSelect("xpath=.//*[@id='assignedTo0']").selectByVisibleText("吴世勋");
		// 输入描述
		webtest.type("xpath=.//*[@id='descs[0]']", "该项目指派给吴世勋");
		// 选择待定单选框
		webtest.click("xpath=.//*[@id='switchDate0']");
		// 点击保存按钮
		webtest.click("xpath=.//*[@id='submit']");
		webtest.leaveFrame();
	}

	@Test(priority = 1)
	public void unfinishedWork() {
		webtest.enterFrame("iframe-dashboard");
		// 点击待办，进入待办主页
		webtest.click("link=待办");
		// 查看未完成的任务
		webtest.click("link=与客户取得联系");
		// 点击编辑未完成任务的按钮
		webtest.click("link=编辑");
		// 修改优先级
		webtest.selectByValue("name=pri", "3");
		// 选择状态
		webtest.selectByIndex("name=status", 0);
		// 选择起止时间
		webtest.selectByIndex("id=begin", 5);
		webtest.selectByIndex("id=end", 7);
		webtest.click("xpath=.//*[@id='submit']");
		webtest.leaveFrame();
	}

	@Test(priority = 2)
	public void all() {
		webtest.enterFrame("iframe-dashboard");
		// 点击待办，进入待办主页
		webtest.click("link=待办");
		// 查看所有待办项目
		webtest.click("link=所有");
		webtest.leaveFrame();
	}

	@Test(dependsOnMethods = "all")
	public void zhipai() {
		// 将任务指派给某人
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
		// 点击待办，进入待办主页
		webtest.click("link=待办");
		// 查看指派他人待办项目
		webtest.click("link=指派他人");
		webtest.leaveFrame();
	}

	@Test(priority = 4)
	public void me() {
		webtest.enterFrame("iframe-dashboard");
		// 点击待办，进入待办主页
		webtest.click("link=待办");
		// 查看指派给我待办项目
		webtest.click("link=指派给我");
		webtest.leaveFrame();
	}

	@Test(priority = 5)
	public void unfinished() {
		webtest.enterFrame("iframe-dashboard");
		// 点击待办，进入待办主页
		webtest.click("link=待办");
		// 查看未完成待办项目
		webtest.click("link=未完成");
		webtest.leaveFrame();
	}

	@Test(priority = 6)
	public void daiding() {
		webtest.enterFrame("iframe-dashboard");
		// 点击待办，进入待办主页
		webtest.click("link=待办");
		// 查看待定待办项目
		webtest.click("link=待定");
		webtest.leaveFrame();
	}

	@Test(priority = 7)
	public void changeFinish() {
		// 将任务状态修改为完成
		webtest.enterFrame("iframe-dashboard");
		// 点击待办，进入待办主页
		webtest.click("link=待办");
		webtest.click("link=所有");
		webtest.click("xpath=.//*[@id='todoList']/tbody/tr[5]/td[10]/a[2]");
		webtest.leaveFrame();
	}

	@Test(priority = 8)
	public void changeOpen() {
		// 激活已完成的任务
		webtest.enterFrame("iframe-dashboard");
		// 点击待办，进入待办主页
		webtest.click("link=待办");
		webtest.click("link=所有");
		webtest.click("xpath=.//*[@id='todoList']/tbody/tr[6]/td[10]/a[4]");
		webtest.leaveFrame();
	}

}
