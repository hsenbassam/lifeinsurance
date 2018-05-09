package com.lifeinsurance.utils;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;

public class AwsUtils {

	public static AWSCredentialsProvider getCredentials() {
		

		final String ACCESS_KEY = "AKIAJ66OE6DBXBJV2O2Q";
		final String SECRET_KEY = "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";

		AWSCredentials credentials = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
		return new AWSCredentialsProvider() {

			@Override
			public void refresh() {
				// TODO Auto-generated method stub
			}

			@Override
			public AWSCredentials getCredentials() {
				return credentials;
			}
		};
	}

	public static AmazonSimpleEmailService createSimpleEmailService() {

		AmazonSimpleEmailService client = AmazonSimpleEmailServiceClientBuilder.standard()
				.withCredentials(AwsUtils.getCredentials()).withRegion(Regions.US_EAST_1).build();
		return client;

	}

}