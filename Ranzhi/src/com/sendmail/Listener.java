package com.sendmail;

import javax.mail.MessagingException;

import org.testng.ITestContext;
import org.testng.ITestResult;

import org.testng.TestListenerAdapter;

import com.webtest.util.Log;

public class Listener extends TestListenerAdapter {

	@Override

	public void onTestSuccess(ITestResult result) {

		String msg = result.getName() + " successed";

		Log.info(msg);

	}

	@Override

	public void onTestFailure(ITestResult result) {

		String msg = result.getName() + " failed";
		sendmailTest a = new sendmailTest();
		try {
			// 发送邮件的标题和内容
			a.sendMail("运行失败的方法是：", msg, "1497277185@qq.com");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Log.info(msg);

	}

	@Override

	public void onTestSkipped(ITestResult result) {

		String msg = result.getName() + " skipped";

		Log.info(msg);

	}

	@Override
	public void onFinish(ITestContext testContext) {
		// TODO Auto-generated method stub
		super.onFinish(testContext);

	}

}
