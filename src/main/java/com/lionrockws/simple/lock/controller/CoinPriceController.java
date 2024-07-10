package com.lionrockws.simple.lock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lionrockws.simple.lock.manager.OptimisticLockCoinPriceManager;
import com.lionrockws.simple.lock.manager.PessimisticLockCoinPriceManager;
import com.lionrockws.simple.lock.service.CoinPriceUpdateService;


/**
 * Controller for managing coin price updates using optimistic and pessimistic locking mechanisms.
 * This controller provides endpoints to start threads that simulate concurrent updates to coin prices
 * using both optimistic and pessimistic locking strategies.
 */
@RestController
public class CoinPriceController {

	@Autowired
	CoinPriceUpdateService coinPriceUpdateService;

	/**
     * Starts multiple threads to update coin prices using optimistic locking.
     * This method initializes and starts four threads, each executing an instance of {@link OptimisticLockCoinPriceManager},
     * which simulates concurrent updates to coin prices using optimistic locking.
     *
     * @return A simple string indicating that the threads have been started.
     */
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
	
	/**
     * Starts multiple threads to update coin prices using pessimistic locking.
     * Similar to {@link #startUpdateOptimisticLockCoinPrice()}, this method initializes and starts four threads,
     * each executing an instance of {@link PessimisticLockCoinPriceManager}, which simulates concurrent updates
     * to coin prices using pessimistic locking.
     *
     * @return A simple string indicating that the threads have been started.
     */
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
