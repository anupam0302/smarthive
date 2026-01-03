package com.smarthive.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
public class HeavyAnalyticsService {
	
	public HeavyAnalyticsService() {
		System.out.println("HeavyAnalyticsService initialized, bean created: "+this);
	}
	
	public String analyze() {
		System.out.println("Analyzing the service");
		
		return "Running analysis";
	}

}
