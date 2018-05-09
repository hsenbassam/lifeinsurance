package com.lifeinsurance.service;

public interface AwsEmailService {
	
	void setFrom(String from);
	void setTo(String to);
	void setSubject(String subject);
	void setBody(String body);
	
	void send();
	
	AwsEmailService withFrom(String from);
	AwsEmailService withTo(String to);
	AwsEmailService withSubject(String subject);
	AwsEmailService withBody(String body);

}
