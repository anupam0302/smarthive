package com.smarthive.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smarthive.model.Device;
import com.smarthive.service.DeviceService;

@RestController
@RequestMapping("/smarthive")
public class DeviceController {

	private DeviceService service;

	public DeviceController(DeviceService service) {
		this.service = service;
	}

	@PostMapping("/register/{id}/{type}")
	public String registerDevice(@PathVariable String id, @PathVariable String type) {
		String response = service.registerDevice(id, type);
		return response;
	}

	@PutMapping("/toggle/{id}")
	public String toggleDevice(@PathVariable String id) {
		String response = service.toggleDevice(id);
		return response;
	}

	@GetMapping("/power/light")
	public String powerLight() {
		String response = service.supplyPowerToLight();
		return response;
	}

	@GetMapping("/power/thermostat")
	public String powerTherostat() {
		String response = service.supplyPowerToThermostat();
		return response;
	}

	@GetMapping("/device/{id}")
	public Device getDevice(@PathVariable String id) {
		Device response = service.getDevice(id);
		return response;
	}

	@GetMapping("/analytics")
	public String runAnalytics() {
		String response = service.runAnalytics();
		return response;
	}

}
