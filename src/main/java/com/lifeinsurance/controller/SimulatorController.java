package com.lifeinsurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.lifeinsurance.model.Quote;
import com.lifeinsurance.service.SimulatorService;
import com.lifeinsurance.model.Premium;


@Controller
@RequestMapping(value = "/simulatorProcess", consumes = {"application/json"}, produces = {"application/json"})
public class SimulatorController {
	
	@Autowired
	SimulatorService simulatorService;
	
	@RequestMapping(value = "/term-life", method = RequestMethod.POST)
	public @ResponseBody Premium getTermLifePremium(@RequestBody Quote quote) {
		return simulatorService.getTermLifePremium(quote);
	}
	
	@RequestMapping(value = "/whole-life", method = RequestMethod.POST)
	public @ResponseBody Premium getWholeLifePremium(@RequestBody Quote quote) {
		return simulatorService.getWholeLifePremium(quote);
	}

}
