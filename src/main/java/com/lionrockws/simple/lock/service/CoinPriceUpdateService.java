package com.lionrockws.simple.lock.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.lionrockws.simple.lock.model.OptimisticLockCoinPrice;
import com.lionrockws.simple.lock.model.PessimisticLockCoinPrice;
import com.lionrockws.simple.lock.repository.OptimisticLockCoinPriceRepository;
import com.lionrockws.simple.lock.repository.PessimisticLockCoinPriceRepository;

/**
 * Service class for updating coin prices with optimistic and pessimistic locking mechanisms.
 * This service provides methods to update coin prices in a database, using either optimistic
 * or pessimistic locking strategies to handle concurrent updates safely.
 */
@Service
public class CoinPriceUpdateService {

	/**
     * Constructs a new CoinPriceUpdateService with specified repositories.
     * This constructor injects the repositories used for optimistic and pessimistic locking
     * of coin prices into the service.
     *
     * @param optimisticLockCoinPriceRepository the repository for optimistic locking operations.
     * @param pessimisticLockCoinPriceRepository the repository for pessimistic locking operations.
     */
	private OptimisticLockCoinPriceRepository optimisticLockCoinPriceRepository;
	private PessimisticLockCoinPriceRepository pessimisticLockCoinPriceRepository;

	public CoinPriceUpdateService(OptimisticLockCoinPriceRepository optimisticLockCoinPriceRepository,
			PessimisticLockCoinPriceRepository pessimisticLockCoinPriceRepository) {
		super();
		this.optimisticLockCoinPriceRepository = optimisticLockCoinPriceRepository;
		this.pessimisticLockCoinPriceRepository = pessimisticLockCoinPriceRepository;
	}

	/**
	 * Updates the price of a coin using an optimistic locking mechanism.
	 * This method simulates a delay (to mimic processing time or network latency), retrieves a coin price,
	 * randomly adjusts its price, increments its version to simulate an optimistic lock, and finally saves the updated coin price.
	 * The method demonstrates handling of concurrent modifications in a scenario where multiple transactions
	 * are attempting to update the same entity.
	 *
	 * @param managerName the name of the manager (or thread) performing the update, used for logging purposes.
	 * @throws InterruptedException if the thread is interrupted while sleeping.
	 */
	@Transactional
	public void updatePriceWithOptimisticLock(String managerName) throws InterruptedException {
		Thread.sleep((long) (Math.random() * 5000));
		OptimisticLockCoinPrice coinPrice = optimisticLockCoinPriceRepository.findById((long) 1).get();
		System.out.println(managerName + " Before: " + coinPrice.toString());
		if (Math.random() > 0.5) {
			coinPrice.setPrice((float) (1 + (Math.random() / 1000)));
		} else {
			coinPrice.setPrice((float) (1 - (Math.random() / 1000)));
		}
		long version = coinPrice.getVersion() + 1;
		coinPrice.setVersion(version);
		coinPrice.setLocalDateTime(LocalDateTime.now());
		coinPrice.setUpdatedBy(managerName);
		optimisticLockCoinPriceRepository.save(coinPrice);
		System.out.println(managerName + " After: " + coinPrice.toString());
	}

	/**
	 * Updates the price of a coin using a pessimistic locking mechanism.
	 * This method simulates a delay (to mimic processing time or network latency), retrieves a coin price,
	 * randomly adjusts its price, increments its version to simulate an optimistic lock, and finally saves the updated coin price.
	 * The method demonstrates handling of concurrent modifications in a scenario where multiple transactions
	 * are attempting to update the same entity.
	 *
	 * @param managerName the name of the manager (or thread) performing the update, used for logging purposes.
	 * @throws InterruptedException if the thread is interrupted while sleeping.
	 */
	@Transactional
	public void updatePriceWithPessimisticLock(String managerName) throws InterruptedException {
		Thread.sleep((long) (Math.random() * 5000));
		PessimisticLockCoinPrice coinPrice = pessimisticLockCoinPriceRepository.findById((long) 1).get();
		System.out.println(managerName + " Before: " + coinPrice.toString());
		if (Math.random() > 0.5) {
			coinPrice.setPrice((float) (1 + (Math.random() / 1000)));
		} else {
			coinPrice.setPrice((float) (1 - (Math.random() / 1000)));
		}
		long version = coinPrice.getVersion() + 1;
		coinPrice.setVersion(version);
		coinPrice.setLocalDateTime(LocalDateTime.now());
		coinPrice.setUpdatedBy(managerName);
		pessimisticLockCoinPriceRepository.save(coinPrice);
		System.out.println(managerName + " After: " + coinPrice.toString());
	}

}
