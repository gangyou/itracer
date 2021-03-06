package com.eric.itracer.entity.embeded;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.codehaus.jackson.annotate.JsonProperty;

@Embeddable
public class CustomerInfo {
	@Column(name = "customer_id", length = 20, nullable = false, updatable = false)
	private String id;
	@Column(name = "customer_ip")
	private String ip;
	@Column(name = "customer_is_vip")
	private boolean isVip;

	public CustomerInfo(String id, String ip, boolean isVip) {
		super();
		this.id = id;
		this.ip = ip;
		this.isVip = isVip;
	}

	public CustomerInfo() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@JsonProperty("isVip")
	public boolean isVip() {
		return isVip;
	}

	@JsonProperty("isVip")
	public void setVip(boolean isVip) {
		this.isVip = isVip;
	}

}