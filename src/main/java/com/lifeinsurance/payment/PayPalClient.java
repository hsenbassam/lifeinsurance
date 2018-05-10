package com.lifeinsurance.payment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.lifeinsurance.service.AwsEmailService;
import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

@Component
public class PayPalClient {

	private static final String SERVER = "http://ec2-13-59-138-79.us-east-2.compute.amazonaws.com/";

	// payment@lifeinsurance.com - Sandbox Account PayPal
	String clientId = "AV3W_WxYt-h8irbEpFmQJ-I4urvlFkmpXtmxkCjC3CNCTwn915JaK8-Go6uPUyQdBlleDgCpIMkWUqNk";
	String clientSecret = "EKHeoGQ0fBHltnDziXi887X6gGMi_5WiCpM43erfQnxtCs43BYkkn5udR-cydFwklSsTAqF5u6-yDbi-";

	@Autowired
	AwsEmailService awsEmailService;

	public Map<String, Object> createPayment(String sum) {
		Map<String, Object> response = new HashMap<String, Object>();
		Amount amount = new Amount();
		amount.setCurrency("USD");
		amount.setTotal(sum);
		Transaction transaction = new Transaction();
		transaction.setAmount(amount);
		List<Transaction> transactions = new ArrayList<Transaction>();
		transactions.add(transaction);

		Payer payer = new Payer();
		payer.setPaymentMethod("paypal");

		Payment payment = new Payment();
		payment.setIntent("sale");
		payment.setPayer(payer);
		payment.setTransactions(transactions);

		RedirectUrls redirectUrls = new RedirectUrls();
		redirectUrls.setCancelUrl(SERVER + "payment/confirm");
		redirectUrls.setReturnUrl(SERVER + "payment/process");
		payment.setRedirectUrls(redirectUrls);
		Payment createdPayment;
		try {
			String redirectUrl = "";
			APIContext context = new APIContext(clientId, clientSecret, "sandbox");
			createdPayment = payment.create(context);

			if (createdPayment != null) {
				List<Links> links = createdPayment.getLinks();
				for (Links link : links) {
					if (link.getRel().equals("approval_url")) {
						redirectUrl = link.getHref();
						break;
					}
				}
				response.put("status", "success");
				response.put("redirect_url", redirectUrl);
			}
		} catch (PayPalRESTException e) {
			System.out.println("Error happened during payment creation!");
			e.printStackTrace();
		}
		return response;
	}

	public Map<String, Object> completePayment(HttpServletRequest req) {
		Map<String, Object> response = new HashMap<String, Object>();
		Payment payment = new Payment();
		payment.setId(req.getParameter("paymentId"));
		PaymentExecution paymentExecution = new PaymentExecution();
		paymentExecution.setPayerId(req.getParameter("payerId"));
		try {
			APIContext context = new APIContext(clientId, clientSecret, "sandbox");
			Payment createdPayment = payment.execute(context, paymentExecution);
			Gson gson = new Gson();
			String createdPaymentJson = gson.toJson(createdPayment);
			if (createdPayment != null) {
				response.put("status", "success");
				response.put("payment", gson.fromJson(createdPaymentJson, Object.class));
				awsEmailService.withFrom("Life Insurance Team <husseinbassam95@gmail.com>")
						.withTo("husseinbassam95@gmail.com").withSubject("Life Insurance - Payment")
						.withBody(String.format(
								"Hi %s %s,<br><br> This is the receipt for a payment of $ %s (USD) for your Life Insurance products<br><br> Sincerely yours<br><br>Life Insurance Team",
								createdPayment.getPayer().getPayerInfo().getFirstName(),
								createdPayment.getPayer().getPayerInfo().getLastName(),
								createdPayment.getTransactions().get(0).getAmount().getTotal())).send();

			}
		} catch (PayPalRESTException e) {
			response.put("status", "failure");
			response.put("issue", e.getDetails());
			System.err.println(e.getDetails());
		}
		return response;
	}

}