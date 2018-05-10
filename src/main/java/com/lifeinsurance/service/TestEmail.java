package com.lifeinsurance.service;


import com.lifeinsurance.utils.AwsUtils;

public class TestEmail {

	private void sendTestMail() {


		AwsEmailService awsEmailService = new AwsEmailServiceImpl(AwsUtils.createSimpleEmailService());
		awsEmailService.withFrom("Life Insurance <husseinbassam95@gmail.com>").withTo("husseinbassam95@gmail.com")
				.withSubject("Email from AWS").withBody("Dear Sir or Madam <br><br> You Just pay for a product").send();
	}

	public static void main(String[] args) {
		new TestEmail().sendTestMail();
		
	}

}
