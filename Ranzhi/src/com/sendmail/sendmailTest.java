package com.sendmail;

import javax.mail.MessagingException;

public class sendmailTest {
	Mail mail = null;

	public void sendMail(String title, String content) throws MessagingException {
		mail = new Mail();
		// �ʼ����������
		mail.setMessage(title, content);
		// �ռ��������ַ
		mail.addToRecipent("1497277185@qq.com");
		// mail.addToRecipent("�ռ��˵�ַ2");
		// �����ʼ��������˺ţ����룬����
		mail.sendMail("dycn993@126.com", "superjuniorlj1", "������");
	}
}
