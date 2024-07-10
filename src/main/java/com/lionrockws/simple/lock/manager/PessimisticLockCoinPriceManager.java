package com.lionrockws.simple.lock.manager;

import org.springframework.stereotype.Component;

import com.lionrockws.simple.lock.service.CoinPriceUpdateService;

@Component
public class PessimisticLockCoinPriceManager implements Runnable {

	private CoinPriceUpdateService coinPriceUpdateService;

	public PessimisticLockCoinPriceManager(CoinPriceUpdateService coinPriceUpdateService) {
		super();
		this.coinPriceUpdateService = coinPriceUpdateService;
	}

	@Override
	public void run() {
		String managerName = "Manager " + Thread.currentThread().getName().toUpperCase();
		for (int i = 1; i <= 50; i++) {
			try {
				coinPriceUpdateService.updatePriceWithPessimisticLock(managerName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
