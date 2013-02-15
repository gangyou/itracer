package com.eric.itracer.entity.click;

import java.util.Date;

import com.eric.itracer.entity.CustomerInfo;

public class ClickRecord {
	private String locationUrl;
	private Date time;
	private CustomerInfo cusomter;

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
		return cusomter;
	}
	public void setCusomter(CustomerInfo cusomter) {
		this.cusomter = cusomter;
	}
	
}
