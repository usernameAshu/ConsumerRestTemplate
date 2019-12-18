package com.mohanty.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

	@Autowired
	private RestTemplate restTemplate;

	/**
	 * API: localhost:9091/consumer/public/all
	 * 
	 * @return
	 */
	@GetMapping(value = "/public/all")
	public List<Object> getAllCustomer() {

		String url = "http://localhost:9090/api/public/all";
		Object[] objects = restTemplate.getForObject(url, Object[].class);
		return Arrays.asList(objects);

	}

	 /**
	  * API: localhost:9091/consumer/public/welcome
	  * @return
	  */
	@GetMapping(value= "/public/welcome")
	public String welcomePage() {
		
		//Welcome page details
		return "Consumer App";
	}

}


