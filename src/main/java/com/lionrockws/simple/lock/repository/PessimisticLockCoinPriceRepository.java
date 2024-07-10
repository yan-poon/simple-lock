package com.lionrockws.simple.lock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import com.lionrockws.simple.lock.model.PessimisticLockCoinPrice;
import java.util.Optional;

import javax.persistence.LockModeType;



@Repository
public interface PessimisticLockCoinPriceRepository extends JpaRepository<PessimisticLockCoinPrice, Long> {
	
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	Optional<PessimisticLockCoinPrice> findById(long id);
	
}
