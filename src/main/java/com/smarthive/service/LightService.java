package com.smarthive.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class LightService implements PowerService {

	@Override
	public String supplyPower() {
		return "Started light service.";
	}
	
}
