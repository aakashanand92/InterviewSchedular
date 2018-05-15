package com.sapient.InterviewSchedular.rest;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(Endpoint.class);
		register(InterviewerEndPoint.class);
	}

}