package com.lionrockws.simple.lock.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class OptimisticLockCoinPrice {

	@Id
	long id;
	LocalDateTime localDateTime;
	long coinId;
	float price;
	@Version
	long version;
	String updatedBy;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	public long getCoinId() {
		return coinId;
	}

	public void setCoinId(long coinId) {
		this.coinId = coinId;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Override
	public String toString() {
		return "OptimisticLockCoinPrice [id=" + id + ", localDateTime=" + localDateTime + ", coinId=" + coinId
				+ ", price=" + price + ", version=" + version + ", updatedBy=" + updatedBy + ", getId()=" + getId()
				+ ", getLocalDateTime()=" + getLocalDateTime() + ", getCoinId()=" + getCoinId() + ", getPrice()="
				+ getPrice() + ", getVersion()=" + getVersion() + ", getUpdatedBy()=" + getUpdatedBy() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
