package com.report.util;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtils {
	@Autowired
	
	private JavaMailSender javamailSender;
	
	public boolean sendMail(String subject,String body,String to,File f)
	{
		try {
			MimeMessage mineMsg=javamailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(mineMsg,true);
			helper.setSubject(subject);
			helper.setText(body, true);
			helper.setTo("manonmani.pandukumar@gmail.com");
			helper.addAttachment("Plan-Info", f);
			javamailSender.send(mineMsg);
		}
		catch(Exception e)
		{
			
		}
		return true;
	}

}
