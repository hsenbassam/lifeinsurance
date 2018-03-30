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
@RequestMapping(value = "/api/paypal")
public class PayPalController {

    private final PayPalClient payPalClient;
    @Autowired
    PayPalController(PayPalClient payPalClient){
        this.payPalClient = payPalClient;
    }


    @PostMapping(value = "/make/payment")
    public Map<String, Object> makePayment(@RequestParam("sum") String sum){
        return payPalClient.createPayment(sum);
    }

   
    @PostMapping(value = "/complete/payment")
    public Map<String, Object> completePayment(HttpServletRequest request, @RequestParam("paymentId") String paymentId, @RequestParam("payerId") String payerId) throws JsonGenerationException, JsonMappingException, IOException{
        return payPalClient.completePayment(request);
    }


}