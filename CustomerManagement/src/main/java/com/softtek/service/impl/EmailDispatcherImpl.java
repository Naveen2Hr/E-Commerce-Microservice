package com.softtek.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.softtek.entity.Customer;
import com.softtek.service.IEmailDispatcher;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * 
 * @author sagar.hr
 *
 */
@Service
public class EmailDispatcherImpl implements IEmailDispatcher {

	@Autowired
	private JavaMailSender mailSender;

	@Value("${spring.mail.username}")
	private String sendingEmailId;

	@Autowired
	private Configuration freemarkerConfig;

	@Override
	public String customerMailGenerator(Customer customer) throws Exception {
		// String mailBody = MailHelper.AssetMailBody(asset);
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);

		Map<String, Object> map = new HashMap<>();
		map.put("customer", customer);
		map.put("date", new Date().toString());

		freemarkerConfig.setClassForTemplateLoading(this.getClass(), "/EmailTemplate");

		Template template = freemarkerConfig.getTemplate("CustomerEmail.html");
		String msg = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);

		// setting the From Email Id.
		messageHelper.setFrom(sendingEmailId);

		// Setting the To Email Id.
		messageHelper.setTo(customer.getCustomerEmail());

		// Setting the CC Email Id and Array of String of Email Id
		messageHelper.setCc("hrnaveensagar1712@gmail.com");

		// Setting the Subject Of the Email
		messageHelper.setSubject("Asset Assigned Information");

		// Setting the sent-date of the message
		messageHelper.setSentDate(new Date());

		// Setting the content of the Email
		messageHelper.setText(msg, true);// set to HTML as true.

		// Sending the mail
		mailSender.send(mimeMessage);

		return "Mail Dispatched Successfully";
	}

}
