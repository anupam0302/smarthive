package com.smarthive.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototypeTask {

	public PrototypeTask() {
		System.out.println("New prototype instance created: "+this);
	}

}
