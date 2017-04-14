package com.cloud.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.service.ComputeService;


@RestController
@RequestMapping(value="/compute")
public class ComputeController {
	
	private static Logger logger = Logger.getLogger(ComputeController.class);
	
	@Autowired
	ComputeService service;
	
	@Autowired
	DiscoveryClient client;
	
	@RequestMapping(value="/add" ,method=RequestMethod.GET)
	public double add(@RequestParam double a,@RequestParam double b){
		ServiceInstance instance = client.getLocalServiceInstance();
		logger.info("/add,host: "+instance.getHost()+instance.getPort());
//		double d = a+b;
		double d = service.add(a, b);
		return d;
	}
}
