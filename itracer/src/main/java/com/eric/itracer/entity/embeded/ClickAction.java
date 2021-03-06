package com.eric.itracer.entity.embeded;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class ClickAction {
	@Column(name = "click_location_url")
	private String locationUrl;
	@Column(name = "click_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date time;
	@Embedded
	private CustomerInfo customer;

	public ClickAction(String locationUrl, Date time, CustomerInfo customer) {
		super();
		this.locationUrl = locationUrl;
		this.time = time;
		this.customer = customer;
	}

	public ClickAction() {
	}

	public String getLocationUrl() {
		return locationUrl;
	}

	public void setLocationUrl(String locationUrl) {
		this.locationUrl = locationUrl;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public CustomerInfo getCusomter() {
		return customer;
	}

	public void setCusomter(CustomerInfo cusomter) {
		this.customer = cusomter;
	}

}
