package com.leasingauth.core;

import com.leasingauth.exception.model.LeasingAuthException;
import com.leasingauth.util.security.SecurityUtil;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LeasingAuthCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeasingAuthCoreApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		String i = SecurityUtil.KEY_TEST_v4;
		return modelMapper;
	}

	public void getTest() throws LeasingAuthException {
		// Do things...
	}

}
