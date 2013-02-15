package com.eric.itracer.entity.url;

import com.eric.itracer.entity.CustomerInfo;
import com.eric.itracer.entity.RequestHttpHeader;
import com.eric.itracer.entity.channel.Channel;

public class UrlRecord {

	// 客户渠道
	private Channel channel;
	private CustomerInfo customer = new CustomerInfo();
	private RequestHttpHeader httpHeader;
	// 当前页面url
	private String requestUrl;

	// 用户访问的时间
	private String time;

	public Channel getChannel() {
		return channel;
	}

	public CustomerInfo getCustomer() {
		return customer;
	}

	public RequestHttpHeader getHttpHeader() {
		return httpHeader;
	}

	public String getRequestUrl() {
		return requestUrl;
	}

	public String getTime() {
		return time;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public void setCustomer(CustomerInfo customer) {
		this.customer = customer;
	}

	public void setHttpHeader(RequestHttpHeader httpHeader) {
		this.httpHeader = httpHeader;
	}

	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
