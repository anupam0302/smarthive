package com.smarthive.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.smarthive.model.Device;

@Repository
public class DeviceRepository {
	
	private Map<String, Device> store = new HashMap<String, Device>();
	
	public void save(Device device) {
		store.put(device.getId(), device);
	}
	
	public Device findDeviceById(String id) {
		return store.get(id);
	}
	
	public Collection<Device> findAllDevices(){
		return store.values();
	}

}
