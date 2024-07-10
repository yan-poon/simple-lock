package com.lionrockws.simple.lock.manager;

import org.springframework.stereotype.Component;

import com.lionrockws.simple.lock.service.CoinPriceUpdateService;

/**
 * Manages the process of updating coin prices using a pessimistic locking strategy.
 * This class implements {@link Runnable} to allow instances to be executed by threads,
 * simulating concurrent updates to coin prices in a multi-threaded environment.
 */
@Component
public class PessimisticLockCoinPriceManager implements Runnable {

	private CoinPriceUpdateService coinPriceUpdateService;

	/**
     * Constructs a new PessimisticLockCoinPriceManager with a specified {@link CoinPriceUpdateService}.
     * 
     * @param coinPriceUpdateService the service used to update coin prices with pessimistic locking.
     */
	public PessimisticLockCoinPriceManager(CoinPriceUpdateService coinPriceUpdateService) {
		super();
		this.coinPriceUpdateService = coinPriceUpdateService;
	}

	/**
     * Executes the update process in a loop, simulating multiple update attempts.
     * This method is called when the instance's thread is started, running a loop
     * that attempts to update coin prices using pessimistic locking through the {@link CoinPriceUpdateService}.
     * Each iteration represents an update attempt, and exceptions during the update process are caught and handled internally.
     */
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
