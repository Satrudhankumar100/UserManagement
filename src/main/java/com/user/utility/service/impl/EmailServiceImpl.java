package com.user.utility.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.user.utility.service.IEmailService;

import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmailServiceImpl implements IEmailService {

	@Autowired
	private JavaMailSender sender;

	@Override
	public boolean emailSend(String receiver, String subject, String body) {
		boolean isSend = false;

		try {

			MimeMessage mimeMsg = sender.createMimeMessage();

			MimeMessageHelper helper = new MimeMessageHelper(mimeMsg);
			helper.setFrom("satrukumarsecond@gmail.com");
			helper.setSubject(subject);
			helper.setText(body, true);
			helper.setTo(receiver);

			// sending email
			sender.send(mimeMsg);
			isSend = true;
			log.info(mimeMsg.toString());
		} catch (Exception e) {
			log.error("email send failed......==========");;
		}

		return isSend;
	}

}
