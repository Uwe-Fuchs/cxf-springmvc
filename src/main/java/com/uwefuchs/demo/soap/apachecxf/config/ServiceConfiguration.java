package com.uwefuchs.demo.soap.apachecxf.config;

import org.apache.cxf.bus.spring.SpringBus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {
	@Bean
	public SpringBus springBus() {
	    return new SpringBus();
	}
	
	
}