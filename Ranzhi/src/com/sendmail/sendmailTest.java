package com.sendmail;

import javax.mail.MessagingException;

public class sendmailTest {
	Mail mail = null;

	public void sendMail(String title, String content) throws MessagingException {
		mail = new Mail();
		// 邮件标题和内容
		mail.setMessage(title, content);
		// 收件人邮箱地址
		mail.addToRecipent("1497277185@qq.com");
		// mail.addToRecipent("收件人地址2");
		// 发送邮件的邮箱账号，密码，别名
		mail.sendMail("dycn993@126.com", "superjuniorlj1", "冀晋文");
	}
}
