package com.smarthive.model;

public class Device {
	
	private String id;
	private String type;
	private String status;
	
	public Device(String id, String type, String status) {
		super();
		this.id = id;
		this.type = type;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
		
}