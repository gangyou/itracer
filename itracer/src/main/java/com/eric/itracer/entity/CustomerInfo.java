package com.eric.itracer.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "customers")
public class CustomerInfo implements Serializable {
	private static final long serialVersionUID = 7610606119104034172L;
	@GenericGenerator(name = "customer_generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "customer_generator")
	@Column(name = "id", unique = true, nullable = false)
	private long id;

	@Column(length = 20)
	private String idInEbank;
	private String ip;
	private boolean isVip;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIdInEbank() {
		return idInEbank;
	}

	public void setIdInEbank(String idInEbank) {
		this.idInEbank = idInEbank;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public boolean isVip() {
		return isVip;
	}

	public void setVip(boolean isVip) {
		this.isVip = isVip;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}