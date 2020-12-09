package com.jrueda.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrueda.hrpayroll.entities.Payment;
import com.jrueda.hrpayroll.entities.Worker;
import com.jrueda.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {
	
	@Autowired
	private WorkerFeignClient workerFeignclient;
	
	public Payment getPayment(long workerId, int days) {
		
		Worker worker = workerFeignclient.findById(workerId).getBody();
		
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
	
}
