package com.sendmail;

import java.io.File;

import java.io.IOException;

import java.io.InputStream;

import java.io.OutputStream;

import java.util.Enumeration;

import java.util.Properties;

import javax.activation.DataHandler;

import javax.activation.DataSource;

import javax.activation.FileDataSource;

import javax.mail.Address;

import javax.mail.BodyPart;

import javax.mail.Header;

import javax.mail.Message;

import javax.mail.MessagingException;

import javax.mail.Multipart;

import javax.mail.MultipartDataSource;

import javax.mail.Session;

import javax.mail.Transport;

import javax.mail.internet.AddressException;

import javax.mail.internet.InternetAddress;

import javax.mail.internet.MimeBodyPart;

import javax.mail.internet.MimeMessage;

import javax.mail.internet.MimeMultipart;

import com.webtest.util.Log;

public class Mail {

	Properties props = null;

	Session session = null;

	Message message = null;

	Multipart multipart = null;

	public Mail() {

		props = System.getProperties();

		props.put("mail.smtp.host", "smtp.126.com");

		props.put("mail.smtp.auth", "true");

		props.put("mail.debug", "true");

		session = Session.getDefaultInstance(props);

		message = new MimeMessage(session);

		multipart = new MimeMultipart();

	}

	public void setMessage(String subject, String msg) throws MessagingException {

		message.setSubject(subject);

		BodyPart text = new MimeBodyPart();

		text.setText(msg);

		multipart.addBodyPart(text);

		message.setContent(multipart);

	}

	public void addToRecipent(String address) throws AddressException, MessagingException {

		message.addRecipient(Message.RecipientType.TO, new InternetAddress(address));

	}

	public void addCCRecipent(String address) throws MessagingException {

		message.addRecipient(Message.RecipientType.CC, new InternetAddress(address));

	}

	public void addBccRecipent(String address) throws MessagingException {

		message.addRecipient(Message.RecipientType.BCC, new InternetAddress(address));

	}

	public void addAttachment(String fileName, String filePath) throws MessagingException {

		BodyPart attachment = new MimeBodyPart();

		DataSource file = new FileDataSource(new File(filePath));

		attachment.setDataHandler(new DataHandler(file));

		attachment.setFileName(fileName);

		multipart.addBodyPart(attachment);

		message.setContent(multipart);

	}

	public void sendMail(String user, String password, String alia) throws AddressException, MessagingException {

		message.setFrom(new InternetAddress(user));

		message.setHeader(user, alia);

		Transport transport = session.getTransport();

		transport.connect(user, password);

		transport.sendMessage(message, message.getAllRecipients());

		Log.info("E-mail send");

	}

}
