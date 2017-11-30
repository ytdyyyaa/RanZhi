package com.sendmail;

import javax.mail.MessagingException;

public class sendmailTest {
	Mail mail = null;
	public void sendMail(String title,String content) throws MessagingException{
		mail = new Mail();
		mail.setMessage(title, content);
		mail.addToRecipent("1497277185@qq.com");
//		mail.addToRecipent("收件人地址2");
		mail.sendMail("dycn993@126.com", "superjuniorlj1", "冀晋文");
	}
}
