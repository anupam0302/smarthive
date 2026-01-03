package com.smarthive.service;

import org.springframework.stereotype.Service;

@Service("thermostatspower")
public class ThermostatService implements PowerService {
	
	@Override
	public String supplyPower() {
		return "Started thermostat service.";
	}

}
