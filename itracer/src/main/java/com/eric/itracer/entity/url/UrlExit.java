package com.eric.itracer.entity.url;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.eric.itracer.entity.embeded.Channel;
import com.eric.itracer.entity.embeded.CustomerInfo;
import com.eric.itracer.entity.embeded.HttpHeader;

@Entity
@DiscriminatorValue("url_exit")
public class UrlExit extends UrlVisit {

	public UrlExit() {
	}

	public UrlExit(Channel channel, CustomerInfo customer,
			HttpHeader httpHeader, String requestUrl, Date time) {
		super(channel, customer, httpHeader, requestUrl, time);
	}

	private static final long serialVersionUID = -6419926766822982230L;
}
