package com.lifeinsurance.service;

import java.util.Arrays;
import java.util.List;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;

public class AwsEmailServiceImpl implements AwsEmailService {
	
	private String from, to, subject, body;
	private AmazonSimpleEmailService simpleEmailService;
	
	public AwsEmailServiceImpl(AmazonSimpleEmailService simpleEmailService) {
		this.simpleEmailService = simpleEmailService;
	}

	@Override
	public void setFrom(String from) {
		this.from = from;
	}

	@Override
	public void setTo(String to) {
		this.to = to;

	}

	@Override
	public void setSubject(String subject) {
		this.subject = subject;

	}

	@Override
	public void setBody(String body) {
		this.body = body;

	}

	@Override
	public void send() {
		Destination destination = new Destination(getToAsList());
		SendEmailRequest request = new SendEmailRequest(from, destination, createMessage());
		simpleEmailService.sendEmail(request);
		System.out.println("Success");

	}
	
	private Message createMessage() {
		Body awsbody = new Body();
		awsbody.setText(new Content(body));
		Message message = new Message(new Content(subject), awsbody);
		return message;
	}
	
	private List<String> getToAsList() {
		return Arrays.asList(to.split(","));
	}


	@Override
	public AwsEmailService withFrom(String from) {
		this.from = from;
		return this;
	}

	@Override
	public AwsEmailService withTo(String to) {
		this.to = to;
		return this;
	}

	@Override
	public AwsEmailService withSubject(String subject) {
		this.subject = subject;
		return this;
	}

	@Override
	public AwsEmailService withBody(String body) {
		this.body = body;
		return this;
	}
	
	
}
