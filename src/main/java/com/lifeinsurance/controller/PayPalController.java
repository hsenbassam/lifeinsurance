package com.lifeinsurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.lifeinsurance.payment.PayPalClient;

import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api/paypal")
public class PayPalController {

	@Autowired
	PayPalClient payPalClient;

	@PostMapping("/make/payment")
	public Map<String, Object> makePayment(@RequestParam("sum") String sum) {
		return payPalClient.createPayment(sum);
	}

	@PostMapping("/complete/payment")
	public Map<String, Object> completePayment(HttpServletRequest request, @RequestParam("paymentId") String paymentId,
			@RequestParam("payerId") String payerId) throws JsonGenerationException, JsonMappingException, IOException {
		return payPalClient.completePayment(request);
	}

}