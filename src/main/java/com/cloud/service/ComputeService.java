package com.cloud.service;

import org.springframework.stereotype.Service;


@Service
public class ComputeService {
	public double add(double a, double b){
		double d = a+b;
		return d;
	}
}
