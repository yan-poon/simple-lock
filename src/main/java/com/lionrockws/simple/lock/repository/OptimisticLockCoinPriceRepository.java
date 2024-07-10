package com.lionrockws.simple.lock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lionrockws.simple.lock.model.OptimisticLockCoinPrice;

@Repository
public interface OptimisticLockCoinPriceRepository extends JpaRepository<OptimisticLockCoinPrice, Long> {

}
