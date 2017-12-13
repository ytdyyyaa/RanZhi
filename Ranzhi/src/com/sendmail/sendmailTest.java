package com.sendmail;

import javax.mail.MessagingException;

public class sendmailTest {
	Mail mail = null;
	public void sendMail(String title, String content,String recive) throws MessagingException {
		mail = new Mail();
	
		mail.setMessage(title, content);
		mail.addAttachment
		("¸½¼þ", 
				"F:\\da3shang\\shixun\\Ranzhi\\zip\\zip.zip");
			
		mail.addToRecipent(recive);
		
		mail.sendMail("dycn993@126.com", "superjuniorlj1", "jijinwen");
		
	}
	
	public static void main(String args[]) throws MessagingException{
		sendmailTest mail = new sendmailTest();
		mail.sendMail("report","success","1497277185@qq.com");
		
	}
}
