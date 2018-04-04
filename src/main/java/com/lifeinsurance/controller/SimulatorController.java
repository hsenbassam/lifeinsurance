package com.lifeinsurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lifeinsurance.model.Premium;
import com.lifeinsurance.model.Quote;
import com.lifeinsurance.service.SimulatorService;


@RestController
@RequestMapping(value = "/simulatorProcess", consumes = "application/json", produces = "application/json")
public class SimulatorController {
	
	@Autowired
	SimulatorService simulatorService;
	
	@PostMapping(value = "/term-life")
	public Premium getTermLifePremium(@RequestBody Quote quote) {
		return simulatorService.getTermLifePremium(quote);
	}
	
	@PostMapping(value = "/whole-life")
	public Premium getWholeLifePremium(@RequestBody Quote quote) {
		return simulatorService.getWholeLifePremium(quote);
	}

}
