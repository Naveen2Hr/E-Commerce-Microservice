package com.shr.service.impl;


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

import com.shr.entity.Order;
import com.shr.service.IEmailDispactherOrder;

import freemarker.template.Configuration;
import freemarker.template.Template;
/**
 * 
 * @author m.rakesh
 *
 */
@Service
public class EmailDispactherOrderImpl implements IEmailDispactherOrder {

	@Autowired
	private JavaMailSender mailSender;

	@Value("${spring.mail.username}")
	private String sendingEmailId;
	
	@Autowired
	private Configuration freemarkerConfig;
	
//	@Autowired
//	private Customer customer;
//	

	@Override
	public String orderConfirmation(Order order) throws Exception {
		// String mailBody = MailHelper.AssetMailBody;
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("order",order);
		map.put("date", new Date().toString());

		freemarkerConfig.setClassForTemplateLoading(this.getClass(), "/EmailSender");

		Template template = freemarkerConfig.getTemplate("OrderConfirmation.html");
		String msg = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);

		// setting the From Email Id.
		messageHelper.setFrom(sendingEmailId);

		// Setting the To Email Id.
		messageHelper.setTo(order.getCustomer().getCustomerEmail());

		// Setting the CC Email Id and Array of String of Email Id
		messageHelper.setCc("rakeshamnaik@gmail.com");

		// Setting the Subject Of the Email
		messageHelper.setSubject("Dear Customer your Order Summary");

		// Setting the sent-date of the message
		messageHelper.setSentDate(new Date());

		// Setting the content of the Email
		messageHelper.setText(msg, true);// set to HTML as true.

		// Sending the mail
		mailSender.send(mimeMessage);

		return "Mail Dispatched Successfully";

		
	}

}
