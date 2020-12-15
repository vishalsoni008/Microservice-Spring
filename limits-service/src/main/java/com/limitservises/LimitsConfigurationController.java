package com.limitservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.limitservices.bean.LimitsConfiguration;

@RestController
public class LimitsConfigurationController {
	
	@Autowired
	private Configuration configuration;

	@GetMapping("/limits")
	public LimitsConfiguration retriveLiitsFromConfiguration() {
		return new LimitsConfiguration(configuration.getMaximun(),configuration.getMinimum());
	}
}
