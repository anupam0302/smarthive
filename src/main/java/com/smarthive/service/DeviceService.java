package com.smarthive.service;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.smarthive.model.Device;
import com.smarthive.repository.DeviceRepository;
import com.smarthive.util.Constants;

@Service
public class DeviceService {

	private DeviceRepository deviceRepository;
	private PowerService lightService;
	private PowerService thermostatService;
	private HeavyAnalyticsService heavyAnalyticsService;
	private ObjectProvider<PrototypeTask> taskProvider;

	public DeviceService(DeviceRepository deviceRepository, PowerService lightService, @Qualifier("thermostatspower") PowerService thermostatService,
			HeavyAnalyticsService heavyAnalyticsService, ObjectProvider<PrototypeTask> taskProvider) {
		this.deviceRepository = deviceRepository;
		this.lightService = lightService;
		this.thermostatService = thermostatService;
		this.heavyAnalyticsService = heavyAnalyticsService;
		this.taskProvider = taskProvider;
	}

	public String registerDevice(String id, String type) {
		taskProvider.getObject();

		Device device = new Device(id, type, "OFF");
		deviceRepository.save(device);

		return Constants.REGISTERED_SUCCESSFULLY_MSG;
	}

	public String toggleDevice(String id) {

		Device device = deviceRepository.findDeviceById(id);
		if (device == null) {
			return Constants.DEVICE_NOT_FOUND;
		}

		device.setStatus(Constants.STATUS_ON);
		deviceRepository.save(device);

		return Constants.DEVICE_TOGGLED;
	}

	public String supplyPowerToLight() {
		return lightService.supplyPower();
	}

	public String supplyPowerToThermostat() {
		return thermostatService.supplyPower();
	}

	public String runAnalytics() {
		return heavyAnalyticsService.analyze();
	}

	public Device getDevice(String id) {
		return deviceRepository.findDeviceById(id);
	}
}
