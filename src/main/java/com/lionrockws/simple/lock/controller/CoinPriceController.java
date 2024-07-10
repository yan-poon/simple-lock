package com.lionrockws.simple.lock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lionrockws.simple.lock.manager.OptimisticLockCoinPriceManager;
import com.lionrockws.simple.lock.manager.PessimisticLockCoinPriceManager;
import com.lionrockws.simple.lock.service.CoinPriceUpdateService;

@RestController
public class CoinPriceController {

	@Autowired
	CoinPriceUpdateService coinPriceUpdateService;

	@GetMapping("/optimistic-lock/start")
	public String startUpdateOptimisticLockCoinPrice() {
		Thread t1 = new Thread(new OptimisticLockCoinPriceManager(coinPriceUpdateService), "t1");
		Thread t2 = new Thread(new OptimisticLockCoinPriceManager(coinPriceUpdateService), "t2");
		Thread t3 = new Thread(new OptimisticLockCoinPriceManager(coinPriceUpdateService), "t3");
		Thread t4 = new Thread(new OptimisticLockCoinPriceManager(coinPriceUpdateService), "t4");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		return "Started";
	}
	
	@GetMapping("/pessimistic-lock/start")
	public String startUpdatePessmisticLockCoinPrice() {
		Thread t1 = new Thread(new PessimisticLockCoinPriceManager(coinPriceUpdateService), "t1");
		Thread t2 = new Thread(new PessimisticLockCoinPriceManager(coinPriceUpdateService), "t2");
		Thread t3 = new Thread(new PessimisticLockCoinPriceManager(coinPriceUpdateService), "t3");
		Thread t4 = new Thread(new PessimisticLockCoinPriceManager(coinPriceUpdateService), "t4");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		return "Started";
	}

}
