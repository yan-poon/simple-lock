package com.lionrockws.simple.lock.manager;

import org.springframework.stereotype.Component;

import com.lionrockws.simple.lock.service.CoinPriceUpdateService;

@Component
public class OptimisticLockCoinPriceManager implements Runnable {

	private CoinPriceUpdateService coinPriceUpdateService;

	public OptimisticLockCoinPriceManager(CoinPriceUpdateService coinPriceUpdateService) {
		super();
		this.coinPriceUpdateService = coinPriceUpdateService;
	}

	@Override
	public void run() {
		String managerName = "Manager " + Thread.currentThread().getName().toUpperCase();
		for (int i = 1; i <= 50; i++) {
			try {
				coinPriceUpdateService.updatePriceWithOptimisticLock(managerName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
