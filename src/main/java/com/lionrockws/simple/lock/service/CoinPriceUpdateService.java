package com.lionrockws.simple.lock.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.lionrockws.simple.lock.model.OptimisticLockCoinPrice;
import com.lionrockws.simple.lock.model.PessimisticLockCoinPrice;
import com.lionrockws.simple.lock.repository.OptimisticLockCoinPriceRepository;
import com.lionrockws.simple.lock.repository.PessimisticLockCoinPriceRepository;

@Service
public class CoinPriceUpdateService {

	private OptimisticLockCoinPriceRepository optimisticLockCoinPriceRepository;
	private PessimisticLockCoinPriceRepository pessimisticLockCoinPriceRepository;

	public CoinPriceUpdateService(OptimisticLockCoinPriceRepository optimisticLockCoinPriceRepository,
			PessimisticLockCoinPriceRepository pessimisticLockCoinPriceRepository) {
		super();
		this.optimisticLockCoinPriceRepository = optimisticLockCoinPriceRepository;
		this.pessimisticLockCoinPriceRepository = pessimisticLockCoinPriceRepository;
	}

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
